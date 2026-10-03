#!/usr/bin/env python3
"""Rewrite jadx-mangled Result call sites to the Z.RCompat bridge.

String/comment positions are masked out via clean_jadx._classify so that
@Metadata blobs are never touched.
"""
import pathlib
import re
import sys

sys.path.insert(0, str(pathlib.Path(__file__).resolve().parent))
import clean_jadx  # noqa: E402

ROOT = pathlib.Path(sys.argv[1] if len(sys.argv) > 1 else "src")

NAMES = [
    "m6constructorimpl",
    "m9exceptionOrNullimpl",
    "m12isFailureimpl",
    "m13isSuccessimpl",
    "m5boximpl",
]


def mask(s: str):
    return clean_jadx._classify(s)


def main() -> int:
    counts = {n: 0 for n in NAMES}
    files = 0
    for p in sorted(ROOT.rglob("*.java")):
        s = p.read_text(errors="ignore")
        if "Result." not in s:
            continue
        in_str, in_cmt = mask(s)
        out = []
        last = 0
        changed = 0
        for m in re.finditer(r"\bResult\.(m\d+[A-Za-z]*impl)\b", s):
            if in_str[m.start()] or in_cmt[m.start()]:
                continue
            name = m.group(1)
            if name not in NAMES:
                continue
            out.append(s[last:m.start()])
            out.append("RCompat." + name)
            last = m.end()
            counts[name] += 1
            changed += 1
        if changed:
            out.append(s[last:])
            p.write_text("".join(out))
            files += 1
    print(f"files: {files}, replacements: {counts}, total: {sum(counts.values())}")
    return 0


if __name__ == "__main__":
    sys.exit(main())
