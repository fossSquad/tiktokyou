#!/usr/bin/env python3
"""Bulk javac error fixer for the TTY support sources.

Runs javac in a loop, applies mechanical repairs for typical jadx artifacts,
and repeats until the build is clean or nothing more can be fixed
automatically. Unhandled errors are printed with their javac symbol info.

Rules
-----
R1  unreported exception X      -> add `throws X` to the enclosing method
R2  exception X is never thrown -> widen `catch (X ...)` to `catch (Exception`
R3  cannot find symbol th*      -> declare `Throwable th = null;` in the method
                                   (renames a conflicting `catch (Throwable th)`)
R4  cannot find symbol file*    -> drop the stray `file = null;` (or declare it)
R5  extra regex rewrites        -> field renames recorded in EXTRA_FIXES

Anonymous-class methods cannot grow a `throws` clause; they are skipped and
reported. Methods rejected by javac with "overridden method does not throw"
are reverted and skipped on later rounds.

Usage:
    python3 tools/fix_javac_errors.py [--rounds 12] [--dry-run]
"""
from __future__ import annotations

import argparse
import re
import subprocess
import sys
from pathlib import Path

import os
_HERE = Path(__file__).resolve().parent
sys.path.insert(0, str(_HERE))
import clean_jadx  # noqa: E402
import env  # noqa: E402
PROJECT = _HERE.parent

JAVAC = str(env.javac_path() or "javac")


def _default_classpath() -> str:
    filtered = PROJECT / "build" / "mod" / "hook.jar"
    support = filtered if filtered.is_file() else PROJECT / "build" / "lib" / "hook.jar"
    parts = [env.android_jar(), PROJECT / "libs" / "tiktok.jar", support]
    return os.pathsep.join(str(p) for p in parts if p)


CLASSPATH = _default_classpath()
ROOTS = [
    "src/a",
    "src/b",
    "src/c",
    "src/org",
    "src/dalvik",
    "src/util",
    "src/com/windukk/stable",
    "src/com/windukk/hook",
    "src/com/vapro",
    "src/com/ss/android/ugc/aweme/utils",
]
OUT = str(PROJECT / "build" / "support-fix")
LOG = str(PROJECT / "build" / "fix-javac.log")

EXC_PKG = {
    "IOException": "java.io.IOException",
    "FileNotFoundException": "java.io.FileNotFoundException",
    "EOFException": "java.io.EOFException",
    "UnsupportedEncodingException": "java.io.UnsupportedEncodingException",
    "NoSuchAlgorithmException": "java.security.NoSuchAlgorithmException",
    "IllegalAccessException": "java.lang.reflect.IllegalAccessException",
    "InvocationTargetException": "java.lang.reflect.InvocationTargetException",
    "NoSuchMethodException": "java.lang.reflect.NoSuchMethodException",
    "NoSuchFieldException": "java.lang.reflect.NoSuchFieldException",
}
# subclasses normalized to a broader type so callers stay compatible
NORMALIZE = {
    "FileNotFoundException": "IOException",
    "EOFException": "IOException",
    "UnsupportedEncodingException": "IOException",
}

ERR_RE = re.compile(r"^(.*?\.java):(\d+): error: (.*)$")
SYM_RE = re.compile(r"^\s*symbol:\s+(?:variable|method|class)\s+(\S+)\s*$")
CTRL_RE = re.compile(r"^(if|for|while|switch|try|catch|else|finally|do)\b")

# file pattern -> list of (regex, replacement); applied when that file is touched
EXTRA_FIXES = [
    (re.compile(r"\bgVar\.b\b(?!\s*\()"), "gVar.bf"),
]


def mask_text(text: str) -> str:
    """Blank out string and comment characters so brace counting is safe."""
    in_str, in_cmt = clean_jadx._classify(text)
    chars = []
    for i, ch in enumerate(text):
        if (in_str[i] or in_cmt[i]) and ch != "\n":
            chars.append(" ")
        else:
            chars.append(ch)
    return "".join(chars)


def classify(header: str) -> str:
    h = header.strip()
    while h.startswith("}"):
        h = h[1:].strip()
    if not h:
        return "other"
    if CTRL_RE.match(h) or re.match(r"^synchronized\s*\(", h):
        return "control"
    if re.search(r"\b(class|interface|enum|record)\b", h):
        return "class"
    if re.search(r"\bnew\b", h) and h.rstrip().endswith(")"):
        return "anon"
    if "(" in h:
        return "method"
    return "other"


def parse_scopes(masked: str):
    lines = masked.split("\n")
    scopes = []
    stack = []
    for li, line in enumerate(lines):
        for i, c in enumerate(line):
            if c == "{":
                header = line[:i]
                sc = {
                    "kind": classify(header),
                    "header": header,
                    "open_line": li,
                    "start": li,
                    "end": None,
                    "parent": stack[-1] if stack else None,
                    "depth": len(stack),
                }
                scopes.append(sc)
                stack.append(sc)
            elif c == "}" and stack:
                sc = stack.pop()
                sc["end"] = li
    for sc in stack:
        sc["end"] = max(len(lines) - 1, sc["start"])
    return scopes


def enclosing_method(scopes, line):
    cur = None
    for sc in scopes:
        if sc["start"] <= line - 1 <= sc["end"]:
            if cur is None or sc["depth"] > cur["depth"]:
                cur = sc
    while cur is not None and cur["kind"] != "method":
        if cur["kind"] == "class":
            return None
        cur = cur["parent"]
    return cur


def inside_anon(sc):
    p = sc.get("parent")
    while p is not None:
        if p["kind"] == "anon":
            return True
        if p["kind"] == "class":
            return False
        p = p.get("parent")
    return False


def method_name(sc):
    m = re.search(r"([\w$]+)\s*\(", sc["header"])
    return m.group(1) if m else None


def parse_errors(text: str):
    lines = text.split("\n")
    out = []
    for i, ln in enumerate(lines):
        m = ERR_RE.match(ln)
        if not m:
            continue
        err = {
            "file": m.group(1),
            "line": int(m.group(2)),
            "msg": m.group(3),
            "symbol": None,
            "location": None,
        }
        for j in range(i + 1, min(i + 6, len(lines))):
            if ERR_RE.match(lines[j]):
                break
            sm = SYM_RE.match(lines[j])
            if sm and err["symbol"] is None:
                err["symbol"] = sm.group(1)
        out.append(err)
    return out


def throws_token(file_text: str, exc: str) -> str:
    if re.search(r"import\s+[\w.]*\.\s*" + re.escape(exc) + r"\s*;", file_text):
        return exc
    fqn = EXC_PKG.get(exc)
    if fqn is None:
        return exc
    pkg = fqn.rsplit(".", 1)[0]
    if re.search(r"import\s+" + re.escape(pkg) + r"\.\*;", file_text):
        return exc
    return fqn


def add_throws_to_line(line: str, tokens):
    stripped = line.rstrip()
    if not stripped.endswith("{"):
        return None
    head = stripped[:-1].rstrip()
    if "(" not in head:
        return None
    if " throws " in head:
        m = re.search(r"throws\s+(.*)$", head)
        existing = m.group(1)
        have = {t.strip().split(".")[-1] for t in existing.split(",") if t.strip()}
        add = [t for t in tokens if t.split(".")[-1] not in have]
        if not add:
            return line
        head = head[: m.start(1)] + existing + ", " + ", ".join(add)
    else:
        head = head + " throws " + ", ".join(tokens)
    return head + " {"


def indent_of(line: str) -> str:
    return re.match(r"^(\s*)", line).group(1)


def fix_file(path: Path, errs, dry, applied_throws, skip_throws, manual, stats) -> int:
    text = path.read_text(errors="ignore")
    lines = text.split("\n")
    masked = mask_text(text)
    scopes = parse_scopes(masked)

    # (sort_line, priority, kind, payload)
    edits = []
    throws_by_scope = {}
    decls_by_scope = {}

    for e in errs:
        li = e["line"] - 1
        msg = e["msg"]

        m = re.match(r"unreported exception (\w+); must be caught", msg)
        if m:
            exc = NORMALIZE.get(m.group(1), m.group(1))
            sc = enclosing_method(scopes, e["line"])
            if sc is None:
                manual.append((e, "no method scope for throws"))
                continue
            if inside_anon(sc):
                manual.append((e, "anonymous-class method cannot throw"))
                continue
            name = method_name(sc)
            if name and (str(path), name) in skip_throws:
                manual.append((e, "method %s marked skip" % name))
                continue
            throws_by_scope.setdefault(sc["open_line"], (sc, set()))[1].add(exc)
            continue

        m = re.match(r"exception (\w+) is never thrown", msg)
        if m:
            edits.append((li, 1, "catch", m.group(1)))
            continue

        if msg == "cannot find symbol":
            sym = e["symbol"] or ""
            if re.match(r"^th\d*(_\w+)?$", sym):
                sc = enclosing_method(scopes, e["line"])
                if sc is None:
                    manual.append((e, "no method scope for " + sym))
                    continue
                decls_by_scope.setdefault(sc["open_line"], (sc, set()))[1].add(sym)
                continue
            if sym.startswith("file"):
                sc = enclosing_method(scopes, e["line"])
                if sc is None:
                    manual.append((e, "no method scope for " + sym))
                    continue
                edits.append((li, 2, "decl_file", (sc, sym)))
                continue

        if "overridden method does not throw" in msg:
            key = (str(path), li)
            if key in applied_throws:
                edits.append((li, 0, "revert", applied_throws.pop(key)))
            nm = method_name({"header": lines[li]}) if li < len(lines) else None
            if nm:
                skip_throws.add((str(path), nm))
            manual.append((e, "override cannot throw"))
            continue

        manual.append((e, "unhandled"))

    for open_line, (sc, excs) in throws_by_scope.items():
        tokens = [throws_token(text, x) for x in sorted(excs)]
        edits.append((open_line, 1, "throws", (sc, tokens)))

    for open_line, (sc, syms) in decls_by_scope.items():
        edits.append((open_line, 2, "decl_th", (sc, sorted(syms))))

    edits.sort(key=lambda t: (t[0], t[1]), reverse=True)

    applied = 0
    for line_no, _prio, kind, payload in edits:
        if kind == "revert":
            lines[line_no] = payload
            stats["revert"] += 1
            applied += 1
            continue
        if kind == "catch":
            exc = payload
            new = re.sub(
                r"catch\s*\(\s*" + re.escape(exc) + r"\s+",
                "catch (Exception ",
                lines[line_no],
                count=1,
            )
            if new != lines[line_no]:
                lines[line_no] = new
                stats["catch"] += 1
                applied += 1
            continue
        if kind == "throws":
            sc, tokens = payload
            new = add_throws_to_line(lines[line_no], tokens)
            if new is None:
                manual.append(({"file": str(path), "line": line_no + 1, "msg": "throws"}, "multi-line signature"))
                continue
            if new != lines[line_no]:
                applied_throws[(str(path), line_no)] = lines[line_no]
                lines[line_no] = new
                stats["throws"] += 1
                applied += 1
            continue
        if kind == "decl_th":
            sc, syms = payload
            for sym in syms:
                body = "\n".join(lines[sc["start"] : (sc["end"] or sc["start"]) + 1])
                if re.search(r"\bThrowable\s+" + re.escape(sym) + r"\b", body):
                    continue
                # rename a conflicting `catch (Throwable sym)` parameter
                for _ in range(10):
                    cm = re.search(
                        r"catch \(Throwable " + re.escape(sym) + r"\) \{",
                        body,
                    )
                    if not cm:
                        break
                    new_name = sym + "_c"
                    existing = set(re.findall(r"\b(\w+)\b", body))
                    while new_name in existing:
                        new_name += "_"
                    body = body.replace(
                        "catch (Throwable " + sym + ") {",
                        "catch (Throwable " + new_name + ") {",
                        1,
                    )
                    body = body.replace(
                        sym + " = " + sym + ";",
                        sym + " = " + new_name + ";",
                        1,
                    )
                lines[sc["start"] : (sc["end"] or sc["start"]) + 1] = body.split("\n")
                indent = indent_of(lines[sc["open_line"]] if sc["open_line"] < len(lines) else "    ") + "    "
                lines.insert(sc["open_line"] + 1, indent + "Throwable " + sym + " = null;")
                stats["decl_th"] += 1
                applied += 1
            continue
        if kind == "decl_file":
            sc, sym = payload
            body = "\n".join(lines[sc["start"] : (sc["end"] or sc["start"]) + 1])
            cur = lines[line_no]
            if re.search(r"\bFile\s+" + re.escape(sym) + r"\b", body):
                del lines[line_no]
                stats["decl_file_drop"] += 1
            else:
                lines[line_no] = re.sub(
                    r"^\s*" + re.escape(sym) + r"\s*=", "File " + sym + " =", cur
                )
                stats["decl_file_add"] += 1
            applied += 1
            continue

    # R5: extra regex rewrites (field renames etc.)
    joined = "\n".join(lines)
    for pat, repl in EXTRA_FIXES:
        if pat.search(joined):
            joined, n = pat.subn(repl, joined)
            stats["extra"] += n
            applied += n
    lines = joined.split("\n")

    if applied and not dry:
        path.write_text("\n".join(lines))
    return applied


def main() -> int:
    ap = argparse.ArgumentParser(description=__doc__)
    ap.add_argument("--rounds", type=int, default=12)
    ap.add_argument("--dry-run", action="store_true")
    ap.add_argument("--javac", default=JAVAC)
    ap.add_argument("--cp", default=CLASSPATH)
    ap.add_argument("--out", default=OUT)
    ap.add_argument("--log", default=LOG)
    args = ap.parse_args()

    root = Path.cwd()
    files = []
    for r in ROOTS:
        files += [str(p) for p in sorted((root / r).rglob("*.java"))]
    cmd = [args.javac, "-nowarn", "-encoding", "UTF-8", "-cp", args.cp, "-d", args.out] + files

    applied_throws = {}
    skip_throws = set()

    for round_no in range(1, args.rounds + 1):
        Path(args.out).mkdir(parents=True, exist_ok=True)
        proc = subprocess.run(cmd, capture_output=True, text=True)
        Path(args.log).write_text(proc.stderr)
        errs = parse_errors(proc.stderr)
        if proc.returncode == 0 and not errs:
            print("round %d: BUILD SUCCESSFUL" % round_no)
            return 0

        seen = set()
        uniq = []
        for e in errs:
            k = (e["file"], e["line"], e["msg"], e["symbol"])
            if k in seen:
                continue
            seen.add(k)
            uniq.append(e)

        print("round %d: %d unique errors" % (round_no, len(uniq)))

        by_file = {}
        for e in uniq:
            by_file.setdefault(e["file"], []).append(e)

        stats = {k: 0 for k in ("throws", "catch", "decl_th", "decl_file_add", "decl_file_drop", "extra", "revert")}
        manual = []
        total = 0
        for f, es in sorted(by_file.items()):
            total += fix_file(Path(f), es, args.dry_run, applied_throws, skip_throws, manual, stats)

        print(
            "  fixed: throws=%d catch=%d th=%d file+=%d file-=%d extra=%d revert=%d"
            % (
                stats["throws"],
                stats["catch"],
                stats["decl_th"],
                stats["decl_file_add"],
                stats["decl_file_drop"],
                stats["extra"],
                stats["revert"],
            )
        )

        if total == 0:
            print("no automatic fixes left; unhandled errors:")
            for e, why in manual[:60]:
                sym = (" symbol=" + e["symbol"]) if e.get("symbol") else ""
                print("  %s:%s %s [%s]%s" % (e["file"], e["line"], e["msg"], why, sym))
            return 2

    print("rounds exhausted")
    return 1


if __name__ == "__main__":
    sys.exit(main())
