#!/usr/bin/env python3
"""Strip ACC_SYNTHETIC from Kotlin $default bridge methods in a shaded jar.

Kotlin compilers mark `$default` overload methods with ACC_SYNTHETIC (0x1000),
which causes javac to refuse calling them from Java source. R8/D8 strips the
flag when processing; this script replicates that so javac can call them.

Usage:
  python3 tools/strip_synthetic.py --in build/lib/ni-shikatu-shaded.jar \
                                   --out build/lib/ni-shikatu-shaded-patched.jar
"""
import argparse
import io
import pathlib
import struct
import zipfile

ACC_SYNTHETIC = 0x1000


def _read_u2(data: bytes, offset: int) -> int:
    return struct.unpack_from(">H", data, offset)[0]


def _write_u2(data: bytearray, offset: int, value: int) -> None:
    struct.pack_into(">H", data, offset, value)


def fix_class(data: bytes) -> tuple[bytes, int]:
    """Return (patched_bytes, patch_count).  Removes ACC_SYNTHETIC from every
    method whose name ends with '$default'."""
    buf = bytearray(data)
    off = 0

    # magic u4, minor_version u2, major_version u2
    if len(buf) < 8 or buf[0:4] != b"\xca\xfe\xba\xbe":
        return data, 0
    off = 8

    # constant pool
    cp_count = _read_u2(buf, off)
    off += 2
    # cp entries index 1..cp_count-1
    cp_strings: dict[int, str] = {}
    cp_idx = 1
    while cp_idx < cp_count:
        tag = buf[off]
        off += 1
        if tag == 1:   # Utf8
            length = _read_u2(buf, off)
            off += 2
            try:
                cp_strings[cp_idx] = buf[off:off + length].decode("utf-8", errors="replace")
            except Exception:
                pass
            off += length
        elif tag in (5, 6):   # Long / Double occupy two slots
            off += 8
            cp_idx += 2
            continue
        elif tag == 7:   # Class
            off += 2
        elif tag == 8:   # String
            off += 2
        elif tag in (9, 10, 11):   # Fieldref, Methodref, InterfaceMethodref
            off += 4
        elif tag == 12:  # NameAndType
            off += 4
        elif tag == 15:  # MethodHandle
            off += 3
        elif tag == 16:  # MethodType
            off += 2
        elif tag == 17:  # Dynamic
            off += 4
        elif tag == 18:  # InvokeDynamic
            off += 4
        elif tag == 19:  # Module
            off += 2
        elif tag == 20:  # Package
            off += 2
        else:
            # Unknown tag – can't parse further; return original
            return data, 0
        cp_idx += 1

    # access_flags u2, this_class u2, super_class u2
    off += 6
    # interfaces
    iface_count = _read_u2(buf, off)
    off += 2 + iface_count * 2
    # fields
    field_count = _read_u2(buf, off)
    off += 2
    for _ in range(field_count):
        off += 6  # access_flags, name_idx, desc_idx
        attr_count = _read_u2(buf, off)
        off += 2
        for _ in range(attr_count):
            off += 2
            attr_len = struct.unpack_from(">I", buf, off)[0]
            off += 4 + attr_len
    # methods
    method_count = _read_u2(buf, off)
    off += 2
    patched = 0
    for _ in range(method_count):
        flags_off = off
        flags = _read_u2(buf, off)
        name_idx = _read_u2(buf, off + 2)
        off += 6  # access_flags, name_idx, desc_idx
        attr_count = _read_u2(buf, off)
        off += 2
        for _ in range(attr_count):
            off += 2
            attr_len = struct.unpack_from(">I", buf, off)[0]
            off += 4 + attr_len
        name = cp_strings.get(name_idx, "")
        if (flags & ACC_SYNTHETIC) and name.endswith("$default"):
            _write_u2(buf, flags_off, flags & ~ACC_SYNTHETIC)
            patched += 1
    return bytes(buf), patched


def process(in_path: pathlib.Path, out_path: pathlib.Path) -> None:
    out_path.parent.mkdir(parents=True, exist_ok=True)
    total_patched = 0
    classes_patched = 0
    with zipfile.ZipFile(in_path, "r") as zin, \
         zipfile.ZipFile(out_path, "w", zipfile.ZIP_DEFLATED) as zout:
        for item in zin.infolist():
            data = zin.read(item.filename)
            if item.filename.endswith(".class"):
                fixed, n = fix_class(data)
                if n:
                    data = fixed
                    total_patched += n
                    classes_patched += 1
            zout.writestr(item, data)
    print(f"strip_synthetic: patched {total_patched} methods in "
          f"{classes_patched} classes -> {out_path}")


def main() -> int:
    ap = argparse.ArgumentParser(description=__doc__)
    ap.add_argument("--in", dest="in_jar", required=True, type=pathlib.Path)
    ap.add_argument("--out", dest="out_jar", required=True, type=pathlib.Path)
    args = ap.parse_args()
    if not args.in_jar.is_file():
        print(f"ERROR: not found: {args.in_jar}")
        return 1
    process(args.in_jar, args.out_jar)
    return 0


if __name__ == "__main__":
    import sys
    sys.exit(main())
