#!/usr/bin/env python3
"""Reconstruct a per-release commit history in the tty-src git repo.

Creates an orphan branch (default `history`) where each commit contains the
extracted sources of one release (releases/<version>/src -> <repo>/src).
Commit subject = version, body = the release changelog from the Telegram
export, author/committer dates = the original post dates.

Usage:
  python3 tools/commit_releases.py [--repo PATH] [--releases DIR]
      [--export result.json] [--branch history] [--only 1.0.0,1.3]
      [--author "Name <email>"] [--dry-run]
"""
import argparse
import json
import os
import pathlib
import re
import shutil
import subprocess
import sys
import tempfile

TOOLS = pathlib.Path(__file__).resolve().parent
PROJECT = TOOLS.parent

RELEASES = ["1.0.0", "1.0.1", "1.1.0", "1.2.2", "1.2.3", "1.2.4", "1.3",
            "1.4", "1.5", "1.5.1", "2.1.1", "3.0", "3.4", "4.2", "4.4"]

OVERRIDES = {"4.4": PROJECT / "src"}


def run(cmd, cwd=None, env=None, check=True):
    print("$", " ".join(str(c) for c in cmd))
    return subprocess.run([str(c) for c in cmd], cwd=cwd, env=env,
                          check=check, text=True, capture_output=True)


def load_export(path):
    data = json.loads(pathlib.Path(path).read_text(encoding="utf-8"))
    meta = {}
    for m in data.get("messages", []):
        if m.get("type") != "message":
            continue
        text = m.get("text", "")
        if isinstance(text, list):
            text = "".join(t if isinstance(t, str) else t.get("text", "")
                           for t in text)
        mm = re.search(r"v?(\d+\.\d+(?:\.\d+)?)", text)
        if not mm:
            continue
        ver = mm.group(1)
        if ver in RELEASES and ver not in meta:
            meta[ver] = (m.get("date", ""), text.strip())
    return meta


def main() -> int:
    ap = argparse.ArgumentParser(description=__doc__)
    ap.add_argument("--repo", type=pathlib.Path, default=PROJECT)
    ap.add_argument("--releases", type=pathlib.Path,
                    default=PROJECT.parent / "releases")
    ap.add_argument("--export", type=pathlib.Path,
                    default=pathlib.Path.home() / "Downloads" /
                    "AyuGram Desktop" / "tiktokyou" / "result.json")
    ap.add_argument("--branch", default="history")
    ap.add_argument("--only", default="")
    ap.add_argument("--author", default="")
    ap.add_argument("--dry-run", action="store_true")
    args = ap.parse_args()

    if not (args.repo / ".git").is_dir():
        print(f"ERROR: {args.repo} is not a git repo")
        return 1
    meta = load_export(args.export)
    wanted = [v for v in RELEASES if not args.only or v in args.only.split(",")]
    missing = [v for v in wanted
               if not OVERRIDES.get(v, args.releases / v / "src").is_dir()]
    if missing:
        print(f"WARN: sources missing for {', '.join(missing)} (skipped)")

    if args.dry_run:
        for ver in wanted:
            if OVERRIDES.get(ver, args.releases / ver / "src").is_dir():
                date, text = meta.get(ver, ("", ""))
                print(f"[dry] {ver} @ {date}: {text[:80]!r}")
        return 0

    status = run(["git", "status", "--porcelain"], cwd=args.repo).stdout.strip()
    if status:
        print("ERROR: working tree is not clean; commit or stash first")
        print(status[:2000])
        return 1
    orig = run(["git", "rev-parse", "--abbrev-ref", "HEAD"],
               cwd=args.repo).stdout.strip()
    print(f"repo: {args.repo} (current branch: {orig})")

    snapshots = {}
    for ver, path in OVERRIDES.items():
        if path.is_dir():
            snap = pathlib.Path(tempfile.mkdtemp(prefix=f"hist-{ver}-"))
            shutil.copytree(path, snap / "src")
            snapshots[ver] = snap / "src"
            print(f"snapshot {ver}: {path} -> {snapshots[ver]}")

    run(["git", "checkout", "--orphan", args.branch], cwd=args.repo)
    run(["git", "rm", "-r", "--cached", "."], cwd=args.repo, check=False)

    committed = 0
    for ver in wanted:
        src = snapshots.get(ver) or OVERRIDES.get(ver,
                                                  args.releases / ver / "src")
        if not src.is_dir():
            print(f"[skip] {ver}: no sources")
            continue
        target = args.repo / "src"
        if target.exists():
            shutil.rmtree(target)
        shutil.copytree(src, target)
        run(["git", "add", "src"], cwd=args.repo)
        date, text = meta.get(ver, ("", ""))
        msg = ver + "\n\n" + text + "\n"
        msg_file = args.repo / ".git" / "COMMIT_MSG"
        msg_file.write_text(msg, encoding="utf-8")
        env = os.environ.copy()
        if date:
            env["GIT_AUTHOR_DATE"] = date
            env["GIT_COMMITTER_DATE"] = date
        cmd = ["git", "commit", "--allow-empty", "--cleanup=verbatim",
               "-F", str(msg_file)]
        if args.author:
            cmd += ["--author", args.author]
        run(cmd, cwd=args.repo, env=env)
        committed += 1
        print(f"[commit] {ver} @ {date}")

    print(f"committed releases: {committed}")
    run(["git", "checkout", "-f", orig], cwd=args.repo)
    print(f"back on branch: {orig}")
    return 0


if __name__ == "__main__":
    sys.exit(main())
