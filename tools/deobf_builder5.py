#!/usr/bin/env python3
"""Inline the mod's 5-arg StringFog builder calls in support sources.

Shape: a.a.a("<b64>", "<key>", "aes"|"xor", new StringBuilder(), <suffix>)
Semantics: StringBuilder().append(decrypt(b64,key,algo)).append(suffix).toString()
Rewrite: "<plain>" + <suffix>
"""
import base64
import json
import pathlib
import re
import sys

sys.path.insert(0, str(pathlib.Path(__file__).resolve().parent))
import clean_jadx  # noqa: E402
from deobf_stringfog import aes_decrypt, xor_decrypt  # noqa: E402


def _deobf_literal(b64, key, algo):
    data = base64.b64decode(b64)
    kb = key.encode()
    if algo == "xor":
        return xor_decrypt(data, kb)
    return aes_decrypt(data, kb)


CALL = re.compile(
    r'a\.a\.a\(\s*"([A-Za-z0-9+/=]{12,})"\s*,\s*"([^"]+)"\s*,\s*"(aes|xor)"\s*'
    r',\s*new StringBuilder\(\)\s*,\s*([^()]+?)\s*\)'
)


def plain_of(b64: str, key: str, algo: str):
    try:
        return _deobf_literal(b64, key, algo)
    except Exception:
        return None


def main() -> int:
    root = pathlib.Path(sys.argv[1] if len(sys.argv) > 1 else "src")
    total = 0
    failed = 0
    files = 0
    for p in sorted(root.rglob("*.java")):
        s = p.read_text(errors="ignore")
        if "a.a.a(" not in s:
            continue
        in_str, in_cmt = clean_jadx._classify(s)
        out = []
        last = 0
        changed = 0
        for m in CALL.finditer(s):
            if in_str[m.start()] or in_cmt[m.start()]:
                continue
            plain = plain_of(m.group(1), m.group(2), m.group(3))
            if plain is None:
                failed += 1
                continue
            suffix = m.group(4)
            out.append(s[last:m.start()])
            out.append(json.dumps(plain) + " + " + suffix)
            last = m.end()
            changed += 1
        if changed:
            out.append(s[last:])
            p.write_text("".join(out))
            files += 1
            total += changed
    print(f"files: {files}, inlined: {total}, failed: {failed}")
    return 0


if __name__ == "__main__":
    sys.exit(main())
