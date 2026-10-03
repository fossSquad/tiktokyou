#!/usr/bin/env python3
"""Prepare the compile-time host jar for javac.

javac rejects several things found in a dex2jar conversion of the TikTok host:

1. Kotlin `$default` / `-impl` bridges carry ACC_SYNTHETIC, which hides them
   from source resolution -> clear the flag.
2. Pre-Java-8 class-file versions with `static` interface methods are rejected
   ("static method found in version 50.0 classfile") -> bump major to 52.
3. Obfuscated host classes whose simple names start with a digit (X.03iH) make
   whole hierarchies unreadable -> rename those simple names to a same-length
   `_`-prefixed form in the entry path AND every constant-pool Utf8 string
   (class names and descriptors), so the jar stays self-consistent.

Only the compile classpath uses this jar; the shipped dex keeps referencing the
real host names.

Usage: python3 tools/prepare_host_jar.py <in.jar> <out.jar>
"""
import re
import struct
import sys
import zipfile

ACC_SYNTHETIC = 0x1000
TOKEN = re.compile(rb"[A-Za-z0-9_$/]+")
ID_FIRST = set("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_$")
ID_REST = set("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_$")


def fix_simple(simple: str) -> str:
    """Fix the leading `$`-segment of a class simple name if needed."""
    parts = simple.split("$")
    first = parts[0]
    fixed = "".join(c if c in ID_REST else "_" for c in first)
    if fixed and fixed[0] not in ID_FIRST:
        fixed = "_" + fixed[1:]
    parts[0] = fixed
    return "$".join(parts)


def skip_constant_pool(data: bytes, off: int, count: int):
    i = 1
    while i < count:
        tag = data[off]
        off += 1
        if tag == 1:
            ln = struct.unpack_from(">H", data, off)[0]
            off += 2 + ln
        elif tag in (3, 4):
            off += 4
        elif tag in (5, 6):
            off += 8
            i += 1
        elif tag in (7, 8, 16, 19, 20):
            off += 2
        elif tag in (9, 10, 11, 12, 17, 18):
            off += 4
        elif tag == 15:
            off += 3
        else:
            raise ValueError(f"unknown constant pool tag {tag}")
        i += 1
    return off


def patch_class(data: bytes, mapping) -> bytes:
    if data[:4] != b"\xca\xfe\xba\xbe":
        raise ValueError("not a class file")
    out = bytearray(data)
    major = struct.unpack_from(">H", data, 6)[0]
    if major < 52:
        struct.pack_into(">H", out, 6, 52)

    off = 8
    cp_count = struct.unpack_from(">H", data, off)[0]
    off += 2

    # Walk the constant pool once, collecting Utf8 payload ranges.
    utf8_spots = []
    i = 1
    while i < cp_count:
        tag = data[off]
        off += 1
        if tag == 1:
            ln = struct.unpack_from(">H", data, off)[0]
            off += 2
            utf8_spots.append((off, ln))
            off += ln
        elif tag in (3, 4):
            off += 4
        elif tag in (5, 6):
            off += 8
            i += 1
        elif tag in (7, 8, 16, 19, 20):
            off += 2
        elif tag in (9, 10, 11, 12, 17, 18):
            off += 4
        elif tag == 15:
            off += 3
        else:
            raise ValueError(f"unknown constant pool tag {tag}")
        i += 1

    if mapping:
        # mapping: full class path (bytes) -> same-length _-prefixed path.
        # Token lookup instead of a 360k-branch alternation: the X package has
        # ~360k digit-named classes, which made the regex approach quadratic.
        def repl(m):
            tok = m.group(0)
            hit = mapping.get(tok)
            if hit is not None:
                return hit
            if tok[:1] == b"L":
                hit = mapping.get(tok[1:])
                if hit is not None:
                    return b"L" + hit
            return tok

        for start, ln in utf8_spots:
            payload = bytes(out[start:start + ln])
            if b"/" not in payload:
                continue
            new = TOKEN.sub(repl, payload)
            if new != payload:
                out[start:start + ln] = new

    # access_flags, this_class, super_class
    off += 6
    interfaces = struct.unpack_from(">H", data, off)[0]
    off += 2 + 2 * interfaces

    for _ in range(2):  # fields then methods
        count = struct.unpack_from(">H", data, off)[0]
        off += 2
        for _ in range(count):
            flags = struct.unpack_from(">H", data, off)[0]
            struct.pack_into(">H", out, off, flags & ~ACC_SYNTHETIC)
            off += 6
            attrs = struct.unpack_from(">H", data, off)[0]
            off += 2
            for _ in range(attrs):
                ln = struct.unpack_from(">I", data, off + 2)[0]
                off += 6 + ln
    return bytes(out)


def main() -> int:
    if len(sys.argv) != 3:
        print(__doc__)
        return 2
    src, dst = sys.argv[1], sys.argv[2]

    with zipfile.ZipFile(src) as zin:
        names = zin.namelist()
        renamed = 0
        mapping = {}
        letters = "_ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz$"
        used = set(names)
        for name in names:
            if not name.endswith(".class"):
                continue
            head, _, tail = name.rpartition("/")
            simple = tail[:-6]
            base = fix_simple(simple)
            if base == simple:
                continue
            prefix = (head + "/") if head else ""
            picked = None
            for ch in letters:
                cand = ch + base[1:]
                if (prefix + cand + ".class") not in used:
                    picked = cand
                    break
            if picked is None:
                continue
            used.add(prefix + picked + ".class")
            mapping[(prefix + simple).encode()] = (prefix + picked).encode()
            renamed += 1

        classes = patched = skipped = 0
        written = set()
        with zipfile.ZipFile(dst, "w", zipfile.ZIP_DEFLATED, compresslevel=1) as zout:
            for name in names:
                data = zin.read(name)
                new_name = name
                if name.endswith(".class"):
                    head, _, tail = name.rpartition("/")
                    simple = tail[:-6]
                    prefix = (head + "/") if head else ""
                    key = (prefix + simple).encode()
                    if key in mapping:
                        new_name = mapping[key].decode() + ".class"
                    try:
                        data = patch_class(data, mapping)
                        patched += 1
                    except Exception as exc:  # keep original bytes, report once
                        if classes < 1:
                            print(f"WARN {name}: {exc}")
                    classes += 1
                if new_name in written:
                    skipped += 1
                    continue
                written.add(new_name)
                zout.writestr(new_name, data)
        print(f"classes: {classes}, patched: {patched}, renamed: {renamed}, "
              f"skipped_dups: {skipped}, out: {dst}")
    return 0


if __name__ == "__main__":
    sys.exit(main())
