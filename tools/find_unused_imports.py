#!/usr/bin/env python3
"""Find unused imports in java sources (string/comment-aware, conservative).

Usage: find_unused_imports.py [root] [--write-report PATH]
Prints a summary and, when --write-report is given, the full per-file list.
Conservative: a name found anywhere in code counts as used, so false
"unused" hits are rare; wildcard imports are skipped.
"""
import pathlib
import re
import sys

IMPORT = re.compile(r"^\s*import\s+(static\s+)?([\w.$*]+)\s*;\s*$", re.M)


def masked(s: str) -> str:
    out = list(s)
    i = 0
    n = len(s)
    while i < n:
        c = s[i]
        if c == "/" and i + 1 < n:
            if s[i + 1] == "/":
                j = s.find("\n", i)
                j = n if j < 0 else j
                for k in range(i, j):
                    out[k] = " "
                i = j
                continue
            if s[i + 1] == "*":
                j = s.find("*/", i + 2)
                j = n if j < 0 else j + 2
                for k in range(i, j):
                    out[k] = " "
                i = j
                continue
        if c == '"' or c == "'":
            q = c
            j = i + 1
            while j < n and s[j] != q:
                j += 2 if s[j] == "\\" else 1
            j = min(j + 1, n)
            for k in range(i, j):
                out[k] = " "
            i = j
            continue
        i += 1
    return "".join(out)


def main() -> int:
    args = [a for a in sys.argv[1:] if not a.startswith("--")]
    root = pathlib.Path(args[0] if args else "tty-src/src")
    report_path = None
    if "--write-report" in sys.argv:
        report_path = sys.argv[sys.argv.index("--write-report") + 1]

    report = []
    total = 0
    files = 0
    scanned = 0
    vapro_unused = 0
    for p in sorted(root.rglob("*.java")):
        scanned += 1
        t = p.read_text(errors="ignore")
        body = masked(t)
        body_no_imports = IMPORT.sub("", body)
        unused = []
        for m in IMPORT.finditer(body):
            fq = m.group(2)
            if fq.endswith(".*"):
                continue
            name = fq.rsplit(".", 1)[-1]
            pat = re.compile(r"(?<![\w$.])" + re.escape(name) + r"(?![\w$])")
            if not pat.search(body_no_imports):
                unused.append(fq)
                if fq.startswith("com.vapro"):
                    vapro_unused += 1
        if unused:
            files += 1
            total += len(unused)
            report.append((str(p), unused))

    print(f"scanned: {scanned} files; files with unused imports: {files}; total unused: {total}")
    print(f"unused com.vapro imports: {vapro_unused}")
    for f, u in report[:40]:
        print(f, "->", ", ".join(u))
    if len(report) > 40:
        print(f"... and {len(report) - 40} more files")
    if "--remove" in sys.argv:
        removed = 0
        for f, u in report:
            p = pathlib.Path(f)
            t = p.read_text(errors="ignore")
            before = t
            for imp in u:
                pat = re.compile(r"^\s*import\s+(?:static\s+)?" + re.escape(imp) + r"\s*;\s*\n", re.M)
                t = pat.sub("", t)
            if t != before:
                p.write_text(t)
                removed += 1
        print(f"files rewritten: {removed}")

    if report_path:
        with open(report_path, "w") as fh:
            for f, u in report:
                fh.write(f"{f}\n")
                for imp in u:
                    fh.write(f"    {imp}\n")
        print(f"full report: {report_path}")
    return 0


if __name__ == "__main__":
    sys.exit(main())
