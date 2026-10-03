#!/usr/bin/env python3
"""Portable environment discovery for the TikTok-You toolchain.

Every external tool is resolved in this order (first hit wins):

  explicit argument -> environment variable -> PATH -> common install dirs

Nothing in this repository hardcodes a developer machine. Override anything
with the documented environment variables or the per-tool CLI flags:

  ANDROID_HOME / ANDROID_SDK_ROOT  Android SDK root
  ANDROID_BUILD_TOOLS              build-tools directory (e.g. .../build-tools/36.0.0)
  ANDROID_JAR                      android.jar (optional; otherwise newest platform)
  JAVA_HOME                        JDK 21 used for javac/java/keytool
  DEX2JAR                          d2j-dex2jar executable (dex-tools release)
  JADX                             jadx executable
"""
from __future__ import annotations

import os
import re
import shutil
from pathlib import Path


def _env(name: str) -> str | None:
    value = os.environ.get(name, "").strip()
    return value or None


def _first_file(*candidates) -> Path | None:
    for cand in candidates:
        if not cand:
            continue
        p = Path(cand).expanduser()
        if p.is_file():
            return p
    return None


def _ver_key(name: str):
    return [int(part) for part in re.findall(r"\d+", name)] or [0]


def _home_globs(*patterns: str):
    for pattern in patterns:
        for p in sorted(Path.home().glob(pattern), reverse=True):
            yield p


def sdk_dir(hint=None) -> Path | None:
    candidates = [
        hint,
        _env("ANDROID_HOME"),
        _env("ANDROID_SDK_ROOT"),
        Path.home() / "Android" / "Sdk",
        Path.home() / "Library" / "Android" / "sdk",
        Path("/opt/android-sdk"),
        Path("/usr/lib/android-sdk"),
        Path("/var/lib/android-sdk"),
    ]
    for cand in candidates:
        if not cand:
            continue
        p = Path(cand).expanduser()
        if p.is_dir():
            return p
    return None


def build_tools_dir(hint=None, sdk=None) -> Path | None:
    for cand in (hint, _env("ANDROID_BUILD_TOOLS")):
        if cand:
            p = Path(cand).expanduser()
            if p.is_dir():
                return p
    root = sdk or sdk_dir()
    if root:
        bt = root / "build-tools"
        if bt.is_dir():
            dirs = [d for d in bt.iterdir() if d.is_dir()]
            if dirs:
                return max(dirs, key=lambda d: _ver_key(d.name))
    zipalign = shutil.which("zipalign")
    if zipalign:
        return Path(zipalign).parent
    return None


def build_tool(name: str, hint=None) -> Path | None:
    directory = build_tools_dir(hint)
    if directory and (directory / name).is_file():
        return directory / name
    found = shutil.which(name)
    return Path(found) if found else None


def android_jar(hint=None, sdk=None) -> Path | None:
    if hint:
        return _first_file(hint)
    env_jar = _env("ANDROID_JAR")
    if env_jar:
        return _first_file(env_jar)
    root = sdk or sdk_dir()
    if root:
        platforms = root / "platforms"
        if platforms.is_dir():
            dirs = [d for d in platforms.iterdir()
                    if d.is_dir() and d.name.startswith("android-")]
            if dirs:
                pick = max(dirs, key=lambda d: _ver_key(d.name))
                jar = pick / "android.jar"
                if jar.is_file():
                    return jar
    return None


def _jdk_candidates():
    yield from _home_globs("Tools/jdk-*", "jdk-*", ".sdkman/candidates/java/*")
    usr_jvm = Path("/usr/lib/jvm")
    if usr_jvm.is_dir():
        yield from sorted(usr_jvm.glob("*"), reverse=True)
    yield from _home_globs("Library/Java/JavaVirtualMachines/*/Contents/Home")
    for base in ("/opt/java", "/opt/jdk"):
        p = Path(base)
        if p.is_dir():
            yield from sorted(p.glob("*"), reverse=True)


def java_home(hint=None) -> Path | None:
    for cand in (hint, _env("JAVA_HOME")):
        if cand:
            p = Path(cand).expanduser()
            if (p / "bin" / "javac").is_file():
                return p
    for base in _jdk_candidates():
        if (base / "bin" / "javac").is_file():
            return base
    java = shutil.which("java")
    if java:
        home = Path(java).resolve().parent.parent
        if (home / "bin" / "javac").is_file():
            return home
    return None


def javac_path(hint=None) -> Path | None:
    if hint:
        return _first_file(hint)
    home = java_home()
    if home:
        return home / "bin" / "javac"
    found = shutil.which("javac")
    return Path(found) if found else None


def java_path(hint=None) -> Path | None:
    if hint:
        return _first_file(hint)
    home = java_home()
    if home:
        return home / "bin" / "java"
    found = shutil.which("java")
    return Path(found) if found else None


def keytool_path(hint=None) -> Path | None:
    if hint:
        return _first_file(hint)
    home = java_home()
    if home:
        return home / "bin" / "keytool"
    found = shutil.which("keytool")
    return Path(found) if found else None


def d8_path(hint=None) -> Path | None:
    if hint:
        return _first_file(hint)
    return build_tool("d8")


def dex2jar_path(hint=None) -> Path | None:
    if hint:
        return _first_file(hint)
    return _first_file(_env("DEX2JAR"),
                       shutil.which("d2j-dex2jar"),
                       shutil.which("d2j-dex2jar.sh"))


def jadx_path(hint=None, project=None) -> Path | None:
    if hint:
        return _first_file(hint)
    found = _first_file(_env("JADX"), shutil.which("jadx"))
    if found:
        return found
    project = Path(project) if project else None
    roots = [r for r in (project, project.parent if project else None) if r]
    for root in roots:
        for p in sorted(root.glob("jadx-*/bin/jadx"), reverse=True):
            if p.is_file():
                return p
    return None


def apktool_jar(hint=None, project=None) -> Path | None:
    if hint:
        return _first_file(hint)
    env_jar = _env("APKTOOL_JAR")
    if env_jar:
        return _first_file(env_jar)
    project = Path(project) if project else Path(__file__).resolve().parent.parent
    local_bin = project / "tools" / "bin" / "apktool.jar"
    if local_bin.is_file():
        return local_bin
    for cand in (project.parent / "apktool_3.0.3.jar", Path.home() / "Downloads" / "apktool_3.0.3.jar"):
        if cand.is_file():
            return cand
    return None

