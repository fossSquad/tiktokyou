#!/usr/bin/env python3
"""Extract + deobfuscate + normalize every mod release APK into a source tree.

For each release APK (chronological), runs tools/extract_tty.py, which unzips
the mod dexes, decompiles them with jadx, merges the trees and runs the
deterministic post-processors (deobf_stringfog, clean_jadx, rename_anon,
rename_main, find_unused_imports, check_balance).

Usage:
  python3 tools/extract_releases.py [--apks DIR] [--out DIR] [--jadx PATH]
      [--only 1.0.0,1.3] [--keep-going]
"""
import argparse
import pathlib
import subprocess
import sys

TOOLS = pathlib.Path(__file__).resolve().parent
PROJECT = TOOLS.parent

RELEASES = [
    ("1.0.0", "TikTok_You-1.0.0-(Beta).apk"),
    ("1.0.1", "TikTok_You-1.0.1-(43.2.1, Beta).apk"),
    ("1.1.0", "TikTok_You-1.1.0-(43.6.3, Beta).apk"),
    ("1.2.2", "TikTok_You-1.2.2-(43.8.3, Beta).apk"),
    ("1.2.3", "TikTok_You-1.2.3-(43.8.3, Beta).apk"),
    ("1.2.4", "TikTok_You-1.2.4-(43.9.3, Beta).apk"),
    ("1.3", "TikTok_You-1.3-(43.9.3).apk"),
    ("1.4", "TikTok_You-1.4-(44.5.3).apk"),
    ("1.5", "TikTok_You-1.5-(44.6.4).apk"),
    ("1.5.1", "TikTok_You-1.5.1-(44.6.4).apk"),
    ("2.1.1", "TikTok_You-2.1.1-(45.0.3).apk"),
    ("3.0", "TikTok_You-3.0-(45.5.3).apk"),
    ("3.4", "TikTok_You-3.4-(45.9.3).apk"),
    ("4.2", "TikTok_You-4.2-(46.8.3).apk"),
    ("4.4", "TikTok_You-4.4-(46.8.3).apk"),
]


def main() -> int:
    ap = argparse.ArgumentParser(description=__doc__)
    ap.add_argument("--apks", type=pathlib.Path,
                    default=pathlib.Path.home() / "Downloads"
                    / "AyuGram Desktop" / "tiktokyou" / "prebuilt")
    ap.add_argument("--out", type=pathlib.Path,
                    default=PROJECT.parent / "releases")
    ap.add_argument("--jadx", default=str(PROJECT.parent / "jadx-1.5.6"
                                          / "bin" / "jadx"))
    ap.add_argument("--only", default="")
    ap.add_argument("--keep-going", action="store_true")
    args = ap.parse_args()

    only = set(args.only.split(",")) if args.only else None
    args.out.mkdir(parents=True, exist_ok=True)
    failures = []
    for version, apk_name in RELEASES:
        if only and version not in only:
            continue
        apk = args.apks / apk_name
        out = args.out / version
        src = out / "src"
        if src.is_dir() and any(src.iterdir()):
            print(f"[skip] {version}: {src} exists", flush=True)
            continue
        if not apk.is_file():
            print(f"[missing] {version}: {apk}", flush=True)
            failures.append(version)
            continue
        log = args.out / f"{version}.log"
        print(f"[extract] {version} -> {out}", flush=True)
        cmd = [sys.executable, str(TOOLS / "extract_tty.py"),
               "--apk", str(apk), "--out", str(out), "--jadx", args.jadx]
        if args.keep_going:
            cmd.append("--keep-going")
        with log.open("w") as fh:
            proc = subprocess.run(cmd, stdout=fh, stderr=subprocess.STDOUT,
                                  cwd=str(PROJECT))
        if proc.returncode != 0:
            print(f"[failed] {version}: see {log}", flush=True)
            failures.append(version)
        else:
            print(f"[done] {version}", flush=True)
    if failures:
        print("failures:", ", ".join(failures), flush=True)
        return 1
    return 0


if __name__ == "__main__":
    sys.exit(main())
