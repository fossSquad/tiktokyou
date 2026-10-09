# Repository guidance

## Build and verification

- This is a recovered Android mod, not an Android Gradle Plugin app. The single Gradle project uses `java-library` plus Python scripts; `assembleDebug` is not the build entrypoint.
- Use JDK 21 for both Gradle and `JAVA_HOME`. Python support compilation hardcodes Java 21, so `-PjavaToolchain` alone does not change the full pipeline.
- Set `ANDROID_HOME` or `ANDROID_SDK_ROOT`; use `ANDROID_JAR` and `ANDROID_BUILD_TOOLS` to pin SDK files. Python tools do not read `local.properties`, and `supportJar` does not receive Gradle's `-PandroidJar` or `-Pjavac` overrides.
- Python dependencies: `python3 -m pip install -r requirements.txt`. Host generation needs dex2jar (`DEX2JAR`); extraction needs jadx (`JADX`). Vanilla APK patching requires `tools/bin/apktool.jar` specifically.
- Generate the ignored host library from a vanilla APK matching the mod's base version: `./gradlew libGen -Papk=/path/to/vanilla.apk`. The recovered version is TikTok You 4.4 / TikTok 46.8.3; README specifies the arm7+arm8 APK.
- Compile verification: `./gradlew classes`. Full DEX verification: `./gradlew buildDex`, producing `build/mod/stable.dex` and `build/mod/payload.dex`. Both automatically build support and Maven dependencies; `libGen` is not automatic.
- Focused support build: `./gradlew supportJar`. Inspect `build/support-jar/vendored-files.txt`: the script can exclude failing sources and use vendored classes, so task success alone does not prove edited sources compiled.
- DEX-only stage selection: `./gradlew buildDex -Pstages=payload` or `-Pstages=stable`. Both still run Gradle's `classes` dependency; neither verifies the omitted DEX stage.
- No repository test suite, CI, lint, formatter, or separate typecheck configuration exists. `python3 tools/check_balance.py src` is a brace sanity check, not compilation. Always pass `src`: its default path is wrong from this repository root.

## Source and runtime boundaries

- Source paths do not reliably match Java packages. All current files under `src/com/windukk/mod/hooks` (including `download`) declare `package Z;`. Their runtime names are `Z.SettingsHooks`, etc., not `com.windukk.mod.hooks.SettingsHooks`. Check package declarations before changing imports, reflection strings, or file locations.
- Gradle compiles only `src/Z`, `src/com/windukk/mod`, `src/androidx`, and the `BaseActivity.java` stub. Other recovered Java files are not automatically part of the payload; `.kt` files are excluded.
- The support layer is compiled separately by `tools/build_support_jar.py` and `tools/build_dex.py`: `src/{a,b,c,org,util}`, `com/windukk/{stable,hook}`, `com/vapro`, and the host `CommonUtils` package. Check both scripts when changing source membership.
- Runtime starts at the injected `AwemeHostApplication.attachBaseContext` call to `StableBootstrap.start`. Bootstrap loads the dynamic module, then reflectively invokes `com.windukk.mod.Main.start(Application, Context)`. Preserve that reflection contract.
- `src/androidx`, the host `BaseActivity` stub, and `src/dalvik` supply compile-time APIs only. DEX packaging excludes these classes to avoid shadowing device/host classes and causing runtime crashes.
- `src/ni` is recovered shim source, not the active Gradle dependency. Compilation uses Maven libraries relocated into `ni.shikatu.*`; `tools/strip_synthetic.py` makes Kotlin `$default` bridges callable by javac. Runtime shim DEX files come from the reference APK.

## Repository map

- `src/com/windukk/mod/Main.java`: payload entrypoint, application context, initialization order, and feature registration. Begin here when locating a feature's startup path.
- `src/com/windukk/mod/hooks/`: descriptively named feature implementations and separate `$before$N` / `$after$N` callback files. Settings, feed, region, photo, theme, and other hooks live here, but still belong to package `Z`.
- `src/Z/`: remaining obfuscated feature modules, settings models, UI, reflection helpers, logging, and callback classes. It is active payload code, not disposable decompiler output.
- `src/com/windukk/stable/`: bootstrap, dynamic update controls/status, and resource overlay. These run outside the replaceable payload.
- `src/a/`: dynamic module infrastructure. `g.java` manages module selection and state; `i.java` prepends DEX elements; `c.java` validates DEX content; `e.java` describes a selected module; `j.java` holds stable context.
- `src/c/`: update package formats and processing. `b.java` parses manifests; `f.java` processes ZIP payloads and validates hashes. `src/b/a.java` provides hex encoding and case-insensitive comparison.
- `src/util/PkgBridge.java`: typed bridge into short-named `a`, `b`, and `c` packages. It avoids ambiguous package/class references in recovered Java.
- `src/com/windukk/hook/`: Java hook API, native bridge, callback dispatch, and callback priority support. `src/com/vapro/vae/` contains StringFog runtime support.
- `src/com/bytedance`, `src/com/ss`, and `src/com/zhiliaoapp`: recovered host-facing classes. Only explicitly selected stubs/support files compile; the normal host classpath comes from `libs/tiktok.jar`.
- `src/org/`: support annotations and recovered third-party classes. Support JAR packaging explicitly excludes `org/bouncycastle/` and `org/conscrypt/`; do not assume every recovered class ships.
- `src/assets/tty/`: bundled module metadata and assets. Other asset directories hold icons, badges, and banners. `src/res/` contains recovered Android resources; `src/proprietary/` holds non-source artifacts such as `libttmod.so` and the binary manifest.
- `tools/`: actual build/extraction/patch implementation. `env.py` handles Python tool discovery; `gen_lib.py` plus `prepare_host_jar.py` normalize the host classpath. Recovery/rename scripts are maintenance tools, not automatic prerequisites for normal builds.
- `build/lib/`: generated support and shaded compile dependencies. `build/classes/java/main/`: payload class files. `build/mod/`: packaged DEX files. `build/extract/` and `build/patch/`: extraction and APK outputs. Do not treat these as source directories.

## Startup and dynamic module behavior

1. `tools/patch_apk.py` injects `StableBootstrap.start(Application, Context)` after the vanilla application's `attachBaseContext` super call.
2. `StableBootstrap` sets stable context in `a.j`, asks `a.g.m()` for a module, and enables hidden API access.
3. `a.i.a()` modifies the existing application's `BaseDexClassLoader.pathList.dexElements`; it prepends module elements ahead of host elements rather than creating an isolated child loader. The operation is guarded against a second invocation.
4. Bootstrap selects a resource overlay, then loads `com.windukk.mod.Main` through the application's classloader and invokes its static `start` method.
5. `Main.start` sets context, initializes session logging and crash handling, initializes settings, reconciles launcher components, and registers feature hooks.
6. A newly selected module receives a delayed health confirmation after 10 seconds. Bootstrap reports startup failures to the module manager.

- `a.g` can select pending, active, previous, or bundled modules. `force_bundled` requests the bundled version; startup crash tracking can reject an unhealthy active module after three crashes. A rebuilt APK does not guarantee its bundled payload is the module running on an existing installation. Check `TTModBootstrap` logs and `DynamicStatus` when behavior does not match edits.
- The main feature registration block has one outer `catch (Exception)`. An exception from an early registration can skip later registrations; inspect the first setup error, not only the missing feature.
- `Main.verifySignature(Context)` is intentionally a no-op in this recovered tree. Do not infer upstream behavior from this method or restore removed checks as incidental cleanup.

## Code analysis shortcuts and constraints

- For a feature, trace `Main.start` registration, the feature's registration method, its callback class, then the host method/field named by reflection. Filenames and obfuscated method names alone do not reveal runtime behavior.
- Settings entrypoint: `src/Z/ta.java` initializes SharedPreferences `ttmod_settings` and exposes `ua` through `ta.d()`. `src/Z/ua.java` loads defaults, persisted values, migration logic, and setters. Search preference key strings to connect settings UI with hook behavior; short fields such as `b` or `B` are not semantic names.
- Settings UI integration starts in `SettingsHooks.java`. Logging is in `src/Z/h6.java`, with sessions under the app's `files/tiktokyoulogs`; `src/Z/u2.java` implements crash handling. Bootstrap and native hook diagnostics use `TTModBootstrap` and `HookBridge` log tags.
- Unrenamed startup modules include `Z.n`, `Z.i3`, `Z.j2`, `Z.q`, `Z.e6`, and `Z.t`. `docs/restore-map.md` records tentative feature meanings; verify call sites and strings before renaming them.
- Recovered Kotlin code is Java with `@Metadata`, `Intrinsics`, `Result`, `Unit`, synthetic-style bridges, and separately named lambda classes. Follow the existing `ni.shikatu.*` runtime imports; replacing them with upstream `kotlin.*` or `okhttp3.*` changes runtime class identity.
- Review sibling `$` callback files when editing a hook. Quote paths containing `$` in shell commands, for example `'src/com/windukk/mod/hooks/SettingsHooks$before$1.java'`.
- Host reflection targets and class names are APK-version-specific. Regenerating `libs/tiktok.jar` for another host version does not update string-based reflection targets or hook assumptions.
- Java declarations in `HookBridge` connect to the proprietary `ttmod` native library through native methods. Native signatures and callback contracts cannot be changed solely in Java without checking the native counterpart.
- `CallbackDispatcher` treats the first native callback argument as `thisObject` for instance hooks; static hooks use all arguments directly. It runs before callbacks in snapshot order and after callbacks in reverse order. `HookMethodParam.setResult` and `setThrowable` both request an early return, suppressing the original call when used in a before hook.
- `HookBridge` includes distinct constructor handling. Do not treat a `Constructor` as an ordinary `Method` when changing invocation or return handling.
- Useful root-level searches: `rg -n 'ttmod_settings|<preference-key>' src`, `rg -n 'HookBridge|HookMethod|Class\\.forName' src/com/windukk/mod/hooks`, and `rg -n '^package ' src/com/windukk/mod/hooks`. These cover persisted settings, registration targets, and path/package mismatches.

## APK patching and source refresh

- Patch with an explicit matching reference: `./gradlew patch -Papk=/path/to/vanilla.apk -PrefMod=/path/to/TikTok_You.apk`. This builds both DEX files, writes `build/patch/<vanilla-stem>-patched.apk`, aligns, debug-signs, and verifies it. `-PnoSign` skips signing, not alignment.
- Without `-PrefMod`, the patcher uses an already-modded target or searches the parent directory for `TikTok_You-*.apk` by filename order, not modification time. Do not rely on it selecting the correct version.
- Patching overlays reference APK non-DEX entries, then local `src/assets`, non-XML `src/res` files, and `src/proprietary/libttmod.so`. Plain-text resource XML is not compiled or overlaid; editing it alone does not change the patched APK.
- When the reference is arm64-only and the target also has armeabi-v7a libraries, patching removes the target's armeabi-v7a libraries.
- `./gradlew extract -Papk=/path/to/mod.apk` writes a separate tree under `build/extract/<mod-stem>/src`; it does not update checked-in `src` automatically. Review and merge intentionally.
- Read `docs/restore-map.md` before restoration renames, but verify against scripts: parts of this historical document are stale. `extract_tty.py` actually runs `rename_hooks.py --apply` in its post-processing chain, despite its docstring saying otherwise. Review `rename_hooks.py`'s version-specific map and `rename_main.py`'s tables before extracting a new upstream version.
