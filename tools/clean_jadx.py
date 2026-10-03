#!/usr/bin/env python3
"""Remove jadx decompiler artifacts from decompiled sources.

Artifacts handled:
  - /* JADX INFO/WARN/ERROR/DEBUG: ... */ block comments (multiline)
  - // JADX INFO/WARN/ERROR/DEBUG: line comments
  - /* Code decompiled incorrectly ... '--show-bad-code' */ failure headers
  - /* Method dump skipped ... '--comments-level debug' */ skipped-method stubs
  - // from class: ... trailing provenance comments
  - trailing comments after @Override (e.g. "@Override // java.lang.Runnable")
  - bare no-op string statements ("also(...)"; / "application";) left by Kotlin intrinsics
  - /* synthetic */ markers

Check mode is the default; pass --apply to write.  Verifies that brace balance is
unchanged per file and that no artifact patterns remain; aborts without writing
on any error.
"""
import re
import sys
import pathlib

BLOCK = re.compile(r"/\*\s*JADX\s+(?:INFO|WARN|ERROR|DEBUG):.*?\*/", re.S)
LINE = re.compile(r"//\s*JADX\s+(?:INFO|WARN|ERROR|DEBUG):[^\n]*")
FAILBLOCK = re.compile(
    r"/\*(?:(?!\*/).)*?"
    r"(?:Code decompiled incorrectly|Method dump skipped|show-bad-code|comments-level debug)"
    r"(?:(?!\*/).)*?\*/",
    re.S,
)
FROMCLASS = re.compile(r"//\s*from class:[^\n]*")
OVERRIDE = re.compile(r"(@Override\b[^\S\n]*)//[^\n]*")
BARESTR = re.compile(r"^[ \t]*\"(?:[^\"\\\n]|\\.)*\";[ \t]*\n", re.M)
SYNTH = re.compile(r"/\*\s*synthetic\s*\*/")
LEFTOVER = re.compile(
    r"JADX|Code decompiled incorrectly|Method dump skipped|show-bad-code|comments-level debug"
)


def _classify(s: str):
    n = len(s)
    in_str = bytearray(n)
    in_cmt = bytearray(n)
    state = 0  # 0 code, 1 line comment, 2 block comment, 3 string, 4 char
    i = 0
    while i < n:
        c = s[i]
        if state == 0:
            if c == "/" and i + 1 < n and s[i + 1] == "/":
                in_cmt[i] = 1
                state = 1
                i += 1
                continue
            if c == "/" and i + 1 < n and s[i + 1] == "*":
                in_cmt[i] = 1
                state = 2
                i += 1
                continue
            if c == '"':
                in_str[i] = 1
                state = 3
            elif c == "'":
                in_str[i] = 1
                state = 4
        elif state == 1:
            if c == "\n":
                state = 0
                i += 1
                continue
            in_cmt[i] = 1
        elif state == 2:
            in_cmt[i] = 1
            if c == "*" and i + 1 < n and s[i + 1] == "/":
                in_cmt[i + 1] = 1
                state = 0
                i += 2
                continue
        elif state == 3:
            in_str[i] = 1
            if c == "\\":
                if i + 1 < n:
                    in_str[i + 1] = 1
                    i += 2
                    continue
            elif c == '"':
                state = 0
        elif state == 4:
            in_str[i] = 1
            if c == "\\":
                if i + 1 < n:
                    in_str[i + 1] = 1
                    i += 2
                    continue
            elif c == "'":
                state = 0
        i += 1
    return in_str, in_cmt


def string_mask(s: str):
    """0 inside string/char literals, 1 elsewhere (comments stay 1)."""
    in_str, _ = _classify(s)
    mask = bytearray(b"\x01" * len(s))
    for k, v in enumerate(in_str):
        if v:
            mask[k] = 0
    return mask


def code_mask(s: str):
    """0 inside string/char literals and comments, 1 elsewhere."""
    in_str, in_cmt = _classify(s)
    mask = bytearray(b"\x01" * len(s))
    for k in range(len(s)):
        if in_str[k] or in_cmt[k]:
            mask[k] = 0
    return mask


def brace_balance(text: str) -> int:
    depth = 0
    i = 0
    n = len(text)
    while i < n:
        c = text[i]
        if c == "/" and i + 1 < n:
            if text[i + 1] == "/":
                j = text.find("\n", i)
                i = n if j < 0 else j
                continue
            if text[i + 1] == "*":
                j = text.find("*/", i + 2)
                i = n if j < 0 else j + 2
                continue
        if c in "\"'":
            q = c
            i += 1
            while i < n and text[i] != q:
                i += 2 if text[i] == "\\" else 1
            i += 1
            continue
        if c == "{":
            depth += 1
        elif c == "}":
            depth -= 1
        i += 1
    return depth


def sub_masked(text: str, rx, repl, mask_fn):
    mask = mask_fn(text)
    out = []
    last = 0
    cnt = 0
    for m in rx.finditer(text):
        if not mask[m.start()]:
            continue
        out.append(text[last:m.start()])
        out.append(repl(m))
        last = m.end()
        cnt += 1
    out.append(text[last:])
    return "".join(out), cnt


def process(text: str, counts: dict) -> str:
    text, c = sub_masked(text, BLOCK, lambda m: "", string_mask)
    counts["JADX block comments"] += c
    text, c = sub_masked(text, FAILBLOCK, lambda m: "", string_mask)
    counts["decompile failure comments"] += c
    text, c = sub_masked(text, LINE, lambda m: "", string_mask)
    counts["JADX line comments"] += c
    text, c = sub_masked(text, FROMCLASS, lambda m: "", string_mask)
    counts["from class comments"] += c
    text, c = sub_masked(text, OVERRIDE, lambda m: m.group(1), code_mask)
    counts["@Override trailing comments"] += c
    text, c = sub_masked(text, SYNTH, lambda m: "", string_mask)
    counts["synthetic markers"] += c
    text, c = sub_masked(text, BARESTR, lambda m: "", string_mask)
    counts["bare string statements"] += c
    text = re.sub(r"[ \t]+$", "", text, flags=re.M)
    text = re.sub(r"\n{3,}", "\n\n", text)
    return text


def main() -> int:
    args = [a for a in sys.argv[1:] if not a.startswith("--")]
    apply = "--apply" in sys.argv
    root = pathlib.Path(args[0] if args else "tty-src/src")
    files = sorted(root.rglob("*.java"))
    counts = {
        "JADX block comments": 0,
        "decompile failure comments": 0,
        "JADX line comments": 0,
        "from class comments": 0,
        "@Override trailing comments": 0,
        "synthetic markers": 0,
        "bare string statements": 0,
    }
    changed = 0
    errors = 0
    shown = 0
    for p in files:
        src = p.read_text(errors="ignore")
        before = brace_balance(src)
        new = process(src, counts)
        if brace_balance(new) != before:
            errors += 1
            if shown < 5:
                print(f"ERROR: brace balance changed in {p}")
                shown += 1
            continue
        leftover = [
            m.start()
            for m in LEFTOVER.finditer(new)
            if string_mask(new)[m.start()]
        ]
        if leftover:
            errors += 1
            if shown < 5:
                print(f"ERROR: jadx artifact left in {p}")
                shown += 1
            continue
        if new != src:
            changed += 1
            if apply:
                p.write_text(new)
    for k, v in counts.items():
        print(f"{k}: {v}")
    print(f"files scanned: {len(files)}, files changed: {changed}, errors: {errors}")
    if errors > shown:
        print(f"... and {errors - shown} more errors (suppressed)")
    if not apply:
        print("(check mode, nothing written; pass --apply to write)")
    return 1 if errors else 0


if __name__ == "__main__":
    sys.exit(main())
