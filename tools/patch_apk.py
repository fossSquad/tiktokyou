#!/usr/bin/env python3
"""Patch an APK with the rebuilt mod: stable dex + bundled payload dex.

  1. Copy the mod's non-dex additions (manifest, resources, assets, native
     libs) from a reference mod APK onto the target. Reference resolution:
     --ref, else the target itself when it already contains the mod, else the
     newest TikTok_You-*.apk in the project root.
  2. Inject the rebuilt stable dex:
       shift  - target already contains the mod: the original classes*.dex are
                shifted up by one, the rebuilt dex becomes classes.dex
                (shadows the old code);
       append - vanilla target: the rebuilt dex is added as classes{N+1}.dex.
     Reference dexes providing the ni.shikatu shim are carried over when the
     target lacks them, so the payload resolves its runtime dependencies.
  3. Replace assets/tty/bundled/classes.dex with the rebuilt payload dex and
     rewrite assets/tty/bundled/manifest.json hashes/sizes.
  4. zipalign + apksigner (debug keystore) + verify.

Usage:
  python3 tools/patch_apk.py <target.apk> [--ref <mod.apk>] [--mode auto]
      [--stable build/mod/stable.dex] [--payload build/mod/payload.dex]
      [--out build/patch/<stem>-patched.apk] [--build-tools <dir>]
      [--keystore ~/.android/debug.keystore] [--alias androiddebugkey]
      [--storepass android] [--no-sign]
"""
import argparse
import hashlib
import json
import os
import pathlib
import re
import shutil
import subprocess
import sys
import zipfile

TOOLS = pathlib.Path(__file__).resolve().parent
PROJECT = TOOLS.parent
sys.path.insert(0, str(TOOLS))
import env  # noqa: E402

DEX_RE = re.compile(r"classes(\d*)\.dex")
STABLE_MARKERS = (b"Lcom/windukk/stable/StableBootstrap;",)
SHIM_MARKERS = (b"RuntimeRegistered", b"ni/shikatu")
PAYLOAD_ENTRY = "assets/tty/bundled/classes.dex"
MANIFEST_ENTRY = "assets/tty/bundled/manifest.json"
SKIP_PREFIXES = ("META-INF/",)


def sha256(data: bytes) -> str:
    return hashlib.sha256(data).hexdigest()


def dex_key(name: str) -> int:
    m = DEX_RE.fullmatch(name)
    n = m.group(1)
    return 0 if n == "" else int(n)


def dex_shifted(name: str) -> str:
    n = dex_key(name)
    return "classes2.dex" if n == 0 else f"classes{n + 1}.dex"


def remove_dir(path: pathlib.Path) -> None:
    if not path.exists():
        return
    for item in sorted(path.rglob("*"), reverse=True):
        if item.is_file() or item.is_symlink():
            try:
                item.unlink()
            except OSError:
                pass
        elif item.is_dir():
            try:
                item.rmdir()
            except OSError:
                pass
    try:
        path.rmdir()
    except OSError:
        pass


def inject_entrypoint(classes_dex_bytes: bytes, manifest_bytes: bytes,
                      work_dir: pathlib.Path, j_env: dict) -> bytes:
    """Inject StableBootstrap.start() call into AwemeHostApplication.attachBaseContext."""
    apktool_jar = TOOLS / "bin" / "apktool.jar"
    if not apktool_jar.is_file():
        raise RuntimeError(f"apktool.jar not found at {apktool_jar}")

    temp_dir = work_dir / f".entrypoint_{os.getpid()}"
    remove_dir(temp_dir)
    temp_dir.mkdir(parents=True, exist_ok=True)

    try:
        dummy_apk = temp_dir / "dummy.apk"
        with zipfile.ZipFile(dummy_apk, "w") as z:
            z.writestr("classes.dex", classes_dex_bytes)
            if manifest_bytes:
                z.writestr("AndroidManifest.xml", manifest_bytes)

        decomp_dir = temp_dir / "decomp"
        print("disassembling classes.dex with apktool...")
        res_d = subprocess.run(
            ["java", "-jar", str(apktool_jar), "d", "-r", "-f", str(dummy_apk), "-o", str(decomp_dir)],
            env=j_env, capture_output=True, text=True
        )
        if res_d.returncode != 0:
            raise RuntimeError(f"apktool d failed: {res_d.stderr}")

        candidates = list(decomp_dir.glob("**/AwemeHostApplication.smali"))
        if not candidates:
            raise RuntimeError("AwemeHostApplication.smali not found in decompiled classes.dex")
        aweme_smali = candidates[0]

        text = aweme_smali.read_text(encoding="utf-8")
        hook_call = "invoke-static {p0, p1}, Lcom/windukk/stable/StableBootstrap;->start(Landroid/app/Application;Landroid/content/Context;)V"
        if hook_call in text:
            print("entrypoint hook already present in AwemeHostApplication")
            return classes_dex_bytes

        target_call = "invoke-super {p0, p1}, Landroid/app/Application;->attachBaseContext(Landroid/content/Context;)V"
        if target_call not in text:
            raise RuntimeError("invoke-super attachBaseContext not found in AwemeHostApplication.smali")

        patched_text = text.replace(target_call, f"{target_call}\n\n    {hook_call}", 1)
        aweme_smali.write_text(patched_text, encoding="utf-8")
        print("injected StableBootstrap.start() into AwemeHostApplication.smali")

        rebuilt_apk = temp_dir / "rebuilt.apk"
        print("reassembling classes.dex with apktool...")
        res_b = subprocess.run(
            ["java", "-jar", str(apktool_jar), "b", str(decomp_dir), "-o", str(rebuilt_apk)],
            env=j_env, capture_output=True, text=True
        )
        if res_b.returncode != 0:
            raise RuntimeError(f"apktool b failed: {res_b.stderr}")

        with zipfile.ZipFile(rebuilt_apk) as z:
            patched_dex = z.read("classes.dex")

        print(f"successfully patched classes.dex ({len(patched_dex)} bytes)")
        return patched_dex
    finally:
        remove_dir(temp_dir)


def find_reference(target: pathlib.Path, ref_arg):
    if ref_arg:
        return pathlib.Path(ref_arg)
    with zipfile.ZipFile(target) as z:
        for name in z.namelist():
            if not DEX_RE.fullmatch(name):
                continue
            if any(m in z.read(name) for m in STABLE_MARKERS):
                print("reference: target itself (mod detected)")
                return target
    candidates = sorted(PROJECT.parent.glob("TikTok_You-*.apk"))
    if candidates:
        print(f"reference: {candidates[-1].name}")
        return candidates[-1]
    print("reference: none (plain repack)")
    return target


def java_env():
    environ = os.environ.copy()
    if (pathlib.Path(environ.get("JAVA_HOME", "")) / "bin" / "java").is_file():
        return environ
    home = env.java_home()
    if home is not None:
        environ["JAVA_HOME"] = str(home)
        environ["PATH"] = str(home / "bin") + os.pathsep + environ.get("PATH", "")
    return environ


def main() -> int:
    ap = argparse.ArgumentParser()
    ap.add_argument("apk")
    ap.add_argument("--ref")
    ap.add_argument("--mode", choices=["auto", "shift", "append"], default="auto")
    ap.add_argument("--stable", type=pathlib.Path,
                    default=PROJECT / "build" / "mod" / "stable.dex")
    ap.add_argument("--payload", type=pathlib.Path,
                    default=PROJECT / "build" / "mod" / "payload.dex")
    ap.add_argument("--out", type=pathlib.Path)
    ap.add_argument("--build-tools", default=env.build_tools_dir())
    ap.add_argument("--keystore",
                    default=str(pathlib.Path.home() / ".android" / "debug.keystore"))
    ap.add_argument("--alias", default="androiddebugkey")
    ap.add_argument("--storepass", default="android")
    ap.add_argument("--no-sign", action="store_true")
    args = ap.parse_args()

    target = pathlib.Path(args.apk).resolve()
    stable = pathlib.Path(args.stable).resolve()
    payload = pathlib.Path(args.payload).resolve()
    for p in (target, stable, payload):
        if not p.is_file():
            print(f"ERROR: not found: {p}")
            return 1

    out = pathlib.Path(args.out).resolve() if args.out else (
        PROJECT / "build" / "patch" / f"{target.stem}-patched.apk")
    out.parent.mkdir(parents=True, exist_ok=True)
    work = out.parent / f".{out.stem}-work.apk"
    aligned = out.parent / f".{out.stem}-aligned.apk"

    j_env = java_env()
    stable_bytes = stable.read_bytes()
    payload_bytes = payload.read_bytes()
    ref = find_reference(target, args.ref).resolve()

    with zipfile.ZipFile(target) as zt, zipfile.ZipFile(ref) as zr:
        target_names = zt.namelist()
        ref_names = zr.namelist() if ref != target else []
        target_dexes = sorted((n for n in target_names if DEX_RE.fullmatch(n)),
                              key=dex_key)

        has_mod = False
        has_shim = False
        for name in target_dexes:
            data = zt.read(name)
            if any(m in data for m in STABLE_MARKERS):
                has_mod = True
            if any(m in data for m in SHIM_MARKERS):
                has_shim = True
            if has_mod and has_shim:
                break

        plan = {}

        def is_dir(name: str) -> bool:
            return name.endswith("/")

        target_abis = {n.split('/')[1] for n in target_names if n.startswith('lib/') and '/' in n[4:]}
        ref_abis = {n.split('/')[1] for n in ref_names if n.startswith('lib/') and '/' in n[4:]}
        # If reference APK is arm64-only (like TikTok_You) and vanilla has armeabi-v7a as well,
        # drop armeabi-v7a so that libttmod.so (which only has arm64-v8a) doesn't cause UnsatisfiedLinkError
        # or runtime crashes on 32-bit processes.
        drop_v7a = (ref != target and ref_abis == {"arm64-v8a"} and "armeabi-v7a" in target_abis)
        if drop_v7a:
            print("reference APK is arm64-only: stripping armeabi-v7a libraries from target to prevent ABI mismatch")

        for name in target_names:
            if name.startswith(SKIP_PREFIXES) or is_dir(name) or DEX_RE.fullmatch(name):
                continue
            if drop_v7a and name.startswith("lib/armeabi-v7a/"):
                continue
            plan[name] = ("target", name)
        if ref != target:
            for name in ref_names:
                if name.startswith(SKIP_PREFIXES) or is_dir(name) or DEX_RE.fullmatch(name):
                    continue
                plan[name] = ("ref", name)

        # Overlay local source assets, res, and proprietary files if present
        local_assets = PROJECT / "src" / "assets"
        if local_assets.is_dir():
            for p in sorted(local_assets.rglob("*")):
                if p.is_file():
                    rel = f"assets/{p.relative_to(local_assets).as_posix()}"
                    plan[rel] = ("file", p)

        local_res = PROJECT / "src" / "res"
        if local_res.is_dir():
            for p in sorted(local_res.rglob("*")):
                if p.is_file():
                    rel = f"res/{p.relative_to(local_res).as_posix()}"
                    plan[rel] = ("file", p)

        local_ttmod = PROJECT / "src" / "proprietary" / "libttmod.so"
        if local_ttmod.is_file():
            plan["lib/arm64-v8a/libttmod.so"] = ("file", local_ttmod)

        mode = args.mode
        if mode == "auto":
            mode = "shift" if has_mod else "append"

        if mode == "append" and not has_mod:
            print("vanilla APK detected: injecting entrypoint hook into classes.dex...")
            orig_classes_dex = zt.read("classes.dex")
            manifest_data = zt.read("AndroidManifest.xml") if "AndroidManifest.xml" in target_names else b""
            patched_classes_dex = inject_entrypoint(
                orig_classes_dex, manifest_data, out.parent, j_env
            )
            plan["classes.dex"] = ("bytes", patched_classes_dex, zipfile.ZIP_DEFLATED)
            for name in target_dexes:
                if name != "classes.dex":
                    plan[name] = ("target", name)
            maxn = max((dex_key(n) for n in target_dexes), default=0)
            new_n = 2 if maxn == 0 else maxn + 1
            plan[f"classes{new_n}.dex"] = ("bytes", stable_bytes, zipfile.ZIP_DEFLATED)
            print(f"dex mode: append (entrypoint injected into classes.dex, rebuilt stable -> classes{new_n}.dex)")
        elif mode == "shift":
            for name in target_dexes:
                plan[dex_shifted(name)] = ("target", name)
            plan["classes.dex"] = ("bytes", stable_bytes, zipfile.ZIP_DEFLATED)
            print(f"dex mode: shift ({len(target_dexes)} dexes shifted up)")
        else:
            for name in target_dexes:
                plan[name] = ("target", name)
            maxn = max((dex_key(n) for n in target_dexes), default=0)
            new_n = 2 if maxn == 0 else maxn + 1
            plan[f"classes{new_n}.dex"] = ("bytes", stable_bytes, zipfile.ZIP_DEFLATED)
            print(f"dex mode: append (rebuilt stable dex -> classes{new_n}.dex)")

        if ref != target and not has_shim:
            carried = 0
            maxn = max((dex_key(n) for n in plan if DEX_RE.fullmatch(n)), default=0)
            for name in ref_names:
                if not DEX_RE.fullmatch(name):
                    continue
                data = zr.read(name)
                if any(m in data for m in SHIM_MARKERS) and not any(
                        m in data for m in STABLE_MARKERS):
                    maxn += 1
                    plan[f"classes{maxn}.dex"] = ("bytes", data, zipfile.ZIP_DEFLATED)
                    carried += 1
            if carried:
                print(f"carried over {carried} shim dex(es) from the reference")

        old_manifest = b""
        if MANIFEST_ENTRY in plan:
            origin = plan[MANIFEST_ENTRY][0]
            if origin == "file":
                old_manifest = pathlib.Path(plan[MANIFEST_ENTRY][1]).read_bytes()
            elif origin == "bytes":
                old_manifest = plan[MANIFEST_ENTRY][1]
            else:
                src = zr if origin == "ref" else zt
                old_manifest = src.read(plan[MANIFEST_ENTRY][1])
        elif MANIFEST_ENTRY in ref_names:
            old_manifest = zr.read(MANIFEST_ENTRY)
        manifest = json.loads(old_manifest.decode("utf-8")) if old_manifest else {
            "payloadType": "full", "variant": "release"}
        digest = sha256(payload_bytes)
        manifest["targetDexSha256"] = digest
        manifest["targetSize"] = len(payload_bytes)
        if not manifest.get("dexFiles"):
            manifest["dexFiles"] = [{"name": "classes.dex", "payload": "classes.dex"}]
        manifest["dexFiles"][0]["targetSha256"] = digest
        manifest["dexFiles"][0]["targetSize"] = len(payload_bytes)
        hashes = manifest.setdefault("hashes", {})
        hashes["classes.dex"] = digest
        plan[PAYLOAD_ENTRY] = ("bytes", payload_bytes, zipfile.ZIP_DEFLATED)
        plan[MANIFEST_ENTRY] = ("bytes",
                                json.dumps(manifest, separators=(",", ":")).encode("utf-8"),
                                zipfile.ZIP_DEFLATED)

        print(f"writing {work.name}: {len(plan)} entries")
        with zipfile.ZipFile(work, "w", zipfile.ZIP_DEFLATED) as zo:
            order = sorted(plan.keys(), key=lambda n: (
                0 if DEX_RE.fullmatch(n) else 1,
                dex_key(n) if DEX_RE.fullmatch(n) else 0,
                n))
            for name in order:
                value = plan[name]
                if value[0] == "bytes":
                    zo.writestr(zipfile.ZipInfo(name), value[1], compress_type=value[2])
                    continue
                if value[0] == "file":
                    p = value[1]
                    zo.write(str(p), arcname=name, compress_type=zipfile.ZIP_DEFLATED)
                    continue
                src = zt if value[0] == "target" else zr
                info = src.getinfo(value[1])
                zi = zipfile.ZipInfo(name, date_time=info.date_time)
                zi.compress_type = info.compress_type
                zi.external_attr = info.external_attr
                with src.open(value[1]) as sf, zo.open(zi, "w") as df:
                    shutil.copyfileobj(sf, df, 1024 * 1024)

    if not args.build_tools:
        print("ERROR: build-tools not found "
              "(set ANDROID_HOME/ANDROID_BUILD_TOOLS or pass --build-tools)")
        return 1
    zipalign = pathlib.Path(args.build_tools) / "zipalign"
    apksigner = pathlib.Path(args.build_tools) / "apksigner"
    print("zipalign...")
    subprocess.run([str(zipalign), "-f", "-p", "4", str(work), str(aligned)], check=True)
    try:
        work.unlink()
    except OSError:
        pass

    if args.no_sign:
        shutil.move(str(aligned), str(out))
    else:
        keystore = pathlib.Path(args.keystore).expanduser()
        j_env = java_env()
        if not keystore.is_file():
            print(f"creating debug keystore: {keystore}")
            keystore.parent.mkdir(parents=True, exist_ok=True)
            subprocess.run(["keytool", "-genkeypair", "-keystore", str(keystore),
                            "-storepass", args.storepass, "-keypass", args.storepass,
                            "-alias", args.alias,
                            "-dname", "CN=Android Debug,O=Android,C=US",
                            "-keyalg", "RSA", "-keysize", "2048", "-validity", "10000"],
                           check=True, env=j_env)
        print("apksigner sign...")
        subprocess.run([str(apksigner), "sign", "--ks", str(keystore),
                        "--ks-key-alias", args.alias,
                        "--ks-pass", f"pass:{args.storepass}",
                        "--key-pass", f"pass:{args.storepass}",
                        "--out", str(out), str(aligned)], check=True, env=j_env)
        aligned.unlink()
        print("apksigner verify...")
        subprocess.run([str(apksigner), "verify", "--print-certs", str(out)],
                       check=True, env=j_env)

    print(f"done: {out} ({out.stat().st_size} bytes)")
    return 0


if __name__ == "__main__":
    sys.exit(main())
