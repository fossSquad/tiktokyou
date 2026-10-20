#!/usr/bin/env python3
"""Normalize extracted release resources.

Merges src/proprietary/res/** into src/res/** (skip existing files) and drops
the compiled src/proprietary/resources.arsc. This keeps the release trees free
of the heavy compiled resource table while preserving the mod resource files.

Usage:
  python3 tools/clean_release_res.py <src-dir> [<src-dir> ...]
"""
import pathlib
import shutil
import sys


def clean(src: pathlib.Path) -> None:
    prop = src / "proprietary"
    if not prop.is_dir():
        print(f"{src}: no proprietary")
        return
    pres = prop / "res"
    moved = skipped = 0
    if pres.is_dir():
        for p in sorted(pres.rglob("*")):
            if not p.is_file():
                continue
            rel = p.relative_to(pres)
            dst = src / "res" / rel
            if dst.exists():
                skipped += 1
                continue
            dst.parent.mkdir(parents=True, exist_ok=True)
            shutil.copy2(p, dst)
            moved += 1
        shutil.rmtree(pres)
    arsc = prop / "resources.arsc"
    removed = arsc.is_file()
    if removed:
        arsc.unlink()
    print(f"{src}: res moved {moved}, skipped {skipped}, "
          f"arsc removed {removed}")


if __name__ == "__main__":
    if len(sys.argv) < 2:
        print(__doc__)
        sys.exit(1)
    for arg in sys.argv[1:]:
        clean(pathlib.Path(arg))
