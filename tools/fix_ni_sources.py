#!/usr/bin/env python3
"""Repair jadx Kotlin-generics artifacts in the ni.shikatu sources.

jadx loses some generic context when decompiling Kotlin bytecode:

  * nested classes reference an outer type variable without declaring it
    (javac: "non-static type variable T cannot be referenced from a static
    context", or "cannot find symbol: class T");
  * some anonymous classes were named (C00221, AnonymousClass1) but never
    declared, leaving stray return types;
  * a few duplicate bridge members clash at source level ("name clash",
    "method next() is already defined").

This tool runs javac in a loop and repairs those mechanically:

  A. for "non-static type variable X" errors, add X to the enclosing class's
     type-parameter list (or, when the class already declares X, to the
     enclosing method's type-parameter list);
  B. for "cannot find symbol: class X" where X looks like a type variable
     (single uppercase letter, optionally with digits) and the error location
     names a class of the same file, add X to that class's type parameters;
  C. one-shot targeted repairs for the named anonymous types, duplicate
     bridges and a static method using a class-level type variable.

Usage:
  python3 tools/fix_ni_sources.py [--rounds 12] [--dry-run] [--javac <path>]
"""
import argparse
import os
import pathlib
import re
import subprocess
import sys

TOOLS = pathlib.Path(__file__).resolve().parent
PROJECT = TOOLS.parent
sys.path.insert(0, str(TOOLS))
import env  # noqa: E402

ROOTS = ["src/ni", "src/org/jetbrains"]
OUT = PROJECT / "build" / "ni-classes"
LOG = PROJECT / "build" / "ni-javac.err"

ERR = re.compile(r"^(.*\.java):(\d+): error: (.*)$")
CLS = re.compile(
    r"^\s*(?:(?:public|protected|private|static|final|abstract|strictfp)\s+)*"
    r"(class|interface|enum)\s+([\w$]+)\s*(<([^>{;]*)>)?"
)
METHOD = re.compile(
    r"^(\s*)((?:(?:public|protected|private|static|final|abstract|"
    r"synchronized|native|strictfp)\s+)*)([\w.$<>\[\],?]+)\s+(\w+)\s*\("
)
VAR = re.compile(r"^[A-Z][A-Z0-9]?$")
NONSTATIC = re.compile(r"non-static type variable (\w+) cannot be referenced")


def classpath() -> str:
    parts = [
        env.android_jar(),
        PROJECT / "libs" / "tiktok.jar",
        PROJECT / "build" / "lib" / "mod-lib.jar",
    ]
    return os.pathsep.join(str(p) for p in parts if p)


def sub_file(path: pathlib.Path, pattern: str, repl: str, dry: bool) -> int:
    text = path.read_text(errors="ignore")
    new, n = re.subn(pattern, repl, text)
    if n and not dry:
        path.write_text(new)
    return n


def targeted_fixes(dry: bool) -> int:
    hits = 0
    p = PROJECT / "src/ni/shikatu/kotlinx/serialization/json/internal/AbstractJsonTreeEncoder.java"
    if p.is_file():
        hits += sub_file(p, r"private final C00221 inlineUnsignedNumberEncoder\(",
                         "private final AbstractEncoder inlineUnsignedNumberEncoder(", dry)
        hits += sub_file(p, r"private final AnonymousClass1 inlineUnquotedLiteralEncoder\(",
                         "private final AbstractEncoder inlineUnquotedLiteralEncoder(", dry)
    p = PROJECT / "src/ni/shikatu/kotlinx/serialization/internal/ClassValueReferences.java"
    if p.is_file():
        hits += sub_file(
            p,
            r"\n\s*public /\* bridge \*/\s+Object computeValue\(Class p0\)\s*\{\s*"
            r"return computeValue\(\(Class<\?>\) p0\);\s*\}\n",
            "\n", dry)
    p = PROJECT / "src/ni/shikatu/kotlin/collections/ByteIterator.java"
    if p.is_file():
        hits += sub_file(
            p,
            r"\n\s*public /\* bridge \*/\s+Byte next\(\)\s*\{\s*"
            r"return Byte\.valueOf\(nextByte\(\)\);\s*\}\n",
            "\n", dry)
    p = PROJECT / "src/ni/shikatu/kotlin/Result.java"
    if p.is_file():
        text = p.read_text(errors="ignore")
        new, n = re.subn(r"private static final T m10getOrNullimpl\(Object obj\)",
                         "private static final <T> T m10getOrNullimpl(Object obj)", text)
        if n:
            idx = new.find("m10getOrNullimpl")
            end = new.find("\n    }", idx)
            if idx != -1 and end != -1:
                seg = new[idx:end]
                seg2 = seg.replace("return obj;", "return (T) obj;")
                if seg2 != seg:
                    new = new[:idx] + seg2 + new[end:]
            if not dry:
                p.write_text(new)
            hits += n
    return hits


def compile_ni(javac: str):
    files = []
    for r in ROOTS:
        files += sorted(str(p) for p in (PROJECT / r).rglob("*.java"))
    for p in sorted((PROJECT / "tools" / "ni-stubs").rglob("*.java")):
        files.append(str(p))
    cmd = [javac, "-nowarn", "-encoding", "UTF-8", "-cp", classpath(),
           "-d", str(OUT)] + files
    OUT.mkdir(parents=True, exist_ok=True)
    proc = subprocess.run(cmd, capture_output=True, text=True)
    LOG.write_text(proc.stderr)
    return proc.returncode, proc.stderr


def parse_errors(log: str):
    lines = log.split("\n")
    out = []
    for i, ln in enumerate(lines):
        m = ERR.match(ln.strip())
        if not m:
            continue
        msg = m.group(3)
        sym = loc = None
        for j in range(i + 1, min(len(lines), i + 12)):
            s = lines[j].strip()
            ms = re.match(r"symbol:\s+class\s+(\S+)", s)
            if ms:
                sym = ms.group(1)
            ml = re.match(r"location:\s+class\s+(\S+)", s)
            if ml:
                loc = ml.group(1)
                break
            if ERR.match(s):
                break
        out.append((m.group(1), int(m.group(2)), msg, sym, loc))
    return out


def enclosing_class(lines, upto):
    for i in range(upto - 1, -1, -1):
        m = CLS.match(lines[i])
        if m:
            return i, m
    return None, None


def enclosing_method(lines, upto):
    for i in range(upto - 1, -1, -1):
        m = METHOD.match(lines[i])
        if m:
            return i, m
    return None, None


def add_params(line, inner, names):
    have = set(re.findall(r"[A-Z]\w*", inner or ""))
    add = [n for n in names if n not in have]
    if not add:
        return line, 0
    if inner:
        return line.replace("<" + inner + ">",
                            "<" + inner + ", " + ", ".join(add) + ">", 1), len(add)
    tail = "<" + ", ".join(add) + "> "
    m = re.search(r"\s(implements|extends)\b", line)
    if m:
        return line[:m.start(1)] + tail + line[m.start(1):], len(add)
    m = re.search(r"\{\s*$", line)
    if m:
        return line[:m.start()].rstrip() + " " + tail + line[m.start():], len(add)
    return line, 0


def plan_edit(lines, error_line, name):
    ci, cm = enclosing_class(lines, error_line)
    if ci is not None:
        inner = cm.group(4) or ""
        if not re.search(r"\b" + re.escape(name) + r"\b", inner):
            return ("class", ci, name)
    mi, _ = enclosing_method(lines, error_line)
    if mi is not None:
        if not re.search(r"<[^>]*\b" + re.escape(name) + r"\b[^>]*>", lines[mi]):
            return ("method", mi, name)
    return None


DUP = re.compile(r"method ([A-Za-z_$][\w$]*)\([^)]*\) is already defined")


def class_simple_name(loc):
    name = (loc or "").split("<", 1)[0]
    return re.split(r"[.$]", name)[-1]


def delete_bridge(lines, name):
    """Delete the /* bridge */ duplicate of name(...) in lines."""
    deleted = 0
    pat = re.compile(r"\b" + re.escape(name) + r"\s*\(")
    i = 0
    while i < len(lines):
        if "/* bridge */" in lines[i] and pat.search(lines[i]):
            start = i
            k = i - 1
            while k >= 0 and lines[k].strip().startswith("@"):
                start = k
                k -= 1
            depth = 0
            j = i
            started = False
            while j < len(lines):
                depth += lines[j].count("{") - lines[j].count("}")
                if "{" in lines[j]:
                    started = True
                if started and depth <= 0:
                    break
                j += 1
            del lines[start:j + 1]
            if start < len(lines) and lines[start].strip() == "":
                del lines[start]
            deleted += 1
            i = start
            continue
        i += 1
    return deleted


ANN = re.compile(r"^\s*@([\w.]+)")


def is_method_decl(line: str) -> bool:
    s = line.strip()
    if "(" not in s or not (s.endswith("{") or s.endswith(";")):
        return False
    head = s.split("(", 1)[0]
    head = re.sub(
        r"^(?:(?:public|protected|private|static|final|synchronized|abstract|native|strictfp|transient|volatile)\s+)+",
        "", head)
    toks = [t for t in re.split(r"\s+", head.strip()) if t]
    return len(toks) >= 2


def cleanup_annotations(lines):
    """Collapse duplicate annotation runs; drop @Override before non-methods."""
    changed = 0
    i = 0
    while i < len(lines):
        m = ANN.match(lines[i])
        if not m:
            i += 1
            continue
        name = m.group(1)
        j = i + 1
        last = i
        while j < len(lines):
            s = lines[j].strip()
            if s == "":
                j += 1
                continue
            m2 = ANN.match(lines[j])
            if m2 and m2.group(1) == name:
                last = j
                j += 1
                continue
            break
        if last > i:
            for idx in reversed(range(i, last + 1)):
                if idx != last and (lines[idx].strip() == "" or ANN.match(lines[idx])):
                    del lines[idx]
                    changed += 1
            continue
        i += 1
    i = 0
    while i < len(lines):
        if lines[i].strip() == "@Override":
            j = i + 1
            while j < len(lines) and lines[j].strip() in ("", "@Override"):
                j += 1
            decl = lines[j] if j < len(lines) else ""
            if not is_method_decl(decl):
                del lines[i]
                changed += 1
                continue
        i += 1
    return changed


def cleanup_annotations_all(dry):
    changed = 0
    for root in ROOTS:
        for path in sorted((PROJECT / root).rglob("*.java")):
            lines = path.read_text(errors="ignore").split("\n")
            n = cleanup_annotations(lines)
            if n and not dry:
                path.write_text("\n".join(lines))
            changed += n
    return changed


def fix_values_refs(dry):
    changed = 0
    old = "EnumEntriesKt.enumEntries($VALUES)"
    new = "EnumEntriesKt.enumEntries(values())"
    for root in ROOTS:
        for path in sorted((PROJECT / root).rglob("*.java")):
            text = path.read_text(errors="ignore")
            if old in text:
                changed += text.count(old)
                if not dry:
                    path.write_text(text.replace(old, new))
    return changed


def fix_rcompat(dry):
    """Rewrite leaked Z.RCompat calls to ni Result intrinsics."""
    pairs = (
        ("RCompat.m6constructorimpl(", "ni.shikatu.kotlin.Result.m6constructorimpl("),
        ("RCompat.m9exceptionOrNullimpl(", "ni.shikatu.kotlin.Result.m9exceptionOrNullimpl("),
        ("RCompat.m12isFailureimpl(", "ni.shikatu.kotlin.Result.m12isFailureimpl("),
        ("RCompat.m13isSuccessimpl(", "ni.shikatu.kotlin.Result.m13isSuccessimpl("),
        ("RCompat.m5boximpl(", "ni.shikatu.kotlin.Result.m5boximpl("),
    )
    changed = 0
    for root in ROOTS:
        for path in sorted((PROJECT / root).rglob("*.java")):
            text = path.read_text(errors="ignore")
            hits = sum(text.count(old) for old, _ in pairs)
            if not hits:
                continue
            if not dry:
                for old, new in pairs:
                    text = text.replace(old, new)
                path.write_text(text)
            changed += hits
    return changed


def fix_deprecated_messages(dry):
    """Kotlin @Deprecated requires the message element."""
    changed = 0
    pat = re.compile(r"^(\s*)@Deprecated\s*$", re.M)
    for root in ROOTS:
        for path in sorted((PROJECT / root).rglob("*.java")):
            text = path.read_text(errors="ignore")
            if "import ni.shikatu.kotlin.Deprecated" not in text:
                continue
            new, n = pat.subn(r'\1@Deprecated(message = "Deprecated")', text)
            if n:
                changed += n
                if not dry:
                    path.write_text(new)
    return changed


CONVERT = re.compile(r"incompatible types: (.*) cannot be converted to (.*)")
INCONVERTIBLE = re.compile(r"inconvertible types")


def try_cast(line, target):
    if f"({target})" in line:
        return None
    m = re.match(r"^(\s*)return\s+([A-Za-z_$][\w$.]*)\((.*)\);\s*$", line)
    if m and "," in m.group(3):
        head, tail = m.group(3).rsplit(",", 1)
        return f"{m.group(1)}return {m.group(2)}({head}, ({target}) ({tail.strip()}));"
    m = re.match(r"^(\s*)return\s+(.+);\s*$", line)
    if m:
        return f"{m.group(1)}return ({target}) ({m.group(2)});"
    m = re.match(r"^(\s*)((?:[A-Za-z_$][\w$.<>\[\], ?]*\s+)?)([A-Za-z_$][\w$.]*)\s*=\s*(.+);\s*$", line)
    if m:
        return f"{m.group(1)}{m.group(2)}{m.group(3)} = ({target}) ({m.group(4)});"
    m = re.match(r"^(\s*)([A-Za-z_$][\w$.]*)\((.*)\);\s*$", line)
    if m and "," in m.group(3):
        head, tail = m.group(3).rsplit(",", 1)
        return f"{m.group(1)}{m.group(2)}({head}, ({target}) ({tail.strip()}));"
    return None


def collapse_stacked_casts(dry):
    """Collapse repeated identical casts: (T) ((T) (x)) -> (T) (x)."""
    changed = 0
    for root in ROOTS:
        for path in sorted((PROJECT / root).rglob("*.java")):
            text = path.read_text(errors="ignore")
            prev = None
            cur = text
            while cur != prev:
                prev = cur
                cur, n = re.subn(r"\(([^()\n]+)\) \(\(\1\)", r"(\1) (", cur)
                changed += n
            if cur != text and not dry:
                path.write_text(cur)
    return changed


CAPCONV = re.compile(r"incompatible types: .* cannot be converted to CAP#\d+")
CAP_METHODS = ("compare", "invoke", "add", "put")


def find_call_args(line, name):
    m = re.search(r"\." + name + r"\(", line)
    if not m:
        return None
    start = m.end()
    depth = 1
    i = start
    while i < len(line) and depth:
        c = line[i]
        if c == "(":
            depth += 1
        elif c == ")":
            depth -= 1
            if depth == 0:
                break
        i += 1
    if depth != 0:
        return None
    inner = line[start:i]
    parts = []
    d = 0
    last = 0
    for j, c in enumerate(inner):
        if c == "(":
            d += 1
        elif c == ")":
            d -= 1
        elif c == "," and d == 0:
            parts.append((last, j))
            last = j + 1
    parts.append((last, len(inner)))
    return start, inner, parts


def wrap_cap_arg(line, tv):
    for name in CAP_METHODS:
        m = re.search(r"(?<![\w$.])([A-Za-z_$][\w$]*)\.(" + name + r")\(", line)
        if not m:
            continue
        recv = m.group(1)
        found = find_call_args(line, name)
        if not found:
            continue
        start, inner, parts = found
        close = start + len(inner)
        deref = line[close + 1:close + 2] == "."
        raw = None
        if name == "compare":
            raw = "Comparator"
        elif name == "add":
            raw = "Collection"
        elif name == "put":
            raw = "Map"
        elif name == "invoke":
            raw = f"Function{len(parts)}"
        if not deref and raw:
            if f"(({raw}) {recv})" in line:
                return None
            return line[:m.start(1)] + f"(({raw}) {recv})" + line[m.end(1):]
        if tv:
            a, b = parts[-1]
            arg = inner[a:b]
            if not arg.strip() or arg.strip().startswith(f"({tv})"):
                continue
            mcast = re.match(r"\s*\(([^()]+)\)\s*(.+)$", arg)
            if mcast:
                newarg = arg[:mcast.start(1)] + tv + arg[mcast.end(1):]
            else:
                lead = len(arg) - len(arg.lstrip())
                newarg = arg[:lead] + f"({tv}) " + arg[lead:]
            return line[:start] + inner[:a] + newarg + inner[b:] + line[start + len(inner):]
    return None


def enclosing_typevar(lines, upto):
    for i in range(upto - 1, max(-1, upto - 80), -1):
        s = lines[i]
        if "(" not in s and "class " not in s and "interface " not in s:
            continue
        mt = re.search(r"<([A-Z][A-Za-z0-9_]*(?:\s*,[^>]*)?)>", s)
        if mt:
            last = re.split(r",", mt.group(1))[-1].strip()
            first = re.split(r"[\s]", last)[0]
            if re.match(r"^[A-Z][A-Za-z0-9_]*$", first):
                return first
    return None


def type_arg_of(type_text, idx):
    mt = re.search(r"<([^<>]*)>", type_text)
    if not mt:
        return None
    parts = [p.strip() for p in mt.group(1).split(",")]
    if idx >= len(parts):
        return None
    mb = re.search(r"(?:super|extends)\s+([A-Z][A-Za-z0-9_]*)", parts[idx])
    if mb:
        return mb.group(1)
    mb = re.match(r"([A-Z][A-Za-z0-9_]*)", parts[idx])
    return mb.group(1) if mb else None


def cap_candidate(lines, upto):
    line = lines[upto - 1]
    idx = None
    for call, arg_idx in ((".compare(", 0), (".invoke(", 0), (".add(", 0), (".put(", 1)):
        if call in line:
            idx = arg_idx
            break
    if idx is None:
        return enclosing_typevar(lines, upto)
    recv = None
    m = re.search(r"([A-Za-z_$][\w$]*)\s*(\.compare|\.invoke|\.add|\.put)\(", line)
    if m:
        recv = m.group(1)
    for i in range(upto - 2, max(-1, upto - 80), -1):
        s = lines[i]
        if "(" not in s or ")" not in s or s.rstrip().endswith(";"):
            continue
        if recv:
            mt = re.search(
                r"([A-Za-z_$][\w$.]*(?:<[^<>]*>)?)\s+" + re.escape(recv) + r"\b", s)
            if mt:
                cand = type_arg_of(mt.group(1), idx)
                if cand:
                    return cand
        break
    return enclosing_typevar(lines, upto)


def raw_receiver_fix(lines, line_no):
    """Wrap the receiver of .invoke/.compare/.add/.put in a raw cast."""
    line = lines[line_no - 1]
    for name in CAP_METHODS:
        m = re.search(r"([A-Za-z_$][\w$.]*)\.(" + name + r")\(", line)
        if not m:
            continue
        recv = m.group(1)
        if line[max(0, m.start(1) - 2):m.start(1)] == "((":
            return None
        raw = None
        for i in range(line_no - 1, max(-1, line_no - 140), -1):
            s = lines[i]
            if "(" not in s and "class " not in s and "interface " not in s:
                continue
            mm = re.search(r"([A-Za-z_$][\w$.]*)\s*(?:<[^;{}]*?>)?\s+" + re.escape(recv) + r"\b", s)
            if mm:
                cand = mm.group(1)
                if cand != recv and cand not in (
                        "return", "if", "for", "while", "new", "final", "public",
                        "private", "protected", "static", "abstract", "class", "interface"):
                    raw = cand
                    break
        if raw and re.fullmatch(r"[A-Z][A-Za-z0-9_]*", raw):
            for i in range(line_no - 1, max(-1, line_no - 140), -1):
                mt = re.search(r"<([^<>]*)>", lines[i])
                if not mt:
                    continue
                for part in re.split(r",(?![^<]*>)", mt.group(1)):
                    pb = re.match(r"\s*([A-Z][A-Za-z0-9_]*)\s+extends\s+([A-Za-z_$][\w$.]*)", part)
                    if pb and pb.group(1) == raw:
                        raw = pb.group(2)
                        break
                if not re.fullmatch(r"[A-Z][A-Za-z0-9_]*", raw):
                    break
        if not raw:
            return None
        return line[:m.start(1)] + f"(({raw}) {recv})." + m.group(2) + "(" + line[m.end(0):]
    return None


def cap_fix(lines, idx):
    ln = idx + 1
    res = raw_receiver_fix(lines, ln)
    if res:
        return res
    tv = cap_candidate(lines, ln)
    if tv:
        return wrap_cap_arg(lines[idx], tv)
    return None


def strip_typevar_receiver_casts(dry):
    """Drop redundant receiver casts to a type variable: ((T) x).m() -> x.m()."""
    changed = 0
    pat = re.compile(r"(?<![\w$(])\(\(([A-Z][0-9]?)\)\s+([A-Za-z_$][\w$]*)\)\.")
    for root in ROOTS:
        for path in sorted((PROJECT / root).rglob("*.java")):
            text = path.read_text(errors="ignore")
            new, n = pat.subn(r"\2.", text)
            if n:
                changed += n
                if not dry:
                    path.write_text(new)
    return changed


def normalize_raw_receivers(dry):
    """Fix raw receiver casts: ((FunctionN) f).invoke(...) arity, ((C) c).add -> ((Collection) c),
    strip the cast when the call result is dereferenced."""
    changed = 0
    for root in ROOTS:
        for path in sorted((PROJECT / root).rglob("*.java")):
            text = path.read_text(errors="ignore")
            lines = text.split("\n")
            local = 0
            for i, line in enumerate(lines):
                m = re.search(r"\(\((Function\d+|[A-Za-z_$][\w$.]*)\)\s+([A-Za-z_$][\w$]*)\)\.([A-Za-z_$][\w$]*)\(", line)
                if not m:
                    continue
                cast, recv, method = m.group(1), m.group(2), m.group(3)
                if method not in CAP_METHODS:
                    continue
                found = find_call_args(line, method)
                if not found:
                    continue
                _, inner, parts = found
                close = found[0] + len(inner)
                deref = line[close + 1:close + 2] == "."
                if method == "invoke":
                    want = f"Function{len(parts)}"
                elif method == "compare":
                    want = "Comparator"
                elif method == "add":
                    want = "Collection"
                else:
                    want = "Map"
                if deref:
                    repl = f"{recv}.{method}("
                else:
                    if cast == want:
                        continue
                    repl = f"(({want}) {recv}).{method}("
                lines[i] = line[:m.start()] + repl + line[m.end():]
                local += 1
            if local:
                changed += local
                if not dry:
                    path.write_text("\n".join(lines))
    return changed


def repair_broken_invokes(dry):
    """Restore parens lost by the receiver-cast strip: .invokeX. -> .invoke(X)."""
    changed = 0
    pat = re.compile(r"\.invoke([A-Za-z_$][\w$]*)\.", re.M)
    for root in ROOTS:
        for path in sorted((PROJECT / root).rglob("*.java")):
            text = path.read_text(errors="ignore")
            new, n = pat.subn(r".invoke(\1).", text)
            if n:
                changed += n
                if not dry:
                    path.write_text(new)
    return changed


def fix_entry_imports(dry):
    """Add java.util.Map.Entry import where jadx dropped the Map. qualifier."""
    changed = 0
    for root in ROOTS:
        for path in sorted((PROJECT / root).rglob("*.java")):
            text = path.read_text(errors="ignore")
            if "Entry<" not in text:
                continue
            if "import java.util.Map.Entry;" in text:
                continue
            if re.search(r"\b(?:class|interface|enum)\s+Entry\b", text):
                continue
            lines = text.split("\n")
            idx = 0
            for i, ln in enumerate(lines):
                if ln.startswith("package "):
                    idx = i + 1
                    break
            lines.insert(idx, "import java.util.Map.Entry;")
            changed += 1
            if not dry:
                path.write_text("\n".join(lines))
    return changed


def fix_super_calls(dry):
    """DefaultImpls: X.super.m(...) -> $this.m(...)."""
    changed = 0
    pat = re.compile(r"\b[A-Za-z_$][\w$]*\.super\.")
    for root in ROOTS:
        for path in sorted((PROJECT / root).rglob("*.java")):
            text = path.read_text(errors="ignore")
            new, n = pat.subn("$this.", text)
            if n:
                changed += n
                if not dry:
                    path.write_text(new)
    return changed


def fix_companion_selfrefs(dry):
    """X X = X.$$INSTANCE; -> fully qualified singleton reference."""
    changed = 0
    pat = re.compile(r"^(\s*public static final )(\w+) (\w+) = (\w+)\.\$\$INSTANCE;$", re.M)
    for root in ROOTS:
        for path in sorted((PROJECT / root).rglob("*.java")):
            text = path.read_text(errors="ignore")
            if ".$$INSTANCE;" not in text:
                continue
            m0 = re.search(r"^package\s+([\w.]+);", text, re.M)
            pkg = m0.group(1) if m0 else ""
            stem = path.stem

            def repl(m):
                if m.group(2) != m.group(4):
                    return m.group(0)
                fqn = f"{pkg}.{stem}.{m.group(2)}.$$INSTANCE"
                return f"{m.group(1)}{m.group(2)} {m.group(3)} = {fqn};"

            new, n = pat.subn(repl, text)
            if n:
                changed += n
                if not dry:
                    path.write_text(new)
    return changed


def delete_super_bridges(dry):
    """Delete redundant /* bridge */ methods whose body calls super."""
    changed = 0
    for root in ROOTS:
        for path in sorted((PROJECT / root).rglob("*.java")):
            lines = path.read_text(errors="ignore").split("\n")
            local = 0
            i = 0
            while i < len(lines):
                if "/* bridge */" in lines[i] and "(" in lines[i]:
                    j = i
                    depth = 0
                    started = False
                    while j < len(lines):
                        depth += lines[j].count("{") - lines[j].count("}")
                        if "{" in lines[j]:
                            started = True
                        if started and depth <= 0:
                            break
                        j += 1
                    block = "\n".join(lines[i:j + 1])
                    if "super." in block:
                        start = i
                        while start - 1 >= 0 and (
                                lines[start - 1].strip().startswith("@")
                                or lines[start - 1].strip() == ""):
                            start -= 1
                        del lines[start:j + 1]
                        local += 1
                        i = start
                        continue
                i += 1
            if local:
                changed += local
                if not dry:
                    path.write_text("\n".join(lines))
    return changed


def main() -> int:
    ap = argparse.ArgumentParser(description=__doc__)
    ap.add_argument("--rounds", type=int, default=20)
    ap.add_argument("--dry-run", action="store_true")
    ap.add_argument("--javac", default=str(env.javac_path() or "javac"))
    args = ap.parse_args()

    if not args.dry_run:
        n = targeted_fixes(dry=False)
        print(f"targeted fixes: {n}")
        print(f"$VALUES rewrites: {fix_values_refs(dry=False)}")
        print(f"annotation cleanups: {cleanup_annotations_all(dry=False)}")
        print(f"RCompat rewrites: {fix_rcompat(dry=False)}")
        print(f"@Deprecated messages: {fix_deprecated_messages(dry=False)}")
        print(f"stacked-cast collapses: {collapse_stacked_casts(dry=False)}")
        print(f"typevar receiver cast strips: {strip_typevar_receiver_casts(dry=False)}")
        print(f"super-call fixes: {fix_super_calls(dry=False)}")
        print(f"companion selfref fixes: {fix_companion_selfrefs(dry=False)}")
        print(f"super bridge deletions: {delete_super_bridges(dry=False)}")
        print(f"broken invoke repairs: {repair_broken_invokes(dry=False)}")
        print(f"Entry import fixes: {fix_entry_imports(dry=False)}")
        print(f"raw receiver normalizations: {normalize_raw_receivers(dry=False)}")
    else:
        print(f"targeted fixes (dry): {targeted_fixes(dry=True)}")
        print(f"RCompat rewrites (dry): {fix_rcompat(dry=True)}")
        print(f"@Deprecated messages (dry): {fix_deprecated_messages(dry=True)}")
        print(f"stacked-cast collapses (dry): {collapse_stacked_casts(dry=True)}")
        print(f"typevar receiver cast strips (dry): {strip_typevar_receiver_casts(dry=True)}")
        print(f"super-call fixes (dry): {fix_super_calls(dry=True)}")
        print(f"companion selfref fixes (dry): {fix_companion_selfrefs(dry=True)}")
        print(f"super bridge deletions (dry): {delete_super_bridges(dry=True)}")
        print(f"broken invoke repairs (dry): {repair_broken_invokes(dry=True)}")
        print(f"Entry import fixes (dry): {fix_entry_imports(dry=True)}")
        print(f"raw receiver normalizations (dry): {normalize_raw_receivers(dry=True)}")

    cast_memory = {}
    for round_no in range(1, args.rounds + 1):
        code, log = compile_ni(args.javac)
        errs = parse_errors(log)
        if code == 0 and not errs:
            print(f"round {round_no}: BUILD SUCCESSFUL")
            return 0
        uniq = []
        seen = set()
        for e in errs:
            if e in seen:
                continue
            seen.add(e)
            uniq.append(e)
        print(f"round {round_no}: {len(uniq)} unique errors")

        class_edits = {}
        method_edits = {}
        dup_edits = {}
        cast_edits = {}
        revert_edits = {}
        cap_edits = {}
        for f, line, msg, sym, loc in uniq:
            p = pathlib.Path(f)
            if not p.is_file():
                continue
            lines = p.read_text(errors="ignore").split("\n")
            md = DUP.search(msg)
            if md:
                dup_edits.setdefault(str(p), []).append(md.group(1))
                continue
            if CAPCONV.search(msg):
                cap_edits.setdefault(str(p), {})[line - 1] = True
                continue
            conv = CONVERT.search(msg)
            if conv:
                target = conv.group(2).strip()
                if "CAP#" not in target:
                    cast_edits.setdefault(str(p), {})[line - 1] = target
                continue
            if INCONVERTIBLE.search(msg):
                revert_edits.setdefault(str(p), {})[line - 1] = True
                continue
            names = []
            if "non-static type variable" in msg:
                m = NONSTATIC.search(msg)
                if m:
                    names.append(m.group(1))
            elif msg.strip() == "cannot find symbol" and sym and VAR.match(sym):
                target = class_simple_name(loc)
                full = (loc or "").split("<", 1)[0]
                for i, ln in enumerate(lines):
                    m = CLS.match(ln)
                    if m and (m.group(2) in (target, full) or m.group(2).endswith("$" + target)):
                        if not re.search(r"\b" + re.escape(sym) + r"\b", m.group(4) or ""):
                            class_edits.setdefault(str(p), {}).setdefault(i, []).append(sym)
                        break
                continue
            for name in names:
                plan = plan_edit(lines, line, name)
                if plan is None:
                    continue
                kind, idx, nm = plan
                if kind == "class":
                    class_edits.setdefault(str(p), {}).setdefault(idx, []).append(nm)
                else:
                    method_edits.setdefault(str(p), {}).setdefault(idx, []).append(nm)

        applied = 0
        for f, classes in class_edits.items():
            p = pathlib.Path(f)
            lines = p.read_text(errors="ignore").split("\n")
            local = 0
            for ci in sorted(classes.keys(), reverse=True):
                m = CLS.match(lines[ci])
                if not m:
                    continue
                line, n = add_params(lines[ci], m.group(4), sorted(set(classes[ci])))
                if n:
                    lines[ci] = line
                    local += n
            if local and not args.dry_run:
                p.write_text("\n".join(lines))
            applied += local

        for f, methods in method_edits.items():
            p = pathlib.Path(f)
            lines = p.read_text(errors="ignore").split("\n")
            local = 0
            for mi in sorted(methods.keys(), reverse=True):
                m = METHOD.match(lines[mi])
                if not m:
                    continue
                names = sorted(set(methods[mi]))
                lines[mi] = m.group(1) + m.group(2) + \
                    "".join("<" + n + "> " for n in names) + lines[mi][m.end(2):]
                local += len(names)
            if local and not args.dry_run:
                p.write_text("\n".join(lines))
            applied += local

        cast_applied = 0
        for f, entries in cast_edits.items():
            p = pathlib.Path(f)
            lines = p.read_text(errors="ignore").split("\n")
            local = 0
            for idx in sorted(entries.keys()):
                if not (0 <= idx < len(lines)):
                    continue
                if idx in revert_edits.get(f, {}):
                    continue
                new = try_cast(lines[idx], entries[idx])
                if new and new != lines[idx]:
                    cast_memory.setdefault(f, {})[idx] = (lines[idx], new)
                    lines[idx] = new
                    local += 1
            if local and not args.dry_run:
                p.write_text("\n".join(lines))
            applied += local
            cast_applied += local

        cap_applied = 0
        for f, entries in cap_edits.items():
            p = pathlib.Path(f)
            lines = p.read_text(errors="ignore").split("\n")
            local = 0
            for idx in sorted(entries.keys()):
                if not (0 <= idx < len(lines)):
                    continue
                new = cap_fix(lines, idx)
                if new and new != lines[idx]:
                    lines[idx] = new
                    local += 1
            if local and not args.dry_run:
                p.write_text("\n".join(lines))
            applied += local
            cap_applied += local

        revert_applied = 0
        for f, entries in revert_edits.items():
            p = pathlib.Path(f)
            lines = p.read_text(errors="ignore").split("\n")
            local = 0
            for idx in sorted(entries.keys(), reverse=True):
                mem = cast_memory.get(f, {}).pop(idx, None)
                if not mem:
                    continue
                orig, applied_text = mem
                if 0 <= idx < len(lines) and lines[idx] == applied_text:
                    lines[idx] = orig
                    local += 1
            if local and not args.dry_run:
                p.write_text("\n".join(lines))
            applied += local
            revert_applied += local

        dup_applied = 0
        for f, dnames in dup_edits.items():
            p = pathlib.Path(f)
            lines = p.read_text(errors="ignore").split("\n")
            local = 0
            for name in sorted(set(dnames)):
                local += delete_bridge(lines, name)
            if local and not args.dry_run:
                p.write_text("\n".join(lines))
            dup_applied += local
        applied += dup_applied
        print(f"  type-var additions: {applied - dup_applied - cast_applied - cap_applied - revert_applied}, bridge deletions: {dup_applied}, casts: {cast_applied}, caps: {cap_applied}, reverts: {revert_applied}")
        if applied == 0:
            print("no automatic fixes left; remaining errors:")
            for f, line, msg, sym, loc in uniq[:40]:
                print(f"  {f}:{line} {msg} (symbol={sym} loc={loc})")
            return 2

    print("rounds exhausted")
    return 1


if __name__ == "__main__":
    sys.exit(main())
