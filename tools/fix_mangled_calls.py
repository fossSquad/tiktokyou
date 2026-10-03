#!/usr/bin/env python3
"""Rewrite jadx-rendered Kotlin value-class mangled call sites to the
canonical names jadx itself used for declarations.

`Result.constructor-impl(...)` (invalid Java, hyphen) becomes
`Result.m6constructorimpl(...)`, and likewise for the other Result inline
methods.  Only code positions are touched (strings/comments untouched).

Usage: python3 fix_mangled_calls.py [root] [--apply]
"""
import re
import sys
import pathlib

sys.path.insert(0, str(pathlib.Path(__file__).resolve().parent))
import clean_jadx  # noqa: E402

MAP = {
    "Result.constructor-impl": "Result.m6constructorimpl",
    "Result.isFailure-impl": "Result.m12isFailureimpl",
    "Result.exceptionOrNull-impl": "Result.m9exceptionOrNullimpl",
    "Result.isSuccess-impl": "Result.m13isSuccessimpl",
    "Result.box-impl": "Result.m5boximpl",
}

SCAN = re.compile(r"[A-Za-z_$][\w$]*-[\w$]+")
SCI = re.compile(r"[0-9][.0-9]*[eE]-\d+d\b")


def fix_file(text: str):
    in_str, in_cmt = clean_jadx._classify(text)
    out = []
    last = 0
    counts = {k: 0 for k in MAP}
    for key, repl in MAP.items():
        for m in re.finditer(re.escape(key), text):
            if in_str[m.start()] or in_cmt[m.start()]:
                continue
            out.append((m.start(), m.end(), repl, key))
    out.sort()
    pieces = []
    pos = 0
    for start, end, repl, key in out:
        if start < pos:
            continue
        pieces.append(text[pos:start])
        pieces.append(repl)
        pos = end
        counts[key] += 1
    pieces.append(text[pos:])
    return "".join(pieces), counts


def scan_leftovers(text: str):
    in_str, in_cmt = clean_jadx._classify(text)
    left = []
    for m in SCAN.finditer(text):
        if in_str[m.start()] or in_cmt[m.start()]:
            continue
        if SCI.match(text, m.start() - 1) or SCI.match(text, m.start()):
            continue
        left.append(m.group(0))
    return left


def main() -> int:
    args = [a for a in sys.argv[1:] if not a.startswith("--")]
    root = pathlib.Path(args[0] if args else "tty-src/src")
    apply = "--apply" in sys.argv

    total = {k: 0 for k in MAP}
    changed = 0
    leftovers = []
    for p in sorted(root.rglob("*.java")):
        text = p.read_text(errors="ignore")
        new, counts = fix_file(text)
        if new != text:
            changed += 1
            for k in counts:
                total[k] += counts[k]
            if apply:
                p.write_text(new)
        if apply:
            left = scan_leftovers(new)
        else:
            left = scan_leftovers(text)
        if left:
            leftovers.append((str(p), left[:5]))
    print("replacements:", {k: v for k, v in total.items() if v})
    print(f"files changed: {changed}")
    print(f"leftover hyphen tokens: {len(leftovers)}")
    for f, l in leftovers[:10]:
        print(" ", f, l)
    if not apply:
        print("(check mode, pass --apply to write)")
    return 0


if __name__ == "__main__":
    sys.exit(main())
