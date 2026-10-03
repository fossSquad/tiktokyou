# Restore map — R8 deobfuscation of TikTok You 4.4 (base TikTok 46.8.3)

Records every naming/structure change applied to `tty-src/src` during the R8
restoration pipeline, with the evidence that backs each rename.

Evidence levels used below:

| Level | Meaning |
|-------|---------|
| `metadata` | Kotlin `@Metadata` annotation (`d2` name table) from the shipped dex — authoritative |
| `log` | String literal inside the class (log tag, message) naming the feature |
| `label` | Module label string literal in `Main.start()` immediately before the call |
| `guess` | Behaviour-based inference, not authoritative |

## 1. Anonymous hook-lambda classes

37 `@Metadata`-carrying classes in `Z` are anonymous objects from inline
lambdas (`ni/shikatu/extensions/HookUtilsKt$before|after|replace$N`). Two carry
real outer-class FQNs (`metadata`), the rest were renamed by enclosing class +
lambda kind + instantiation order (`metadata` + position):

`rb→cc$after$1, sb→cc$before$1, tb→cc$after$2, ub→cc$after$3, vb→cc$after$4,
wb→cc$after$5, xb→cc$before$2, yb→cc$before$3, zb→cc$before$4, ac→cc$before$5,
bc→cc$before$6, qb→cc$before$7, bh→ch$init$1, dh→fh$after$1, eh→fh$before$1,
f3→i3$before$1, e3→i3$before$2, d3→i3$before$3, l3→m3$before$1,
j3→m3$after$1, k3→m3$after$2, ug→m3$hookPhotoGalleryTempDir$1, vg→m3$before$2,
wg→m3$before$3, lg→og$after$1, mg→og$before$1, ng→og$before$2, kg→og$before$3,
pg→qg$after$1, uc→wc$after$1, vc→wc$after$2`

(with `cc→PhotoHooks`, `ch→CleanLinkHooks`, `fh→SimpleModeHooks`, `i3→DownloadHooks`,
`m3→DownloadMediaStoreHooks`, `og→SettingsHooks`, `qg→UnlockLimitsHooks`,
`wc→PublishTabHooks` applied afterwards.)

Orphans (zero references, left unchanged): `a6, b6, w5, x5, y5, z5`.

## 2. `com.windukk.mod.Main` members

From `@Metadata` `d2` (`metadata`):

| Obfuscated | Restored |
|------------|----------|
| `a` (field) | `INSTANCE` |
| `b` | `MOD_VERSION` ("v4.4") |
| `c` | `versionCode` (1790876728) |
| `d` | `appContext` |
| `e` | `mainApplication` |
| `a()` | `getApplicationContext()` |
| `a(float)` | `dp(float)` |
| `a(Context)` | `verifySignature(Context)` |

34 files rewritten, 0 leftover `Main.<letter>` references.

## 3. Hook modules moved from `Z` to `com.windukk.mod.hooks`

`Z/` classes were moved to `com.windukk.mod.hooks.*` and renamed. Evidence:
`metadata` where noted, otherwise the module label in `Main.start()` or a unique
log string inside the class.

| Old | New | Evidence |
|-----|-----|----------|
| `ah` | `FrameMetricsLeakHooks` | log: "FrameMetricsLeakHooks init failed" |
| `og` | `SettingsHooks` | log: "ttmod_settings" |
| `wc` | `PublishTabHooks` | log: "PublishTabHooks initialization error" |
| `ch` | `CleanLinkHooks` | metadata FQN |
| `fh` | `SimpleModeHooks` | log: "Simple mode initialization error" |
| `me` | `SignatureFakerHooks` | label: signature_faker |
| `n6` | `MandatoryLoginHooks` | label: mandatory |
| `l1` | `BadgeHooks` | label: badge |
| `o2` | `CommentStickerHooks` | label: comment_sticker |
| `q2` | `ConfigHooks` | label: config |
| `jd` | `RegionHooks` | label: region |
| `a5` | `FeedHooks` | label: feed |
| `kc` | `EdgeSpeedupHooks` | log: "swipe_up_lock_persist" / EdgeSpeedupAssem |
| `xe` | `StoryEngagementHooks` | log: "Story viewer engagement counts initialized" |
| `yd` | `SearchHooks` | label: search |
| `cc` | `PhotoHooks` | label: photo |
| `od` | `SavePhotoHooks` | label: save_photo |
| `be` | `SeekBarHooks` | label: seek_bar |
| `qg` | `UnlockLimitsHooks` | label: unlock_limits |
| `kb` | `OfflineModeHooks` | label: offline_mode |
| `s5` | `FontHooks` | label: font |
| `ig` | `ThemeHooks` | label: theme |
| `l5` | `FlagSecureHooks` | label: flag_secure |
| `y1` | `BrowserHooks` | label: browser |
| `m3` | `DownloadMediaStoreHooks` (`hooks/download`) | metadata FQN |

53 files moved (parents + `$`-children), 103 imports added, 0 leftovers.

Still in `Z` (collide with jadx locals; require the refined classifier pass):

| Old | Planned | Evidence |
|-----|---------|----------|
| `n` | `AntiBurnoutHooks` | label: antiburnout |
| `i3` | `DownloadHooks` | label: download |
| `j2` | `CommentHooks` | label: comment |
| `q` | `AuthHooks` | label: auth |
| `e6` | `InboxHooks` | label: inbox |
| `t` | `AutoStreakHooks` | label: auto_streak |

Other labelled modules still to align: `i.e.` the code above; remaining hook
groups with no label/log evidence yet (`h6` logger, `k6` slot manager,
`j6` slot model, `m6`/`l6` i18n, `u2`, `qe`, `ta`, `pb`, `nb`) are pending
behaviour-based naming (`guess`).

## 4. Vendored shim `ni.shikatu`

`ni.shikatu.*` is not upstream Kotlin/OkHttp — it is the mod's own repackaged
shim, shipped as `classes52.dex` in the APK. Extracted with jadx and imported
into `tty-src/src/ni`:

- 1278 java files: `kotlin/`, `kotlinx/`, `okhttp3/`, `okio/`, `RuntimeRegistered.java`
- 0 unbalanced files after import
- No StringFog ciphertext in the shim

## 5. Pipeline tooling

| Tool | Purpose |
|------|---------|
| `tty-src/tools/deobf_stringfog.py` | StringFog string decryption (direct, wrapper, local-constant, branch-pair) |
| `tty-src/tools/rename_anon.py` | Anonymous hook-lambda class renames |
| `tty-src/tools/rename_main.py` | `Main` member restore from `@Metadata` |
| `tty-src/tools/rename_hooks.py` | Hook class renames + package moves + import insertion |
| `tty-src/tools/check_balance.py` | Brace-balance sanity scan |

## 6. Backups

| Archive | State |
|---------|-------|
| `/tmp/opencode/tty-src-pre-v2.tgz` | before StringFog wrapper/local phases |
| `/tmp/opencode/tty-src-pre-v3.tgz` | before branch-pair phase |
| `/tmp/opencode/tty-src-pre-v4.tgz` | before final StringFog cleanup |
| `/tmp/opencode/tty-src-deobf-full.tgz` | fully deobfuscated strings, pre-renames |
| `/tmp/opencode/tty-src-pre-hooks.tgz` | before hook class renames/moves |
