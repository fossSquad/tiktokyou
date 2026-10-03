#!/usr/bin/env python3
"""Build build/lib/hook.jar from sources, vendoring what still fails.

Pass 1 compiles the whole support source tree against android.jar +
libs/tiktok.jar + the current vendored mod-support.jar + compile stubs.
Pass 2 re-compiles without the files that failed (their classes come from the
vendored jar), producing a clean class set. The final jar is source classes
first, then the residue copied from the vendored jar. A report of the vendored
files is written to build/support-jar/vendored-files.txt.

Usage:
  python3 tools/build_support_jar.py [--out build/lib/mod-lib.jar]
      [--vendored <previous jar or build/support-jar/vendored-mod-support.jar>]
"""
import argparse
import pathlib
import re
import shutil
import subprocess
import sys
import zipfile

TOOLS = pathlib.Path(__file__).resolve().parent
PROJECT = TOOLS.parent
sys.path.insert(0, str(TOOLS))
import env  # noqa: E402

ROOTS = [
    "src/a", "src/b", "src/c", "src/org", "src/util",
    "src/com/windukk/stable", "src/com/windukk/hook", "src/com/vapro",
    "src/com/ss/android/ugc/aweme/utils",
]
STUBS = "tools/ni-stubs"
EXCLUDE_PREFIXES = ("dalvik/", "androidx/startup/", "org/bouncycastle/",
                    "org/conscrypt/")
ERR = re.compile(r"^(.*\.java):\d+: error:")


def run_javac(javac, cp, out, files):
    out.mkdir(parents=True, exist_ok=True)
    cmd = [javac, "-nowarn", "-encoding", "UTF-8", "-Xmaxerrs", "100000",
           "--release", "21", "-cp", cp, "-d", str(out)] + files
    proc = subprocess.run(cmd, capture_output=True, text=True)
    return proc.returncode, proc.stderr


def parse_error_files(stderr):
    files = set()
    for ln in stderr.splitlines():
        m = ERR.match(ln.strip())
        if m:
            files.add(str(pathlib.Path(m.group(1)).resolve()))
    return files


def all_sources():
    files = []
    for root in ROOTS:
        files += sorted(str(p) for p in (PROJECT / root).rglob("*.java"))
    return files


def main() -> int:
    ap = argparse.ArgumentParser(description=__doc__)
    ap.add_argument("--out", type=pathlib.Path,
                    default=PROJECT / "build" / "lib" / "hook.jar")
    ap.add_argument("--vendored", type=pathlib.Path, default=None,
                    help="Legacy vendored jar (fallback for classes that still fail to compile)")
    ap.add_argument("--ni-shikatu-jar", type=pathlib.Path,
                    default=PROJECT / "build" / "lib" / "ni-shikatu-shaded-patched.jar")
    ap.add_argument("--hiddenapibypass-jar", type=pathlib.Path,
                    default=PROJECT / "build" / "lib" / "hiddenapibypass-classes.jar")
    args = ap.parse_args()

    javac = env.javac_path()
    if not javac:
        print("ERROR: javac not found (set JAVA_HOME)")
        return 1
    android_jar = env.android_jar()
    host_jar = PROJECT / "libs" / "tiktok.jar"
    work = PROJECT / "build" / "support-jar"
    work.mkdir(parents=True, exist_ok=True)

    # Maven jars provide ni.shikatu.* and org.lsposed.*
    maven_jars = [args.ni_shikatu_jar, args.hiddenapibypass_jar]
    for p in [android_jar, host_jar] + maven_jars:
        if not p or not pathlib.Path(p).is_file():
            print(f"ERROR: missing {p}")
            return 1

    # Legacy vendored jar fallback (used only if classes still fail)
    vendored_src = args.vendored
    if vendored_src is None:
        committed = PROJECT / "src" / "proprietary" / "hook.jar"
        if committed.is_file():
            vendored_src = committed
    use_vendored = vendored_src is not None and pathlib.Path(vendored_src).is_file()
    print(f"vendored base: {vendored_src if use_vendored else '(none - Maven only)'}")

    # Build classpath: android + host + Maven shaded jars
    cp_parts = [str(android_jar), str(host_jar)] + [str(j) for j in maven_jars]

    # If legacy vendored jar exists, merge it (minus a/a entries) for classpath
    if use_vendored:
        cp_jar = work / "hook-cp.jar"
        with zipfile.ZipFile(vendored_src) as zin, \
                zipfile.ZipFile(cp_jar, "w", zipfile.ZIP_DEFLATED) as zout:
            for item in zin.infolist():
                n = item.filename
                if n == "a/a.class" or n.startswith("a/a$"):
                    continue
                # Skip ni.shikatu.* and org.lsposed.* - Maven provides them now
                if (n.startswith("ni/shikatu/") or
                        n.startswith("org/lsposed/")):
                    continue
                zout.writestr(item, zin.read(n))
        cp_parts.append(str(cp_jar))

    cp = ":".join(cp_parts)
    sources = all_sources()
    excluded = set()
    classes_out = work / "classes"
    if classes_out.exists():
        shutil.rmtree(classes_out)
    for attempt in range(40):
        rc, err = run_javac(javac, cp, classes_out, sources)
        if rc == 0:
            break
        bad = parse_error_files(err)
        if not bad:
            print("ERROR: javac failed without parsable file errors")
            print(err[:4000])
            return 1
        before = len(sources)
        excluded |= bad
        sources = [f for f in sources
                   if str(pathlib.Path(f).resolve()) not in excluded]
        print(f"pass {attempt + 1}: excluded {before - len(sources)} files "
              f"({len(excluded)} total)")
        if len(sources) == before:
            print("ERROR: no progress excluding files")
            return 1
    else:
        print("ERROR: still failing after 40 exclusion passes")
        return 1

    out_jar = args.out
    out_jar.parent.mkdir(parents=True, exist_ok=True)
    seen = set()
    source_count = 0
    with zipfile.ZipFile(out_jar, "w", zipfile.ZIP_DEFLATED) as zout:
        for p in sorted(classes_out.rglob("*.class")):
            rel = p.relative_to(classes_out).as_posix()
            if rel.startswith(EXCLUDE_PREFIXES):
                continue
            zout.write(p, rel)
            seen.add(rel)
            source_count += 1
        residue = 0
        if use_vendored:
            with zipfile.ZipFile(vendored_src) as zin:
                for item in zin.infolist():
                    rel = item.filename
                    if (not rel.endswith(".class") or rel in seen
                            or rel.startswith(EXCLUDE_PREFIXES)
                            or rel == "a/a.class" or rel.startswith("a/a$")
                            or rel.startswith("ni/shikatu/")
                            or rel.startswith("org/lsposed/")):
                        continue
                    zout.writestr(item, zin.read(rel))
                    seen.add(rel)
                    residue += 1
    report = work / "vendored-files.txt"
    report.write_text("\n".join(sorted(excluded)) + "\n")
    print(f"jar: {out_jar}")
    print(f"source classes: {source_count}, vendored residue classes: {residue}")
    print(f"vendored source files ({len(excluded)}): see {report}")
    return 0


if __name__ == "__main__":
    sys.exit(main())
