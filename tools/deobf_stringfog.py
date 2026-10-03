#!/usr/bin/env python3
"""Offline StringFog deobfuscator for the TikTok-You mod sources.

Three layers are handled, in order:

1. Direct calls with literal arguments:
       StringFogRuntime.decrypt("<base64>", "<key>", "aes")
       StringFogRuntime.decrypt("<base64>")          # xor + built-in default key
2. R8-outlined synthetic builders (gd.a, ce.a, s2.a, a.a, b5.a, c5.a): when the
   first three arguments at the call site are literals, the whole call is
   rewritten into the equivalent plain expression.
3. Calls whose arguments are locals or fields with constant literal values.
   Values are resolved from simple assignments; when several candidate values
   exist (branch-assigned locals), all combinations are tried and the call is
   replaced only if every combination decrypts to the same text.
4. Ciphertext pairs assigned in the two arms of an if/else whose only purpose
   is the decrypt call: the call is rewritten to a ternary over the plaintexts
   and the dead branch block is removed.

Anything still dynamic is reported at the end.

Crypto mirrors com.vapro.vae.stringfog:
    AesFog: key = SHA-256(key)[:16]; AES/CBC/PKCS5Padding; IV = first 16 bytes
    XorFog: byte-wise xor with repeating key
    default key (1-arg variant): z9N!kX3pKARnZqh3
"""

import base64
import hashlib
import itertools
import json
import re
import sys
from collections import Counter
from pathlib import Path

from cryptography.hazmat.primitives.ciphers import Cipher, algorithms, modes

DEFAULT_KEY = "z9N!kX3pKARnZqh3"

_JAVA_ESC = {
    "n": "\n",
    "t": "\t",
    "r": "\r",
    "b": "\b",
    "f": "\f",
    '"': '"',
    "'": "'",
    "\\": "\\",
}


def unescape_java(s: str) -> str:
    out = []
    i = 0
    while i < len(s):
        c = s[i]
        if c == "\\" and i + 1 < len(s):
            n = s[i + 1]
            if n in _JAVA_ESC:
                out.append(_JAVA_ESC[n])
                i += 2
                continue
            if n == "u" and i + 5 < len(s):
                out.append(chr(int(s[i + 2 : i + 6], 16)))
                i += 6
                continue
            out.append(n)
            i += 2
            continue
        out.append(c)
        i += 1
    return "".join(out)


def aes_decrypt(data: bytes, key: bytes) -> str:
    k = hashlib.sha256(key).digest()[:16]
    iv, ct = data[:16], data[16:]
    dec = Cipher(algorithms.AES(k), modes.CBC(iv)).decryptor()
    pt = dec.update(ct) + dec.finalize()
    pad = pt[-1] if pt else 0
    if 1 <= pad <= 16 and pt.endswith(bytes([pad]) * pad):
        pt = pt[:-pad]
    return pt.decode("utf-8")


def xor_decrypt(data: bytes, key: bytes) -> str:
    if not key:
        return data.decode("utf-8")
    return bytes(b ^ key[i % len(key)] for i, b in enumerate(data)).decode("utf-8")


_cache: dict[tuple[str, str, str], str] = {}


def decrypt(algo: str, b64: str, key: str) -> str:
    ck = (algo, b64, key)
    if ck not in _cache:
        data = base64.b64decode(b64)
        _cache[ck] = (
            aes_decrypt(data, key.encode()) if algo == "aes" else xor_decrypt(data, key.encode())
        )
    return _cache[ck]


def literal(text: str) -> str:
    return json.dumps(text, ensure_ascii=False)


LITERAL = re.compile(r'"(?:[^"\\]|\\.)*"')
CALL3 = re.compile(
    r'StringFogRuntime\.decrypt\(\s*"((?:[^"\\]|\\.)*)"\s*,\s*"((?:[^"\\]|\\.)*)"\s*,\s*"(aes|xor)"\s*\)'
)
CALL1 = re.compile(r'StringFogRuntime\.decrypt\(\s*"((?:[^"\\]|\\.)*)"\s*\)')
DECRYPT_OPEN = re.compile(r"StringFogRuntime\.decrypt\(")
ASSIGN = re.compile(r"(?<![\w$.])(?:this\.)?([A-Za-z_$][\w$]*)\s*=\s*(?!=)")
METHOD = re.compile(
    r"(?m)^[ \t]*(?!\s*(?:if|for|while|switch|catch|else|do|try|return|throw|new|case|default|synchronized)\b)"
    r"[^\n{}]*\([^\n{}]*\)[^\n{}]*\{[ \t]*$"
)
KEYWORDS = {
    "true", "false", "null", "new", "this", "String", "byte", "int", "long",
    "float", "double", "boolean", "char", "short", "void",
}

# name, argument count, template(rest_args, plaintext_literal) -> replacement
WRAPPERS = (
    ("gd.a", 5, lambda a, p: f"{a[0]}.append({p}).append({a[1]})"),
    ("ce.a", 5, lambda a, p: f"{a[0]}.append({p}).append({a[1]}).toString()"),
    ("s2.a", 4, lambda a, p: f"{a[0]}.append({p}).toString()"),
    ("a.a", 5, lambda a, p: f"{a[0]}.append({p}).append({a[1]}).toString()"),
    ("b5.a", 5, lambda a, p: f"{a[1]}.setTypeface(Typeface.create({p}, {a[0]}))"),
    ("c5.a", 4, lambda a, p: f"{a[0]}.setText(l6.a({p}))"),
)


# --------------------------------------------------------------------------
# text scanning helpers (string/comment aware)


def _skip_string(s: str, i: int) -> int:
    i += 1
    while i < len(s):
        if s[i] == "\\":
            i += 2
            continue
        if s[i] == '"':
            return i + 1
        i += 1
    return i


def _skip_char(s: str, i: int) -> int:
    i += 1
    while i < len(s):
        if s[i] == "\\":
            i += 2
            continue
        if s[i] == "'":
            return i + 1
        i += 1
    return i


def _advance(s: str, i: int):
    """If s[i] starts a string/char/comment, return index past it, else None."""
    c = s[i]
    if c == '"':
        return _skip_string(s, i)
    if c == "'":
        return _skip_char(s, i)
    if c == "/" and i + 1 < len(s):
        if s[i + 1] == "/":
            j = s.find("\n", i)
            return len(s) if j < 0 else j
        if s[i + 1] == "*":
            j = s.find("*/", i)
            return len(s) if j < 0 else j + 2
    return None


def match_pair(s: str, i: int, open_c: str, close_c: str) -> int:
    """Index of the matching close char for s[i] == open_c, or -1."""
    depth = 0
    while i < len(s):
        n = _advance(s, i)
        if n is not None:
            i = n
            continue
        c = s[i]
        if c == open_c:
            depth += 1
        elif c == close_c:
            depth -= 1
            if depth == 0:
                return i
        i += 1
    return -1


def split_args(inner: str) -> list[str]:
    parts = []
    depth = 0
    cur = ""
    i = 0
    while i < len(inner):
        n = _advance(inner, i)
        if n is not None:
            cur += inner[i:n]
            i = n
            continue
        c = inner[i]
        if c in "([{":
            depth += 1
        elif c in ")]}":
            depth -= 1
        if c == "," and depth == 0:
            parts.append(cur.strip())
            cur = ""
        else:
            cur += c
        i += 1
    parts.append(cur.strip())
    return parts


def strip_wrapping(s: str):
    """Remove redundant parentheses and casts; return inner text or None."""
    s = s.strip()
    if s.startswith("("):
        e = match_pair(s, 0, "(", ")")
        if e < 0:
            return None
        if e == len(s) - 1:
            return s[1:e].strip()
        head = s[1:e].strip()
        if re.fullmatch(r"[A-Za-z_$][\w$.\[\]]*", head):
            return s[e + 1 :].strip()
    return None


def read_rhs(text: str, i: int, limit: int = 400) -> str | None:
    """Read a statement right-hand side up to the terminating semicolon."""
    depth = 0
    start = i
    while i < len(text) and i - start < limit:
        n = _advance(text, i)
        if n is not None:
            i = n
            continue
        c = text[i]
        if c in "([{":
            depth += 1
        elif c in ")]}":
            if depth == 0:
                return text[start:i]
            depth -= 1
        elif c == ";" and depth == 0:
            return text[start:i]
        i += 1
    return None


def method_bounds(s: str, idx: int) -> tuple[int, int] | None:
    """Start/end offsets of the enclosing method body for position idx."""
    best = None
    for m in METHOD.finditer(s, 0, idx):
        best = m
    if best is None:
        return None
    brace = s.find("{", best.start(), best.end())
    if brace < 0:
        return None
    end = match_pair(s, brace, "{", "}")
    if end < 0:
        return None
    return brace + 1, end


# --------------------------------------------------------------------------
# constant propagation


def _collect(region: str, name: str, depth: int, seen: set[str], out: list, poisoned: set):
    if name in seen or depth > 4:
        return
    seen = seen | {name}
    for m in ASSIGN.finditer(region):
        if m.group(1) != name:
            continue
        rhs = read_rhs(region, m.end())
        if rhs is None:
            continue
        lits = LITERAL.findall(rhs)
        cleaned = LITERAL.sub(" ", rhs)
        cleaned = re.sub(r"\([A-Za-z_$][\w$.\[\]]*\)", " ", cleaned)
        if re.search(r"[A-Za-z_$][\w$]*\s*\(", cleaned):
            poisoned.add(name)
            continue
        out.extend(lits)
        for mm in re.finditer(r"(?:this\.)?([A-Za-z_$][\w$]*)", cleaned):
            other = mm.group(1)
            if other in KEYWORDS or other == name:
                continue
            j = mm.end()
            while j < len(cleaned) and cleaned[j] in " \t":
                j += 1
            if j < len(cleaned) and cleaned[j] == "(":
                continue
            _collect(region, other, depth + 1, seen, out, poisoned)


def candidates(s: str, idx: int, name: str) -> list[str]:
    """Raw literal values a local/field can hold at position idx (best effort)."""
    bounds = method_bounds(s, idx)
    region = s[bounds[0] : idx] if bounds else s[:idx]
    out: list[str] = []
    poisoned: set[str] = set()
    _collect(region, name, 0, set(), out, poisoned)
    if name in poisoned:
        return []
    if not out:
        out2: list[str] = []
        poisoned2: set[str] = set()
        _collect(s[:idx], name, 0, set(), out2, poisoned2)
        if name not in poisoned2:
            out = out2
    result = []
    for v in out:
        if v not in result:
            result.append(v)
    return result


def arg_candidates(s: str, idx: int, arg: str) -> list[str]:
    """Literal values an argument expression can take ([] = unknown)."""
    text = arg.strip()
    while True:
        if LITERAL.fullmatch(text):
            return [text]
        inner = strip_wrapping(text)
        if inner is None:
            break
        text = inner
    m = re.fullmatch(r"(?:this\.)?([A-Za-z_$][\w$]*)", text)
    if m:
        return candidates(s, idx, m.group(1))
    return []


def arg_literal(s: str, idx: int, arg: str) -> str | None:
    """Unique literal value of an argument expression, or None."""
    vals = arg_candidates(s, idx, arg)
    return vals[0] if len(vals) == 1 else None


# --------------------------------------------------------------------------
# transforms


def transform_direct(src: str, counts: Counter) -> str:
    def r3(m: re.Match) -> str:
        b64, key, algo = unescape_java(m.group(1)), unescape_java(m.group(2)), m.group(3)
        try:
            counts["3arg"] += 1
            return literal(decrypt(algo, b64, key))
        except Exception as e:  # noqa: BLE001
            counts["fail"] += 1
            print(f"FAIL 3arg {algo} {b64[:24]}... {e}", file=sys.stderr)
            return m.group(0)

    src = CALL3.sub(r3, src)

    def r1(m: re.Match) -> str:
        b64 = unescape_java(m.group(1))
        try:
            counts["1arg"] += 1
            return literal(decrypt("xor", b64, DEFAULT_KEY))
        except Exception as e:  # noqa: BLE001
            counts["fail"] += 1
            print(f"FAIL 1arg {b64[:24]}... {e}", file=sys.stderr)
            return m.group(0)

    return CALL1.sub(r1, src)


def transform_wrappers(src: str, pkg_a: bool, counts: Counter) -> str:
    for name, nargs, build in WRAPPERS:
        if name == "a.a" and not pkg_a:
            continue
        pattern = re.compile(r"(?<![\w$])" + re.escape(name) + r"\(")
        progress = True
        while progress:
            progress = False
            positions = [m.start() for m in pattern.finditer(src)]
            for start in reversed(positions):
                open_idx = src.index("(", start)
                end = match_pair(src, open_idx, "(", ")")
                if end < 0:
                    continue
                args = split_args(src[open_idx + 1 : end])
                if len(args) != nargs:
                    continue
                lits = [arg_literal(src, start, a) for a in args[:3]]
                if any(x is None for x in lits):
                    continue
                algo = unescape_java(lits[2][1:-1])
                if algo not in ("aes", "xor"):
                    continue
                try:
                    plain = decrypt(
                        algo, unescape_java(lits[0][1:-1]), unescape_java(lits[1][1:-1])
                    )
                except Exception:  # noqa: BLE001
                    continue
                repl = build(args[3:], literal(plain))
                src = src[:start] + repl + src[end + 1 :]
                counts["wrapper"] += 1
                progress = True
                break
    return src


def transform_locals(src: str, counts: Counter, unresolved: list) -> str:
    pos = 0
    while True:
        m = DECRYPT_OPEN.search(src, pos)
        if not m:
            break
        open_idx = src.index("(", m.start())
        end = match_pair(src, open_idx, "(", ")")
        if end < 0:
            break
        args = split_args(src[open_idx + 1 : end])
        if len(args) != 3:
            pos = end + 1
            continue
        sets = [arg_candidates(src, m.start(), a) for a in args]
        if not all(sets):
            unresolved.append((m.start(), args, None))
            pos = end + 1
            continue
        results: list[str | None] = []
        for combo in itertools.product(*sets):
            try:
                res = decrypt(
                    unescape_java(combo[2][1:-1]),
                    unescape_java(combo[0][1:-1]),
                    unescape_java(combo[1][1:-1]),
                )
            except Exception:  # noqa: BLE001
                results.append(None)
                continue
            results.append(res)
        plains = {r for r in results if r is not None}
        if len(plains) == 1 and None not in results:
            out = literal(plains.pop())
            src = src[: m.start()] + out + src[end + 1 :]
            counts["local"] += 1
            pos = m.start() + len(out)
            continue
        unresolved.append((m.start(), args, sorted(plains) if plains else None))
        pos = end + 1
    return src


# --------------------------------------------------------------------------
# branch-pair resolution (if/else-assigned ciphertext locals)


IF_LEAD = re.compile(r"\bif\s*\(")
ELSE_IF_LINE = re.compile(r"^\s*\}\s*else\s+if\s*\(")
ELSE_LINE = re.compile(r"^\s*\}\s*else\s*\{\s*$")


def _line_bounds(src: str, pos: int) -> tuple[int, int]:
    s = src.rfind("\n", 0, pos) + 1
    e = src.find("\n", pos)
    if e < 0:
        e = len(src)
    return s, e


def _brace_delta(line: str) -> int:
    out = 0
    i = 0
    while i < len(line):
        n = _advance(line, i)
        if n is not None:
            i = n
            continue
        if line[i] == "{":
            out += 1
        elif line[i] == "}":
            out -= 1
        i += 1
    return out


def enclosing_chain(src: str, pos: int):
    """Enclosing if-blocks of pos: [(line_start, arm, condition, cond_close_pos)]."""
    entries: list[dict] = []
    pending = None
    depth = 0
    i = 0
    last = src.rfind("\n", 0, pos) + 1
    while i <= last and i < len(src):
        e = src.find("\n", i)
        if e < 0:
            e = len(src)
        line = src[i:e]
        else_if = bool(ELSE_IF_LINE.match(line))
        else_only = bool(ELSE_LINE.match(line))
        plain_if = bool(IF_LEAD.search(line)) and not else_if
        depth += _brace_delta(line)
        if else_if:
            if entries:
                entries[-1]["arm"] = "else"
            m = IF_LEAD.search(line)
            cp = match_pair(src, i + m.end() - 1, "(", ")") if m else -1
            pending = (i, cp)
        elif else_only:
            if entries:
                entries[-1]["arm"] = "else"
        elif plain_if:
            m = IF_LEAD.search(line)
            cp = match_pair(src, i + m.end() - 1, "(", ")") if m else -1
            pending = (i, cp)
        if pending is not None:
            pi, cp = pending
            if 0 <= cp and i <= cp < e and re.fullmatch(r"\s*\{", src[cp + 1 : e]):
                le = src.find("\n", pi)
                if le < 0:
                    le = len(src)
                m2 = IF_LEAD.search(src[pi:le])
                cond = src[pi + m2.end() : cp].strip() if m2 else ""
                entries.append({"line": pi, "arm": "then", "cond": cond, "cp": cp, "depth": depth})
                pending = None
        while entries and depth < entries[-1]["depth"]:
            entries.pop()
        i = e + 1
    return [(en["line"], en["arm"], en["cond"], en["cp"]) for en in entries]


def enclosing_if(src: str, pos: int):
    chain = enclosing_chain(src, pos)
    return chain[-1] if chain else None


def _reaches(a, c) -> bool:
    for (ia, aa, _, _), (ic, ac, _, _) in zip(a, c):
        if ia != ic or aa != ac:
            return False
    return True


def _reachable(src: str, start: int, idx: int, name: str, call_chain):
    """Simple literal assignments of name that can reach idx; None on any non-literal."""
    out = []
    for m in ASSIGN.finditer(src, start, idx):
        if m.group(1) != name:
            continue
        if not _reaches(enclosing_chain(src, m.start()), call_chain):
            continue
        ls = src.rfind("\n", 0, m.start()) + 1
        if re.search(r"\bString\s+$", src[ls : m.start() + len(name)]):
            return None
        rhs = read_rhs(src, m.end())
        if rhs is None:
            return None
        t = rhs.strip()
        if not LITERAL.fullmatch(t):
            return None
        out.append((m.start(), t))
    return out


def branch_pairs(src: str, idx: int, name1: str, name2: str, algo: str):
    """Pair reachable ciphertext assignments of the two vars inside one if/else arm."""
    b = method_bounds(src, idx)
    start = b[0] if b else 0
    call_chain = enclosing_chain(src, idx)
    e1 = _reachable(src, start, idx, name1, call_chain)
    e2 = _reachable(src, start, idx, name2, call_chain)
    if not e1 or not e2:
        return None
    seen = set()
    out = []
    for p1, lit1 in e1:
        c1 = enclosing_chain(src, p1)
        top1 = c1[-1] if c1 else None
        if top1 is None:
            return None
        same_arm = []
        for p2, lit2 in e2:
            c2 = enclosing_chain(src, p2)
            top2 = c2[-1] if c2 else None
            if top2 is not None and top2[0] == top1[0] and top2[1] == top1[1]:
                same_arm.append((p2, lit2))
        if not same_arm:
            return None
        p2, lit2 = min(same_arm, key=lambda pe: abs(pe[0] - p1))
        key = (lit1, lit2)
        if key in seen:
            continue
        seen.add(key)
        try:
            plain = decrypt(algo, unescape_java(lit1[1:-1]), unescape_java(lit2[1:-1]))
        except Exception:  # noqa: BLE001
            return None
        out.append((p1, p2, plain, top1))
    if not 1 <= len(out) <= 3:
        return None
    return out


def if_block_range(src: str, cp: int, line_start: int):
    ob = src.find("{", cp)
    if ob < 0:
        return None
    cb = match_pair(src, ob, "{", "}")
    if cb < 0:
        return None
    end = cb + 1
    j = end
    while j < len(src) and src[j] in " \t":
        j += 1
    if src.startswith("else", j):
        k = src.find("{", j)
        if k >= 0:
            cb2 = match_pair(src, k, "{", "}")
            if cb2 >= 0:
                end = cb2 + 1
    return line_start, end, ob


def _net_braces(text: str) -> int:
    net = 0
    i = 0
    n = len(text)
    while i < n:
        c = text[i]
        if c == "/" and i + 1 < n and text[i + 1] == "/":
            j = text.find("\n", i)
            i = n if j < 0 else j
        elif c == "/" and i + 1 < n and text[i + 1] == "*":
            j = text.find("*/", i + 2)
            i = n if j < 0 else j + 2
        elif c == '"':
            i += 1
            while i < n and text[i] not in ('"', "\n"):
                if text[i] == "\\":
                    i += 1
                i += 1
            i += 1
        elif c == "'":
            i += 1
            while i < n and text[i] not in ("'", "\n"):
                if text[i] == "\\":
                    i += 1
                i += 1
            i += 1
        else:
            if c == "{":
                net += 1
            elif c == "}":
                net -= 1
            i += 1
    return net


def transform_branches(src: str, counts: Counter) -> str:
    orig = src
    before = _net_braces(src)
    plans: list[dict] = []
    owned: set = set()
    owned_calls: set = set()
    for m in reversed(list(DECRYPT_OPEN.finditer(src))):
        oi = src.index("(", m.start())
        end = match_pair(src, oi, "(", ")")
        if end < 0:
            continue
        args = split_args(src[oi + 1 : end])
        if len(args) != 3:
            continue
        a0, a1, a2 = (a.strip() for a in args)
        if not LITERAL.fullmatch(a2):
            continue
        algo = unescape_java(a2[1:-1])
        if algo not in ("aes", "xor"):
            continue
        n1 = re.fullmatch(r"(?:this\.)?([A-Za-z_$][\w$]*)", a0)
        n2 = re.fullmatch(r"(?:this\.)?([A-Za-z_$][\w$]*)", a1)
        if not n1 or not n2:
            continue
        pairs = branch_pairs(src, m.start(), n1.group(1), n2.group(1), algo)
        if not pairs:
            continue
        plist = [(plain, p1, p2) for p1, p2, plain, _info in pairs]
        cond = pairs[0][3][2]
        if len(pairs) == 1:
            repl = literal(pairs[0][2])
        else:
            if len({pr[3][0] for pr in pairs}) != 1:
                continue
            arms: dict[str, tuple[str, int, int]] = {}
            conflict = False
            for p1, p2, plain, info in pairs:
                if info[1] in arms:
                    conflict = True
                    break
                arms[info[1]] = (plain, p1, p2)
            if conflict or set(arms) != {"then", "else"}:
                continue
            pt = arms["then"][0]
            pe = arms["else"][0]
            repl = literal(pt) if pt == pe else f"({cond} ? {literal(pt)} : {literal(pe)})"
        alines = set()
        for _plain, p1, p2 in plist:
            alines.add(_line_bounds(src, p1))
            alines.add(_line_bounds(src, p2))
        owned |= alines
        owned_calls.add(_line_bounds(src, m.start()))
        plans.append(
            {
                "start": m.start(),
                "end": end + 1,
                "repl": repl,
                "alines": alines,
                "call_line": _line_bounds(src, m.start()),
                "names": (n1.group(1), n2.group(1)),
                "top": pairs[0][3],
                "cond": cond,
            }
        )

    edits: list[tuple[int, int, str]] = []
    for plan in plans:
        edits.append((plan["start"], plan["end"], plan["repl"]))
        counts["branch"] += 1
        body = method_bounds(src, plan["start"])
        mstart, mend = body if body else (0, len(src))
        ok = True
        addl: set = set()
        for name in plan["names"]:
            decl = re.compile(
                r"^\s*(?:(?:private|public|protected|final|static|volatile|transient)\s+)*String\s+"
                + re.escape(name)
                + r"\s*(?:=[^;]*)?;\s*$"
            )
            asgn = re.compile(
                r"^\s*(?:final\s+)?" + re.escape(name) + r"\s*=(?!=)[^;]*;\s*$"
            )
            for om in re.finditer(
                r"(?<![\w$.])" + re.escape(name) + r"(?![\w$])", src[mstart:mend]
            ):
                lb = _line_bounds(src, mstart + om.start())
                line = src[lb[0] : lb[1]]
                if lb in owned or lb in owned_calls or decl.match(line):
                    continue
                if asgn.match(line):
                    addl.add(lb)
                    continue
                ok = False
                break
            if not ok:
                break
        if not ok:
            continue
        top = plan["top"]
        block = if_block_range(src, top[3], top[0])
        if block:
            bs, be, ob = block
            cond_names = set(re.findall(r"[A-Za-z_$][\w$]*", plan["cond"])) - KEYWORDS
            reassigned = any(
                re.search(r"(?<![\w$.])" + re.escape(nm) + r"\s*=(?!=)", src[bs:be])
                for nm in cond_names
            )
            if not (bs <= plan["start"] < be) and not reassigned:
                lines_in = []
                i2 = src.find("\n", ob) + 1
                while i2 < be:
                    e2 = src.find("\n", i2)
                    if e2 < 0 or e2 >= be:
                        e2 = be
                    lines_in.append((i2, e2))
                    i2 = e2 + 1
                covered = True
                for l2 in lines_in:
                    if l2 in plan["alines"] or l2 in addl:
                        continue
                    t2 = src[l2[0] : l2[1]].strip()
                    if t2 in ("", "}", "{") or t2.startswith("else") or t2.startswith("} else"):
                        continue
                    covered = False
                    break
                if covered:
                    edits.append((bs, be + 1, ""))
                    edits = [
                        ed
                        for ed in edits
                        if not (ed[2] == "" and bs <= ed[0] and ed[1] <= be)
                    ]
                    continue
        for lb in plan["alines"] | addl:
            edits.append((lb[0], lb[1] + 1, ""))

    applied: list[tuple[int, int, str]] = []
    for s, e, t in sorted(edits, key=lambda x: -x[0]):
        if any(a <= s and e <= b for a, b, _ in applied):
            continue
        src = src[:s] + t + src[e:]
        applied.append((s, e, t))
    if _net_braces(src) != before:
        print("WARN: branch transform changed brace balance; file left unchanged")
        return orig
    return src


# --------------------------------------------------------------------------


def process(p: Path) -> tuple[Counter, list]:
    src = p.read_text(encoding="utf-8")
    orig = src
    counts: Counter = Counter()
    src = transform_direct(src, counts)
    pkg_a = src.lstrip().startswith("package a;")
    src = transform_wrappers(src, pkg_a, counts)
    unresolved: list = []
    src = transform_locals(src, counts, unresolved)
    src = transform_branches(src, counts)
    if src != orig:
        p.write_text(src, encoding="utf-8")
    leftovers = []
    for m in DECRYPT_OPEN.finditer(src):
        oi = src.index("(", m.start())
        end = match_pair(src, oi, "(", ")")
        if end < 0:
            continue
        args = split_args(src[oi + 1 : end])
        line = src.count("\n", 0, m.start()) + 1
        shape = "".join("L" if LITERAL.fullmatch(a.strip()) else "V" for a in args)
        leftovers.append((p, line, shape))
    return counts, leftovers


def main() -> None:
    root = Path(sys.argv[1] if len(sys.argv) > 1 else "tty-src/src")
    total: Counter = Counter()
    files = 0
    leftovers: list = []
    for p in sorted(root.rglob("*.java")):
        counts, un = process(p)
        if any(counts.values()):
            files += 1
        total += counts
        leftovers.extend(un)
    print(
        f"files touched: {files}; replacements: 3arg={total['3arg']} 1arg={total['1arg']} "
        f"wrapper={total['wrapper']} local={total['local']} branch={total['branch']} "
        f"failed={total['fail']}"
    )
    if leftovers:
        print(f"remaining dynamic calls: {len(leftovers)}")
        for p, line, shape in leftovers[:60]:
            print(f"  {p}:{line} {shape}")


if __name__ == "__main__":
    main()
