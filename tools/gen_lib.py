#!/usr/bin/env python3
"""Generate the compile-time host jar (libs/tiktok.jar) from a vanilla TikTok APK.

Pipeline:
  1. dex2jar the APK -> raw jar (build/host-raw.jar)
  2. tools/prepare_host_jar.py: clear ACC_SYNTHETIC on Kotlin bridges, bump
     class-file versions, rename digit-prefixed classes so javac accepts the
     host classes on the compile classpath.

Usage:
  python3 tools/gen_lib.py <vanilla.apk> [--out libs/tiktok.jar]
                           [--raw build/host-raw.jar]
                           [--dex2jar /path/to/d2j-dex2jar.sh]
"""
import argparse
import pathlib
import subprocess
import sys

TOOLS = pathlib.Path(__file__).resolve().parent
PROJECT = TOOLS.parent
sys.path.insert(0, str(TOOLS))
import env  # noqa: E402


def main() -> int:
    ap = argparse.ArgumentParser()
    ap.add_argument("apk", type=pathlib.Path)
    ap.add_argument("--out", type=pathlib.Path, default=PROJECT / "libs" / "tiktok.jar")
    ap.add_argument("--raw", type=pathlib.Path, default=PROJECT / "build" / "host-raw.jar")
    ap.add_argument("--dex2jar", default=env.dex2jar_path())
    args = ap.parse_args()

    if not args.dex2jar:
        print("ERROR: dex2jar not found "
              "(set DEX2JAR, install dex-tools, or pass --dex2jar)")
        return 1
    if not args.apk.is_file():
        print(f"ERROR: apk not found: {args.apk}")
        return 1
    args.raw.parent.mkdir(parents=True, exist_ok=True)

    print(f"$ {args.dex2jar} -f {args.apk} -o {args.raw}")
    r = subprocess.run([args.dex2jar, "-f", str(args.apk), "-o", str(args.raw)])
    if r.returncode != 0 or not args.raw.is_file():
        print("ERROR: dex2jar failed")
        return 1

    r = subprocess.run([sys.executable, str(TOOLS / "prepare_host_jar.py"),
                        str(args.raw), str(args.out)])
    if r.returncode != 0:
        print("ERROR: prepare_host_jar failed")
        return 1

    print(f"done: {args.out} ({args.out.stat().st_size} bytes)")
    return 0


if __name__ == "__main__":
    sys.exit(main())
