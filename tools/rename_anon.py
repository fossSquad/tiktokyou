#!/usr/bin/env python3
"""Rename metadata-identified anonymous Kotlin hook classes.

Each Z/<anon>.java with @Metadata is an anonymous object created by an inline
lambda passed to HookUtilsKt.before/after/replace/init.  The metadata gives the
original name pattern (HookUtilsKt$before$2 etc.) but not which hook site it
belongs to.  The instantiation site (`new <name>(...)`) lives in the enclosing
hook class, so the class is renamed to `<EnclosingClass>$<kind>$<n>`.

Only reference patterns that cannot collide with unrelated identifiers are
rewritten: `new <name>(`, `Z.<name>`, `<name>.class`, `<name>.this`, the class
declaration and constructor declarations in the class's own file.
"""
import os
import re
import sys
import pathlib

ROOT = pathlib.Path(sys.argv[1] if len(sys.argv) > 1 else "tty-src/src")


def brace_balance(text: str) -> int:
    depth = i = 0
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
            quote = c
            i += 1
            while i < n and text[i] != quote:
                i += 2 if text[i] == "\\" else 1
            i += 1
            continue
        if c == "{":
            depth += 1
        elif c == "}":
            depth -= 1
        i += 1
    return depth


def d2_first(text: str):
    ann = re.search(r"@Metadata\((.*?)\)\s*\n", text, re.S)
    if not ann:
        return None
    d2 = re.search(r"d2\s*=\s*\{(.*?)\}\s*,\s*k", ann.group(1), re.S)
    if not d2:
        return None
    names = re.findall(r'"((?:[^"\\]|\\.)*)"', d2.group(1))
    return names[0] if names else None


def kind_of(fqn: str) -> str:
    tail = fqn.rsplit("/", 1)[-1]
    m = re.search(r"\$([A-Za-z_]\w*)(?:\$\d+)?$", tail)
    return m.group(1) if m else "anon"


def main() -> int:
    files = {p: p.read_text(errors="ignore") for p in sorted(ROOT.rglob("*.java"))}
    anon = [p for p in files if p.parent.name == "Z" and "@Metadata" in files[p]]
    mapping = {}
    orphans = []
    for p in anon:
        fqn = d2_first(files[p])
        if not fqn:
            orphans.append((p, "no d2"))
            continue
        name = p.stem
        sites = []
        for q, t in files.items():
            if q == p:
                continue
            for m in re.finditer(r"new\s+" + re.escape(name) + r"\s*\(", t):
                sites.append((q, t[: m.start()].count("\n") + 1))
        if not sites:
            orphans.append((p, fqn))
            continue
        outer = sites[0][0].stem
        mapping[name] = {"path": p, "fqn": fqn, "kind": kind_of(fqn), "outer": outer, "site": sites[0]}

    # order by instantiation line inside each enclosing class, number per kind
    counters = {}
    plan = {}
    for name, info in sorted(mapping.items(), key=lambda kv: (kv[1]["outer"], kv[1]["site"][1])):
        key = (info["outer"], info["kind"])
        counters[key] = counters.get(key, 0) + 1
        new = f"{info['outer']}${info['kind']}${counters[key]}"
        plan[name] = new

    print("rename plan:")
    for old, new in plan.items():
        info = mapping[old]
        print(f"  {old} -> {new}   ({info['fqn']} @ {info['site'][0].name}:{info['site'][1]})")
    print("orphans (no instantiation site):")
    for p, fqn in orphans:
        print(f"  {p.name}   ({fqn})")

    before_balance = {p: brace_balance(t) for p, t in files.items()}
    texts = dict(files)
    for old, new in plan.items():
        own = mapping[old]["path"]
        t = texts[own]
        t2, n1 = re.subn(r"\bclass\s+" + re.escape(old) + r"\b", "class " + new, t)
        t3, n2 = re.subn(r"(?m)^(\s*(?:(?:public|private|protected|final|static|abstract)\s+)*)" + re.escape(old) + r"\s*\(", r"\1" + new + "(", t2)
        if n1 != 1:
            print(f"ERROR: class declaration not found for {old} in {own}")
            return 1
        texts[own] = t3
        for q in list(texts):
            t = texts[q]
            t, _ = re.subn(r"new\s+" + re.escape(old) + r"\s*\(", "new " + new + "(", t)
            t, _ = re.subn(r"Z\." + re.escape(old) + r"(?![\w$])", "Z." + new, t)
            t, _ = re.subn(r"(?<![\w$])" + re.escape(old) + r"\.class\b", new + ".class", t)
            t, _ = re.subn(r"(?<![\w$])" + re.escape(old) + r"\.this\b", new + ".this", t)
            if t != texts[q]:
                texts[q] = t

    errors = 0
    for q, t in texts.items():
        if brace_balance(t) != before_balance[q]:
            print(f"ERROR: brace balance changed in {q}")
            errors += 1
    if errors:
        print("aborting, no files written")
        return 1

    for old, new in plan.items():
        old_path = mapping[old]["path"]
        new_path = old_path.with_name(new + ".java")
        os.rename(old_path, new_path)
        texts[new_path] = texts.pop(old_path)
    for q, t in texts.items():
        if t != files.get(q):
            q.write_text(t)

    # verification
    all_text = "\n".join(texts.values())
    for old in plan:
        for pat in (r"new\s+" + re.escape(old) + r"\s*\(", r"Z\." + re.escape(old) + r"(?![\w$])"):
            hits = re.findall(pat, all_text)
            if hits:
                print(f"WARN: leftover {pat}: {len(hits)}")
                errors += 1
    leftovers = [q.name for q, t in texts.items() if q.parent.name == "Z" and "@Metadata" in t and q.stem not in plan.values()]
    print(f"renamed {len(plan)} classes, {len(orphans)} orphans left, errors={errors}")
    return 0 if errors == 0 else 1


if __name__ == "__main__":
    sys.exit(main())
