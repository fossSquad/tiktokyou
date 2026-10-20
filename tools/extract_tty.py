#!/usr/bin/env python3
"""Extract TikTok-You mod sources from a mod APK into a tty-src-style tree.

Stages:
  unzip   - extract classes*.dex + assets/tty/bundled/classes.dex from the
            APK (or copy an already-extracted tree)
  locate  - find mod-related dexes: the bundled payload
            (assets/tty/bundled/classes.dex), stable dexes containing the
            marker b"windukk", and shim dexes containing b"RuntimeRegistered"
            or b"ni/shikatu"
  jadx    - decompile each found dex with the jadx CLI (--no-res)
  merge   - merge all decompiled sources/ trees into <out>/src
  post    - run deterministic post-processors from tools/ in order:
            deobf_stringfog.py, clean_jadx.py --apply, rename_anon.py,
            rename_main.py, find_unused_imports.py --remove
  report  - counts + reminders for version-sensitive steps

The rename_hooks.py MAP is evidence-based (log strings / Main labels /
@Metadata) and MUST be reviewed per upstream version; this script never runs
it automatically. Same for rename_main.py's INTERNAL table if Main.java
structure changed.

Usage:
  python3 tools/extract_tty.py --apk <mod.apk> --out <dir> [--stages all]
                              [--jadx <path>] [--keep-going]
"""
import argparse
import pathlib
import shutil
import subprocess
import sys
import zipfile

TOOLS = pathlib.Path(__file__).resolve().parent
PROJECT = TOOLS.parent
sys.path.insert(0, str(TOOLS))
import env  # noqa: E402
PAYLOAD = "assets/tty/bundled/classes.dex"
STABLE_MARKER = b"windukk"
SHIM_MARKERS = (b"RuntimeRegistered", b"ni/shikatu")

POST_CHAIN = [
    (["deobf_stringfog.py"], True),
    (["clean_jadx.py", "--apply"], True),
    (["rename_anon.py"], True),
    (["rename_main.py"], True),
    (["rename_hooks.py", "--apply"], True),
    (["find_unused_imports.py", "--remove"], True),
    (["check_balance.py"], True),
]


def run(cmd, cwd=None, check=True):
    print("$", " ".join(str(c) for c in cmd), flush=True)
    return subprocess.run([str(c) for c in cmd], cwd=cwd,
                          check=check, text=True)


def stage_unzip(apk: pathlib.Path, out: pathlib.Path):
    if apk.is_dir():
        shutil.copytree(apk, out / "apk", dirs_exist_ok=True)
        return out / "apk"
    dest = out / "apk"
    dest.mkdir(parents=True, exist_ok=True)
    with zipfile.ZipFile(apk) as z:
        wanted = [n for n in z.namelist()
                  if n == PAYLOAD or (n.startswith("classes") and n.endswith(".dex"))]
        for name in wanted:
            target = dest / name
            target.parent.mkdir(parents=True, exist_ok=True)
            with z.open(name) as src, open(target, "wb") as dst:
                shutil.copyfileobj(src, dst)
    return dest


def stage_locate(apkdir: pathlib.Path):
    payload = apkdir / PAYLOAD
    stable, shim = [], []
    for p in sorted(apkdir.glob("classes*.dex")):
        data = p.read_bytes()
        if STABLE_MARKER in data:
            stable.append(p)
        if any(m in data for m in SHIM_MARKERS):
            shim.append(p)
    found = {}
    if payload.exists():
        found["payload"] = payload
    if stable:
        found["stable"] = stable
    if shim:
        found["shim"] = shim
    return found


def dexes_of(found):
    out = []
    if "payload" in found:
        out.append(found["payload"])
    out.extend(found.get("stable", []))
    out.extend(found.get("shim", []))
    out.extend(found.get("explicit", []))
    seen = set()
    result = []
    for d in out:
        if d not in seen:
            seen.add(d)
            result.append(d)
    return result


def stage_jadx(dexes, out: pathlib.Path, jadx: str):
    merged = out / "decomp"
    for dex in dexes:
        target = merged / dex.stem
        if target.exists():
            print(f"jadx: {target} exists, skipping")
            continue
        try:
            run([jadx, "-d", target, "--no-res", dex])
        except subprocess.CalledProcessError as e:
            if target.exists() and any(target.rglob("*.java")):
                print(f"WARN: jadx exit {e.returncode} for {dex.name}; "
                      "partial output kept")
            else:
                raise
        print(f"jadx done: {dex.name} -> {target}")


def stage_merge(out: pathlib.Path):
    src = out / "src"
    src.mkdir(parents=True, exist_ok=True)
    merged_files = 0
    for tree in sorted((out / "decomp").glob("*/sources")):
        for p in tree.rglob("*.java"):
            rel = p.relative_to(tree)
            dst = src / rel
            if dst.exists():
                continue
            dst.parent.mkdir(parents=True, exist_ok=True)
            shutil.copy2(p, dst)
            merged_files += 1
    print(f"merged java files: {merged_files}")
    return src


def stage_assets(apk: pathlib.Path, out: pathlib.Path):
    assets_dir = out / "src" / "assets"
    assets_dir.mkdir(parents=True, exist_ok=True)
    count = 0
    with zipfile.ZipFile(apk) as z:
        for name in z.namelist():
            if not name.startswith("assets/") or name.endswith("/"):
                continue
            rel = name[len("assets/"):]
            if rel.endswith(".dex"):
                continue
            if (rel.startswith("tty") or rel.startswith("mod_icons") or
                rel in ("developer.png", "supporter.png",
                        "tiktok_customized_tone.mp3", "ic_mod_logo_status.png")):
                target = assets_dir / rel
                target.parent.mkdir(parents=True, exist_ok=True)
                with z.open(name) as src, open(target, "wb") as dst:
                    shutil.copyfileobj(src, dst)
                count += 1
    print(f"extracted {count} mod assets -> {assets_dir}")
    return assets_dir


def stage_res(apk: pathlib.Path, out: pathlib.Path):
    res_dir = out / "src" / "res"
    res_dir.mkdir(parents=True, exist_ok=True)
    apktool_jar = TOOLS / "bin" / "apktool.jar"
    if apktool_jar.is_file():
        temp_decomp = out / ".apktool_res"
        try:
            print("disassembling resources with apktool...")
            subprocess.run(
                ["java", "-jar", str(apktool_jar), "d", "-f", str(apk), "-o", str(temp_decomp)],
                capture_output=True, text=True
            )
            raw_res = temp_decomp / "res"
            if raw_res.is_dir():
                count = 0
                for p in raw_res.rglob("*"):
                    if not p.is_file():
                        continue
                    if "ttmod_" in p.name or p.name == "ic_launcher_monochrome.xml":
                        rel = p.relative_to(raw_res)
                        dst = res_dir / rel
                        dst.parent.mkdir(parents=True, exist_ok=True)
                        shutil.copy2(p, dst)
                        count += 1
                print(f"decompiled and copied {count} mod resources -> {res_dir}")
        finally:
            if temp_decomp.exists():
                for item in sorted(temp_decomp.rglob("*"), reverse=True):
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
                    temp_decomp.rmdir()
                except OSError:
                    pass
    return res_dir


def stage_proprietary(apk: pathlib.Path, out: pathlib.Path, found: dict):
    prop_dir = out / "src" / "proprietary"
    prop_dir.mkdir(parents=True, exist_ok=True)
    with zipfile.ZipFile(apk) as z:
        lib_entry = "lib/arm64-v8a/libttmod.so"
        if lib_entry in z.namelist():
            dst = prop_dir / "libttmod.so"
            dst.write_bytes(z.read(lib_entry))
            print("extracted proprietary libttmod.so")

        for root_file in ("AndroidManifest.xml", "resources.arsc"):
            if root_file in z.namelist():
                dst = prop_dir / root_file
                dst.write_bytes(z.read(root_file))
                print(f"extracted proprietary {root_file}")

        prop_res = prop_dir / "res"
        res_count = 0
        for name in z.namelist():
            if name.startswith("res/") and not name.endswith("/"):
                if "ttmod_" in name or name in (
                    "res/h/ic_launcher_monochrome.xml", "res/a/apy.xml",
                    "res/a/ar1.png", "res/aq/a.png", "res/ap/a.png",
                    "res/a/apx.xml", "res/g/de.png", "res/c/vl.png", "res/ar/a.xml"
                ):
                    dst = prop_res / name[len("res/"):]
                    dst.parent.mkdir(parents=True, exist_ok=True)
                    dst.write_bytes(z.read(name))
                    res_count += 1
        print(f"extracted {res_count} compiled proprietary resources -> {prop_res}")

        for shim_dex in found.get("shim", []):
            dst = prop_dir / shim_dex.name
            dst.write_bytes(shim_dex.read_bytes())
            print(f"extracted proprietary shim dex {shim_dex.name}")
    return prop_dir


def stage_post(src: pathlib.Path, keep_going: bool):
    for args, needs_root in POST_CHAIN:
        cmd = [sys.executable, TOOLS / args[0]] + args[1:]
        if needs_root:
            cmd.append(str(src))
        try:
            run(cmd, cwd=PROJECT)
        except subprocess.CalledProcessError as e:
            print(f"WARN: {args[0]} failed with exit {e.returncode}")
            if not keep_going:
                raise


def stage_report(out: pathlib.Path, src: pathlib.Path, found: dict):
    java = sum(1 for _ in src.rglob("*.java"))
    print("=== extraction report ===")
    print(f"out: {out}")
    print(f"java files: {java}")
    for kind, value in found.items():
        if isinstance(value, list):
            for v in value:
                print(f"{kind}: {v}")
        else:
            print(f"{kind}: {value}")
    print("next: review rename-map evidence for this version "
          "(docs/restore-map.md) and update tools/rename_hooks.py MAP if needed")


def main() -> int:
    ap = argparse.ArgumentParser()
    ap.add_argument("--apk", required=True, type=pathlib.Path)
    ap.add_argument("--out", required=True, type=pathlib.Path)
    ap.add_argument("--jadx", type=str,
                    default=str(env.jadx_path(project=PROJECT) or ""))
    ap.add_argument("--stages", default="all")
    ap.add_argument("--keep-going", action="store_true")
    ap.add_argument("--dexes", default="",
                    help="comma-separated classes*.dex names instead of marker locate")
    args = ap.parse_args()

    if not args.jadx:
        print("ERROR: jadx not found (set JADX, add to PATH, or pass --jadx)")
        return 1
    stages = ({"unzip", "locate", "jadx", "merge", "assets", "res", "proprietary", "post", "report"}
              if args.stages == "all" else set(args.stages.split(",")))
    args.out.mkdir(parents=True, exist_ok=True)

    apkdir = args.out / "apk"
    if "unzip" in stages:
        apkdir = stage_unzip(args.apk, args.out)
    found = {}
    if args.dexes:
        found = {"explicit": [apkdir / n for n in args.dexes.split(",")]}
        payload = apkdir / PAYLOAD
        if payload.is_file():
            found["payload"] = payload
        for p in found["explicit"]:
            print(f"using {p}")
        if "payload" in found:
            print(f"using payload {found['payload']}")
    elif "locate" in stages:
        found = stage_locate(apkdir)
        if not found:
            print("ERROR: no mod-related dexes found")
            return 1
        for kind, value in found.items():
            if isinstance(value, list):
                for v in value:
                    print(f"found {kind}: {v}")
            else:
                print(f"found {kind}: {value}")
    if "jadx" in stages:
        stage_jadx(dexes_of(found), args.out, args.jadx)
    src = args.out / "src"
    if "merge" in stages:
        src = stage_merge(args.out)
    if "assets" in stages:
        stage_assets(args.apk, args.out)
    if "res" in stages:
        stage_res(args.apk, args.out)
    if "proprietary" in stages:
        stage_proprietary(args.apk, args.out, found)
    if "post" in stages:
        stage_post(src, args.keep_going)
    if "report" in stages:
        stage_report(args.out, src, found)
    return 0


if __name__ == "__main__":
    sys.exit(main())
