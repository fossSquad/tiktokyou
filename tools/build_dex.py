#!/usr/bin/env python3
"""Build the rebuilt mod dexes from sources.

  stable.dex   support/stable layer compiled from src/a, src/b, src/c,
               src/org, src/util, src/com/windukk/{stable,hook}, src/com/vapro,
               CommonUtils + the dalvik.system.VMRuntime compile stub
               (the stub is excluded from the dex).
  payload.dex  the bundled payload (Gradle build/classes/java/main) -> d8.

The a/a.class helper is stripped from mod-lib.jar on the fly: it shadows
the package name `a` for javac (same-package class a.b/a.c collisions).

Usage:
  python3 tools/build_dex.py [--out build/mod-dex]
      [--javac <path>] [--d8 <path>] [--android-jar <path>]
      [--host-jar libs/tiktok.jar] [--support-jar libs/mod-support.jar]
      [--payload-classes build/classes/java/main]
      [--stages stable,payload]
"""
import argparse
import pathlib
import shutil
import subprocess
import sys
import zipfile

TOOLS = pathlib.Path(__file__).resolve().parent
PROJECT = TOOLS.parent
sys.path.insert(0, str(TOOLS))
import env  # noqa: E402

SUPPORT_ROOTS = [
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


def default_javac() -> str:
    resolved = env.javac_path()
    return str(resolved) if resolved else "javac"


def run(cmd):
    print("$", " ".join(str(c) for c in list(cmd)[:6]), "..." if len(cmd) > 6 else "")
    r = subprocess.run([str(c) for c in cmd])
    if r.returncode != 0:
        raise SystemExit(f"ERROR: command failed with exit {r.returncode}")


def filtered_support_jar(support_jar: pathlib.Path, dest: pathlib.Path) -> pathlib.Path:
    with zipfile.ZipFile(support_jar) as zin, \
            zipfile.ZipFile(dest, "w", zipfile.ZIP_DEFLATED) as zout:
        removed = 0
        for item in zin.infolist():
            n = item.filename
            if n == "a/a.class" or n.startswith("a/a$"):
                removed += 1
                continue
            zout.writestr(item, zin.read(n))
    print(f"support jar: {support_jar.name} -> {dest.name} (removed {removed} a/a entries)")
    return dest


def run_d8(args, name, inputs, libs, out_dir) -> pathlib.Path:
    tmp = out_dir / f".{name}-d8"
    if tmp.exists():
        shutil.rmtree(tmp)
    tmp.mkdir(parents=True)
    cmd = [args.d8, "--release", "--min-api", "24"]
    for lib in libs:
        cmd += ["--lib", str(lib)]
    cmd += ["--output", str(tmp)] + inputs
    print(f"{name} d8: {len(inputs)} inputs")
    run(cmd)
    target = out_dir / f"{name}.dex"
    shutil.move(str(tmp / "classes.dex"), str(target))
    shutil.rmtree(tmp)
    print(f"built {target} ({target.stat().st_size} bytes)")
    return target


def build_stable(args, lib_jar: pathlib.Path) -> pathlib.Path:
    classes = args.out / "stable-classes"
    if classes.exists():
        shutil.rmtree(classes)
    classes.mkdir(parents=True)

    sources = []
    for root in SUPPORT_ROOTS:
        sources += sorted(str(p) for p in (PROJECT / root).rglob("*.java"))
    cp = [str(args.android_jar), str(args.host_jar), str(lib_jar)]
    print(f"stable javac: {len(sources)} files")
    run([args.javac, "-nowarn", "-encoding", "UTF-8",
         "-source", "21", "-target", "21",
         "-cp", ":".join(cp), "-d", str(classes)] + sources)

    inputs = [str(p) for p in classes.rglob("*.class")
              if "/dalvik/system/" not in str(p)]
    return run_d8(args, "stable", inputs,
                  [str(args.android_jar), str(args.host_jar)], args.out)


def build_payload(args, lib_jar: pathlib.Path) -> pathlib.Path:
    if not args.payload_classes.is_dir():
        raise SystemExit(f"ERROR: payload classes not found: {args.payload_classes} "
                         "(run ./gradlew classes first, or use the buildDex task)")
    # Compile-time stubs like BaseActivity and androidx shells are needed only
    # to satisfy javac. They must NOT be packaged into payload.dex because
    # they shadow host classes and cause NoSuchFieldError / ClassCastException.
    EXCLUDED_PREFIXES = (
        "com/bytedance/ies/foundation/activity/",
        "androidx/",
    )
    inputs = []
    for p in args.payload_classes.rglob("*.class"):
        rel = str(p.relative_to(args.payload_classes))
        if any(rel.startswith(ex) for ex in EXCLUDED_PREFIXES):
            continue
        inputs.append(str(p))
    return run_d8(args, "payload", inputs,
                  [str(args.android_jar), str(args.host_jar), str(lib_jar)], args.out)


def main() -> int:
    ap = argparse.ArgumentParser()
    ap.add_argument("--out", type=pathlib.Path, default=PROJECT / "build" / "mod")
    ap.add_argument("--javac", default=default_javac())
    ap.add_argument("--d8", default=str(env.d8_path() or "d8"))
    ap.add_argument("--android-jar", type=pathlib.Path,
                    default=env.android_jar())
    ap.add_argument("--host-jar", type=pathlib.Path,
                    default=PROJECT / "libs" / "tiktok.jar")
    ap.add_argument("--support-jar", type=pathlib.Path,
                    default=PROJECT / "build" / "lib" / "hook.jar")
    ap.add_argument("--payload-classes", type=pathlib.Path,
                    default=PROJECT / "build" / "classes" / "java" / "main")
    ap.add_argument("--stages", default="stable,payload")
    args = ap.parse_args()

    for p in (args.android_jar, args.host_jar, args.support_jar):
        if p is None or not p.is_file():
            print(f"ERROR: missing {p} "
                  "(set ANDROID_HOME/ANDROID_JAR/JAVA_HOME or pass flags)")
            return 1
    args.out.mkdir(parents=True, exist_ok=True)
    lib_jar = filtered_support_jar(args.support_jar, args.out / "hook.jar")

    stages = set(args.stages.split(","))
    if "stable" in stages:
        build_stable(args, lib_jar)
    if "payload" in stages:
        build_payload(args, lib_jar)
    return 0


if __name__ == "__main__":
    sys.exit(main())
