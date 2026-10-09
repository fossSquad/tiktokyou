#!/usr/bin/env python3
"""Restore Main.java member names from Kotlin @Metadata d2 strings.

Renames fields/methods of com.windukk.mod.Main and rewrites all `Main.<letter>`
references across the tree.  Rewrites are restricted to code positions (string
and comment literals are skipped) via a lightweight lexical mask.
"""
import re
import sys
import pathlib

ROOT = pathlib.Path(sys.argv[1] if len(sys.argv) > 1 else "tty-src/src")

MAIN = ROOT / "com/windukk/mod/Main.java"

INTERNAL = [
    ("public static final Main a;", "public static final Main INSTANCE;"),
    ("a = new Main();", "INSTANCE = new Main();"),
    ("public static final String b;", "public static final String MOD_VERSION;"),
    ("public static final int c;", "public static final int versionCode;"),
    ("public static Context d;", "public static Context appContext;"),
    ("public static Application e;", "public static Application mainApplication;"),
    ('b = "v4.4";', 'MOD_VERSION = "v4.4";'),
    ("c = 1790876728;", "versionCode = 1790876728;"),
    ("public static final Context a()", "public static final Context getApplicationContext()"),
    ("Context context = d;", "Context context = appContext;"),
    ("Context applicationContext = e.getApplicationContext();", "Context applicationContext = mainApplication.getApplicationContext();"),
    ("d = applicationContext;", "appContext = applicationContext;"),
    ("e = application;", "mainApplication = application;"),
    ("d = context;", "appContext = context;"),
    ("Main main = a;", "Main main = INSTANCE;"),
    ("public static final int a(float f)", "public static final int dp(float f)"),
    ("public static final void a(Context context)", "public static final void verifySignature(Context context)"),
    ("return (int) TypedValue.applyDimension(1, f, a().getResources().getDisplayMetrics());",
     "return (int) TypedValue.applyDimension(1, f, getApplicationContext().getResources().getDisplayMetrics());"),
]


def code_mask(s: str):
    mask = bytearray(b"\x01" * len(s))
    i = 0
    n = len(s)
    while i < n:
        c = s[i]
        if c == "/" and i + 1 < n:
            if s[i + 1] == "/":
                j = s.find("\n", i)
                j = n if j < 0 else j
                for k in range(i, j):
                    mask[k] = 0
                i = j
                continue
            if s[i + 1] == "*":
                j = s.find("*/", i + 2)
                j = n if j < 0 else j + 2
                for k in range(i, j):
                    mask[k] = 0
                i = j
                continue
        if c in "\"'":
            q = c
            j = i + 1
            while j < n and s[j] != q:
                j += 2 if s[j] == "\\" else 1
            j = min(j + 1, n)
            for k in range(i, j):
                mask[k] = 0
            i = j
            continue
        i += 1
    return mask


def sub_outside(src: str, pat: str, fn):
    mask = code_mask(src)
    out = []
    last = 0
    cnt = 0
    for it in re.finditer(pat, src):
        if not mask[it.start()]:
            continue
        out.append(src[last:it.start()])
        out.append(fn(it))
        last = it.end()
        cnt += 1
    out.append(src[last:])
    return "".join(out), cnt


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


def main() -> int:
    files = {p: p.read_text(errors="ignore") for p in sorted(ROOT.rglob("*.java"))}
    before_balance = {p: brace_balance(t) for p, t in files.items()}

    main_text = files.get(MAIN)
    if main_text is None:
        print(f"skip: {MAIN} not found")
        return 0
    for old, new in INTERNAL:
        cnt = main_text.count(old)
        if cnt == 0:
            if new in main_text:
                continue
            print(f"WARN: internal pattern not found: {old!r} (skipped)")
            continue
        if cnt != 1:
            print(f"ERROR: internal pattern found {cnt} times: {old!r}")
            return 1
        main_text = main_text.replace(old, new)
    files[MAIN] = main_text

    rules = [
        (r"Main\.a\(\s*\)", lambda m: "Main.getApplicationContext()"),
        (r"Main\.a\(([^()]*)\)", lambda m: "Main.verifySignature(" + m.group(1) + ")"
            if m.group(1).strip() == "context" else "Main.dp(" + m.group(1) + ")"),
        (r"Main\.b(?![\w$])", lambda m: "Main.MOD_VERSION"),
        (r"Main\.c(?![\w$])", lambda m: "Main.versionCode"),
        (r"Main\.d(?![\w$])", lambda m: "Main.appContext"),
        (r"Main\.e(?![\w$])", lambda m: "Main.mainApplication"),
        (r"Main\.a(?![\w$])", lambda m: "Main.INSTANCE"),
    ]
    counts = [0] * len(rules)
    changed = 0
    originals = dict(files)
    for p in list(files):
        t = files[p]
        for i, (pat, fn) in enumerate(rules):
            t, c = sub_outside(t, pat, fn)
            counts[i] += c
        if t != files[p]:
            changed += 1
            files[p] = t

    leftovers = sum(len(re.findall(r"Main\.[a-e](?![\w$])", t)) for t in files.values())
    main_bare = sum(len(re.findall(r"(?<![\w$.])[a-e](?![\w$.])", t))
                    for p, t in files.items() if p == MAIN)
    errors = 0
    for p, t in files.items():
        if brace_balance(t) != before_balance[p]:
            print(f"ERROR: brace balance changed in {p}")
            errors += 1
    print("rule counts:", counts)
    print(f"files changed: {changed}, leftover Main.<letter>: {leftovers}, "
          f"balance errors: {errors}, bare letters left in Main.java: {main_bare}")
    if errors or leftovers:
        print("aborting, no files written")
        return 1
    written = 0
    for p, t in files.items():
        if originals[p] != t:
            p.write_text(t)
            written += 1
    print(f"written: {written} files")
    return 0


if __name__ == "__main__":
    sys.exit(main())
