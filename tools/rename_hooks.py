#!/usr/bin/env python3
"""Move R8-obfuscated hook classes out of package Z into com.windukk.mod.hooks.*

Usage:
  python3 tty-src/tools/rename_hooks.py [root]            # check only (default root tty-src/src)
  python3 tty-src/tools/rename_hooks.py [root] --apply    # rewrite files

Name sources:
  - authoritative Kotlin @Metadata: ch=CleanLinkHooks, m3=DownloadMediaStoreHooks
  - Main.start() module labels (me=signature_faker ... y1=browser)
  - log strings inside classes (ah=FrameMetricsLeakHooks, wc=PublishTabHooks,
    fh=SimpleModeHooks, kc=EdgeSpeedupHooks, xe=StoryEngagementHooks)
"""
import pathlib
import re
import shutil
import sys

args = [a for a in sys.argv[1:] if not a.startswith("-")]
ROOT = pathlib.Path(args[0] if args else "tty-src/src")
APPLY = "--apply" in sys.argv

HOOK_PKG = "com.windukk.mod.hooks"

# Names that collide with jadx-generated locals/fields inside package Z
# (e.g. `i3` loop counters, `n` fields).  Deferred until a scope-aware pass.
DEFER = {"n", "i3", "j2", "q", "e6", "t"}

MAP = [
    ("ah", "FrameMetricsLeakHooks", ""),
    ("og", "SettingsHooks", ""),
    ("wc", "PublishTabHooks", ""),
    ("ch", "CleanLinkHooks", ""),
    ("fh", "SimpleModeHooks", ""),
    ("me", "SignatureFakerHooks", ""),
    ("n", "AntiBurnoutHooks", ""),
    ("n6", "MandatoryLoginHooks", ""),
    ("l1", "BadgeHooks", ""),
    ("o2", "CommentStickerHooks", ""),
    ("q2", "ConfigHooks", ""),
    ("jd", "RegionHooks", ""),
    ("a5", "FeedHooks", ""),
    ("kc", "EdgeSpeedupHooks", ""),
    ("xe", "StoryEngagementHooks", ""),
    ("yd", "SearchHooks", ""),
    ("i3", "DownloadHooks", ""),
    ("cc", "PhotoHooks", ""),
    ("j2", "CommentHooks", ""),
    ("od", "SavePhotoHooks", ""),
    ("be", "SeekBarHooks", ""),
    ("qg", "UnlockLimitsHooks", ""),
    ("kb", "OfflineModeHooks", ""),
    ("q", "AuthHooks", ""),
    ("e6", "InboxHooks", ""),
    ("s5", "FontHooks", ""),
    ("t", "AutoStreakHooks", ""),
    ("ig", "ThemeHooks", ""),
    ("l5", "FlagSecureHooks", ""),
    ("y1", "BrowserHooks", ""),
    ("m3", "DownloadMediaStoreHooks", "download"),
]

MODIFIERS = {"public", "private", "protected", "final", "static", "abstract",
             "synchronized", "native", "strictfp", "default"}
CLASS_PREV = {"new", "class", "interface", "enum", "extends", "implements",
              "throws", "instanceof", "import", "package", "return", "catch"}
CAST_BEFORE = set("=<>!,+-*/%&|^?:;({[") | {""}


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


def line_of(src: str, pos: int) -> int:
    return src.count("\n", 0, pos) + 1


def classify(src: str, start: int, end: int, masked) -> str:
    """Return one of: replace, cast, type, anon; or skip_<info> for review."""
    i = start - 1
    while i >= 0 and src[i] in " \t\n":
        i -= 1
    prev_char = src[i] if i >= 0 else ""
    j = i
    while j >= 0 and (src[j].isalnum() or src[j] in "_$"):
        j -= 1
    prev_word = src[j + 1 : i + 1] if i >= 0 else ""
    k = end
    while k < len(src) and src[k] in " \t\n":
        k += 1
    next_char = src[k] if k < len(src) else ""
    l = k
    while l < len(src) and (src[l].isalnum() or src[l] in "_$"):
        l += 1
    next_word = src[k:l]

    if prev_word in CLASS_PREV:
        return "replace"
    if next_char == "." or next_char == "[":
        return "replace"
    if next_char == ":" and src[k : k + 2] == "::":
        return "replace"
    if next_char == "(" and prev_word in MODIFIERS:
        return "replace"
    if prev_char in "(<," and next_char in ")>,":
        m = k + 1
        while m < len(src) and src[m] in " \t":
            m += 1
        if prev_char == "(":
            b = i - 1
            while b >= 0 and src[b] in " \t":
                b -= 1
            before = src[b] if b >= 0 else ""
            if before in CAST_BEFORE:
                return "cast"
            return "skip_paren"
        return "cast"
    if next_word and re.fullmatch(r"[A-Za-z_$][\w$]*", next_word):
        m = l
        while m < len(src) and src[m] in " \t\n":
            m += 1
        after = src[m] if m < len(src) else ""
        if after in "=;,)[:}{":
            return "type"
    return "skip_other"


def add_imports(text: str, fqns: set):
    """Insert `import f;` lines for fqns, keeping rough lexical order."""
    lines = text.split("\n")
    have = {ln.strip() for ln in lines}
    todo = sorted(f"import {f};" for f in fqns if f"import {f};" not in have)
    if not todo:
        return text, 0
    idxs = [i for i, ln in enumerate(lines) if ln.startswith("import ")]
    if idxs:
        for line in todo:
            pos = next((i for i in idxs if lines[i] > line), idxs[-1] + 1)
            lines.insert(pos, line)
            idxs = [i for i, ln in enumerate(lines) if ln.startswith("import ")]
    else:
        pkg = next(i for i, ln in enumerate(lines) if ln.startswith("package "))
        for k, line in enumerate(todo):
            lines.insert(pkg + 1 + k, line)
        lines.insert(pkg + 1 + len(todo), "")
    return "\n".join(lines), len(todo)


def main() -> int:
    if not ROOT.is_dir():
        print(f"no such root: {ROOT}")
        return 1

    files = {p: p.read_text(errors="ignore") for p in sorted(ROOT.rglob("*.java"))}
    masks = {p: code_mask(t) for p, t in files.items()}

    active_map = [m for m in MAP if m[0] not in DEFER]
    deferred = [m for m in MAP if m[0] in DEFER]
    if deferred:
        print("deferred (collide with locals): " + ", ".join(f"{o}->{n}" for o, n, _ in deferred))
        print(f"active renames: {len(active_map)}")

    children_map = {}
    for p in files:
        if p.parent.name == "Z" and "$" in p.stem:
            base = p.stem.split("$", 1)[0]
            children_map.setdefault(base, set()).add(p.stem)

    def is_candidate(p, t, old):
        if p.parent.name == "Z":
            return True
        return re.search(r"(?<![\w$])Z\." + re.escape(old), t) is not None

    suspects = []
    replan = []
    move_set = {}
    for old, new, sub in active_map:
        pkgname = HOOK_PKG + ("." + sub if sub else "")
        token_re = re.compile(r"(?<![\w$.])" + re.escape(old) + r"(?![\w$])")
        child_re = re.compile(r"(?<![\w$.])" + re.escape(old) + r"\$([\w$]+)")
        for p, t in files.items():
            if not is_candidate(p, t, old):
                continue
            mask = masks[p]
            for m in token_re.finditer(t):
                if not mask[m.start()]:
                    continue
                kind = classify(t, m.start(), m.end(), mask)
                if kind.startswith("skip"):
                    suspects.append((old, str(p), line_of(t, m.start()), kind, t[m.start() : m.end() + 20]))
                    continue
                replan.append((p, m.start(), m.end(), new, kind))
            for m in child_re.finditer(t):
                if not mask[m.start()]:
                    continue
                if old + "$" + m.group(1) not in children_map.get(old, set()):
                    continue
                kind = classify(t, m.start(), m.end(), mask)
                child = m.group(1)
                if kind.startswith("skip"):
                    suspects.append((old + "$" + child, str(p), line_of(t, m.start()), kind, t[m.start() : m.end() + 20]))
                    continue
                replan.append((p, m.start(), m.end(), new + "$" + child, kind))
            # Z.OLD qualified refs (import / fully qualified)
            for m in re.finditer(r"(?<![\w$])Z\." + re.escape(old) + r"(?![\w$])", t):
                if not mask[m.start()]:
                    continue
                replan.append((p, m.start(), m.end(), pkgname + "." + new, "qualified"))
            for m in re.finditer(r"(?<![\w$])Z\." + re.escape(old) + r"\$([\w$]+)", t):
                if not mask[m.start()]:
                    continue
                if old + "$" + m.group(1) not in children_map.get(old, set()):
                    continue
                replan.append((p, m.start(), m.start() + len("Z." + old), pkgname + "." + new, "qualified_child"))
        # collect own files for the move (after replacement planning)
        for p in files:
            if p.parent.name == "Z" and (p.stem == old or p.stem.startswith(old + "$")):
                move_set[p] = pkgname

    if suspects:
        print(f"suspect occurrences: {len(suspects)}")
        for s in suspects[:60]:
            print(f"  {s[0]:>12}  {s[1]}:{s[2]}  {s[3]}  {s[4]!r}")
    else:
        print("suspect occurrences: 0")

    plan = sorted(replan, key=lambda x: (x[0], x[1], -(x[2] - x[1])))
    print(f"file moves planned: {len(move_set)}")
    print(f"token replacements planned: {sum(1 for r in plan if r[4] != 'qualified' and r[4] != 'qualified_child')} "
          f"(qualified: {sum(1 for r in plan if r[4] in ('qualified', 'qualified_child'))})")
    if not APPLY:
        print("check mode; rerun with --apply to write")
        return 0
    if suspects:
        print("aborting: resolve suspects first")
        return 1

    # apply token replacements per file (descending order inside a file)
    new_files = dict(files)
    for p in files:
        t = files[p]
        edits = [r for r in plan if r[0] == p]
        edits.sort(key=lambda r: r[1], reverse=True)
        for (_, s, e, rep, _kind) in edits:
            t = t[:s] + rep + t[e:]
        # package decl change for moved files
        if p in move_set:
            pkgname = move_set[p]
            t2, n = re.subn(r"^package Z;", "package " + pkgname + ";", t, count=1, flags=re.M)
            if n != 1:
                print(f"ERROR: no package decl rewritten in {p}")
                return 1
            t = t2
        new_files[p] = t

    # ensure imports for hook classes referenced from other packages
    name_pkg = {}
    for old, new, sub in active_map:
        pkgname = HOOK_PKG + ("." + sub if sub else "")
        name_pkg[new] = pkgname
    for base, stems in children_map.items():
        for old, new, sub in active_map:
            if base == old:
                pkgname = HOOK_PKG + ("." + sub if sub else "")
                for stem in stems:
                    name_pkg[new + stem[len(old):]] = pkgname
    needed = {}
    for (p, s, e, rep, kind) in plan:
        if kind in ("qualified", "qualified_child"):
            continue
        needed.setdefault(p, set()).add(rep)
    imports_added = 0
    for p, t in list(new_files.items()):
        names = needed.get(p)
        if not names:
            continue
        if p in move_set:
            final_pkg = move_set[p]
        else:
            m = re.search(r"^package ([\w.]+);", t, re.M)
            final_pkg = m.group(1) if m else ""
        fqns = {name_pkg[n] + "." + n for n in names if name_pkg.get(n) and name_pkg[n] != final_pkg}
        if fqns:
            t, added = add_imports(t, fqns)
            new_files[p] = t
            imports_added += added

    errors = 0
    for p, t in new_files.items():
        if brace_balance(t) != brace_balance(files[p]):
            print(f"ERROR: brace balance changed in {p}")
            errors += 1
    if errors:
        print("aborting: balance errors")
        return 1

    # write contents, then move files
    moved = 0
    for p in files:
        if new_files[p] != files[p] or p in move_set:
            p.write_text(new_files[p])
    for p, pkgname in move_set.items():
        stem = p.stem  # e.g. cc$before$1
        for old, new, sub in MAP:
            if stem == old or stem.startswith(old + "$"):
                newstem = new + stem[len(old):]
                break
        else:
            print(f"ERROR: no map entry for {p}")
            return 1
        rel = pkgname.replace(".", "/")
        target = ROOT / rel / (newstem + ".java")
        target.parent.mkdir(parents=True, exist_ok=True)
        if target.exists():
            print(f"ERROR: target exists: {target}")
            return 1
        shutil.move(str(p), str(target))
        moved += 1
    print(f"written: {moved} files moved, imports added: {imports_added}")

    # leftover scan (candidate files only: package Z, or still holds a Z.<old> ref)
    leftover = 0
    for old, new, sub in active_map:
        rx = re.compile(r"(?<![\w$.])" + re.escape(old) + r"(?![\w$])")
        rx2 = re.compile(r"(?<![\w$.])" + re.escape(old) + r"\$")
        for p in ROOT.rglob("*.java"):
            t = p.read_text(errors="ignore")
            if p.parent.name != "Z" and not re.search(r"(?<![\w$])Z\." + re.escape(old), t):
                continue
            mask = code_mask(t)
            for m in rx.finditer(t):
                if mask[m.start()]:
                    leftover += 1
                    print(f"LEFTOVER {old} -> {p}:{line_of(t, m.start())}")
            for m in rx2.finditer(t):
                if mask[m.start()]:
                    leftover += 1
                    print(f"LEFTOVER {old}$ -> {p}:{line_of(t, m.start())}")
    print(f"leftover refs: {leftover}")
    return 1 if leftover else 0


if __name__ == "__main__":
    sys.exit(main())
