#!/usr/bin/env python3
"""Rebuild build/lib/mod-lib.jar, the compile-time mirror of the original mod.

The payload build compiles against the original mod's shim and stable-layer
classes, so they must be visible to javac as class files on the compile
classpath. This tool derives that jar from a mod APK:

  1. pick every classes*.dex of the APK that contains a mod marker
     (windukk / ni/shikatu / vae/stringfog / hiddenapibypass / CommonUtils);
  2. convert those dexes with dex2jar;
  3. merge the converted jars, keeping only mod-owned packages
     (a/, com/windukk/, com/vapro/, org/lsposed/hiddenapibypass/,
     ni/shikatu/, com/ss/android/ugc/aweme/utils/CommonUtils).

Usage:
  python3 tools/gen_support_jar.py <mod.apk> [--out build/lib/mod-lib.jar]
      [--raw-dir build/support-jar] [--dex2jar <path>]
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

MARKERS = (
    b"windukk",
    b"ni/shikatu",
    b"vae/stringfog",
    b"lsposed/hiddenapibypass",
    b"CommonUtils",
)
ALLOWED_PREFIXES = (
    "a/",
    "com/windukk/",
    "com/vapro/",
    "org/lsposed/hiddenapibypass/",
    "ni/shikatu/",
)
ALLOWED_EXACT = (
    "com/ss/android/ugc/aweme/utils/CommonUtils",
)


def allowed(entry: str) -> bool:
    if not entry.endswith(".class"):
        return False
    base = entry[: -len(".class")]
    simple = base.rsplit("$", 1)[0]
    if simple in ALLOWED_EXACT:
        return True
    return any(simple.startswith(p) for p in ALLOWED_PREFIXES)


def run(cmd):
    print("$", " ".join(str(c) for c in cmd), flush=True)
    return subprocess.run([str(c) for c in cmd], check=True, text=True)


def pick_dexes(apk: pathlib.Path, explicit: str | None = None):
    picked = []
    with zipfile.ZipFile(apk) as z:
        if explicit:
            names = [n.strip() for n in explicit.split(",") if n.strip()]
        else:
            names = [n for n in z.namelist()
                     if n.startswith("classes") and n.endswith(".dex")]
        names.sort(key=lambda s: (len(s), s))
        for n in names:
            data = z.read(n)
            hits = [m.decode(errors="replace") for m in MARKERS if m in data]
            if explicit or hits:
                picked.append((n, hits or ["explicit"]))
    return picked


def main() -> int:
    ap = argparse.ArgumentParser(description=__doc__)
    ap.add_argument("apk", type=pathlib.Path)
    ap.add_argument("--out", type=pathlib.Path,
                    default=PROJECT / "src" / "proprietary" / "hook.jar")
    ap.add_argument("--raw-dir", type=pathlib.Path,
                    default=PROJECT / "build" / "support-jar")
    ap.add_argument("--dex2jar", default=None)
    ap.add_argument("--dexes", default=None,
                    help="Comma-separated classes*.dex list (skips marker scan)")
    args = ap.parse_args()

    if not args.apk.is_file():
        print(f"ERROR: apk not found: {args.apk}")
        return 1
    d2j = args.dex2jar or env.dex2jar_path()
    if not d2j:
        print("ERROR: dex2jar not found (set DEX2JAR or pass --dex2jar)")
        return 1

    raw = args.raw_dir
    if raw.exists():
        shutil.rmtree(raw)
    raw.mkdir(parents=True)

    picked = pick_dexes(args.apk, args.dexes)
    if not picked:
        print("ERROR: no mod dexes found in the APK")
        return 1
    for name, hits in picked:
        print(f"pick {name}: {', '.join(hits)}")

    raw_jars = []
    with zipfile.ZipFile(args.apk) as z:
        for name, _ in picked:
            dex_path = raw / name
            dex_path.write_bytes(z.read(name))
            jar_path = raw / (pathlib.Path(name).stem + ".jar")
            run([str(d2j), "-f", str(dex_path), "-o", str(jar_path)])
            raw_jars.append(jar_path)

    seen = set()
    copied = 0
    raw_jar = args.raw_dir / "raw-hook.jar"
    with zipfile.ZipFile(raw_jar, "w", zipfile.ZIP_DEFLATED) as zout:
        for jar in raw_jars:
            with zipfile.ZipFile(jar) as zin:
                for item in zin.infolist():
                    entry = item.filename
                    if not allowed(entry) or entry in seen:
                        continue
                    seen.add(entry)
                    zout.writestr(item, zin.read(entry))
                    copied += 1
    print(f"support jar: {raw_jar} ({copied} classes from {len(raw_jars)} dexes)")
    args.out.parent.mkdir(parents=True, exist_ok=True)
    run([sys.executable, str(TOOLS / "prepare_host_jar.py"), str(raw_jar), str(args.out)])
    print(f"prepared: {args.out}")
    return 0


if __name__ == "__main__":
    sys.exit(main())
