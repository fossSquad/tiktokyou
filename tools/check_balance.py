#!/usr/bin/env python3
"""Report java files whose braces are not balanced (string/comment-aware)."""
import pathlib
import sys


def bal(t: str) -> int:
    d = 0
    i = 0
    n = len(t)
    while i < n:
        c = t[i]
        if c == "/" and i + 1 < n:
            if t[i + 1] == "/":
                j = t.find("\n", i)
                i = n if j < 0 else j
                continue
            if t[i + 1] == "*":
                j = t.find("*/", i + 2)
                i = n if j < 0 else j + 2
                continue
        if c == '"' or c == "'":
            q = c
            i += 1
            while i < n and t[i] != q:
                i += 2 if t[i] == "\\" else 1
            i += 1
            continue
        if c == "{":
            d += 1
        elif c == "}":
            d -= 1
        i += 1
    return d


def main() -> int:
    root = pathlib.Path(sys.argv[1] if len(sys.argv) > 1 else "tty-src/src")
    bad = []
    total = 0
    for p in root.rglob("*.java"):
        total += 1
        v = bal(p.read_text(errors="ignore"))
        if v != 0:
            bad.append((str(p), v))
    print(f"checked {total} files; unbalanced: {len(bad)}")
    for b in bad[:20]:
        print(b)
    return 1 if bad else 0


if __name__ == "__main__":
    sys.exit(main())
