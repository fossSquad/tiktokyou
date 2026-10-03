import java.io.File
import java.util.Properties
import org.gradle.api.GradleException

plugins {
    `java-library`
    id("com.gradleup.shadow") version "8.3.6"
}

repositories {
    mavenCentral()
    google()
}

val shadedDeps by configurations.creating
val aarDeps by configurations.creating

// Extract classes.jar from HiddenApiBypass AAR into build/lib/
val extractHiddenApiBypass by tasks.registering(Copy::class) {
    from(aarDeps.map { aar -> zipTree(aar) }) {
        include("classes.jar")
        rename { "hiddenapibypass-classes.jar" }
    }
    into(layout.buildDirectory.dir("lib"))
    mustRunAfter(patchShadedJar)
}

// Produce build/lib/ni-shikatu-shaded.jar (raw, with ACC_SYNTHETIC on $default methods)
// Use a standalone ShadowJar task (not the plugin-managed one) to avoid the
// implicit classes -> compileJava circular dependency that the plugin injects.
val shadeDeps by tasks.registering(com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar::class) {
    configurations = listOf(shadedDeps)
    archiveFileName.set("ni-shikatu-shaded.jar")
    destinationDirectory.set(layout.buildDirectory.dir("lib"))
    relocate("kotlin", "ni.shikatu.kotlin")
    relocate("kotlinx.serialization", "ni.shikatu.kotlinx.serialization")
    relocate("okhttp3", "ni.shikatu.okhttp3")
    relocate("okio", "ni.shikatu.okio")
    // No project sources — only shaded Maven deps
    from(emptyList<Any>())
}

// Strip ACC_SYNTHETIC from Kotlin $default bridge methods so javac can call them
val patchShadedJar by tasks.registering(Exec::class) {
    dependsOn(shadeDeps)
    val shadedJar  = layout.buildDirectory.file("lib/ni-shikatu-shaded.jar")
    val patchedJar = layout.buildDirectory.file("lib/ni-shikatu-shaded-patched.jar")
    inputs.file(shadedJar)
    inputs.file(file("tools/strip_synthetic.py"))
    outputs.file(patchedJar)
    commandLine(
        "python3", file("tools/strip_synthetic.py").absolutePath,
        "--in",  shadedJar.get().asFile.absolutePath,
        "--out", patchedJar.get().asFile.absolutePath,
    )
}

dependencies {
    shadedDeps("com.squareup.okhttp3:okhttp:5.3.0")
    shadedDeps("com.squareup.okio:okio:3.10.2")
    shadedDeps("org.jetbrains.kotlinx:kotlinx-serialization-json:1.8.0")
    shadedDeps("org.jetbrains.kotlin:kotlin-stdlib:2.0.21")
    aarDeps("org.lsposed.hiddenapibypass:hiddenapibypass:6.1@aar")
}

// JDK for source compilation (toolchain). Override with -PjavaToolchain=<n>.
val javaToolchain = (findProperty("javaToolchain") as String?)?.toIntOrNull() ?: 21

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(javaToolchain))
    }
}

sourceSets {
    main {
        java {
            setSrcDirs(listOf("src"))
            exclude("**/*.kt")
            // Mod payload + compile-time stubs only; everything else comes
            // from libs jars (host classes, shim, stable layer).
            include(
                "Z/**",
                "com/windukk/mod/**",
                "androidx/**",
                "com/bytedance/ies/foundation/activity/BaseActivity.java",
            )
        }
    }
}

// --------------------------------------------------------------------------
// Portable toolchain/SDK discovery. No machine-specific paths here.
// Override via environment (ANDROID_HOME, ANDROID_SDK_ROOT,
// ANDROID_BUILD_TOOLS, ANDROID_JAR, JAVA_HOME, DEX2JAR, JADX),
// local.properties (sdk.dir), or Gradle properties (-PandroidJar=,
// -PandroidBuildTools=, -Pjavac=, -Ppython=, -Pjadx=, -Pstages=, -Pmode=,
// -PrefMod=, -Papk=).
// --------------------------------------------------------------------------

fun envVar(name: String): String? = System.getenv(name)?.takeIf { it.isNotBlank() }

fun localProperty(name: String): String? {
    val f = file("local.properties")
    if (!f.isFile) return null
    val props = Properties()
    f.inputStream().use { props.load(it) }
    return props.getProperty(name)?.takeIf { it.isNotBlank() }
}

fun androidSdkDir(): String? {
    localProperty("sdk.dir")?.let { return it }
    val home = System.getProperty("user.home") ?: ""
    return listOfNotNull(
        envVar("ANDROID_HOME"),
        envVar("ANDROID_SDK_ROOT"),
        "$home/Android/Sdk",
        "$home/Library/Android/sdk",
        "/opt/android-sdk",
        "/usr/lib/android-sdk",
        "/var/lib/android-sdk",
    ).firstOrNull { File(it).isDirectory }
}

fun androidJarPath(): String? {
    (findProperty("androidJar") as String?)?.let { return it }
    envVar("ANDROID_JAR")?.let { return it }
    val sdk = androidSdkDir() ?: return null
    val best = File(sdk, "platforms").listFiles()
        ?.filter { it.isDirectory && it.name.startsWith("android-") }
        ?.maxByOrNull { it.name } ?: return null
    val jar = File(best, "android.jar")
    return if (jar.isFile) jar.absolutePath else null
}

fun buildToolsDir(): String? {
    (findProperty("androidBuildTools") as String?)?.let { return it }
    envVar("ANDROID_BUILD_TOOLS")?.let { return it }
    val sdk = androidSdkDir() ?: return null
    return File(sdk, "build-tools").listFiles()
        ?.filter { it.isDirectory }
        ?.maxByOrNull { it.name }
        ?.absolutePath
}

fun requireAndroidJar(): String = androidJarPath() ?: throw GradleException(
    "Android SDK not found: set ANDROID_HOME / ANDROID_SDK_ROOT, add sdk.dir " +
        "to local.properties, or pass -PandroidJar=/path/to/android.jar"
)

dependencies {
    // Android platform APIs (compile-only; the device provides them at runtime).
    compileOnly(files(providers.provider { requireAndroidJar() }))
    // Host classes from a vanilla APK (see the libGen task).
    compileOnly(files("libs/tiktok.jar"))
    // Maven-shaded ni.shikatu.* libraries (patched: ACC_SYNTHETIC stripped).
    compileOnly(files(layout.buildDirectory.file("lib/ni-shikatu-shaded-patched.jar")))
    // HiddenApiBypass from LSPosed AAR.
    compileOnly(files(layout.buildDirectory.file("lib/hiddenapibypass-classes.jar")))
    // Mod-owned support classes compiled by the supportJar task.
    compileOnly(files(layout.buildDirectory.file("lib/hook.jar")))
    compileOnly(files(layout.buildDirectory.file("lib/hook.jar")))
}

tasks.withType<JavaCompile>().configureEach {
    options.isIncremental = false
    options.encoding = "UTF-8"
    options.compilerArgs.addAll(listOf("-nowarn", "-Xlint:none", "-Xmaxerrs", "10000"))
}

// --------------------------------------------------------------------------
// Pipeline tasks. APK argument: ./gradlew <task> <file>.apk (or -Papk=<file>).
// --------------------------------------------------------------------------

val pythonExe: String = (findProperty("python") as String?) ?: "python3"

fun toolScript(name: String): String = file("tools/$name").absolutePath

fun apkArgument(): String? =
    (findProperty("apk") as String?)
        ?: gradle.startParameter.taskNames.firstOrNull {
            it.endsWith(".apk", ignoreCase = true)
        }

fun requireApk(): File {
    val name = apkArgument() ?: throw GradleException(
        "Pass the APK as an argument (e.g. ./gradlew patch TikTok-4.4.apk) " +
            "or -Papk=<file>"
    )
    val f = file(name)
    if (!f.isFile) throw GradleException("APK not found: ${f.absolutePath}")
    return f
}

tasks.addRule(
    "Pattern: <file>.apk - APK argument for extract / libGen / patch",
    object : Action<String> {
        override fun execute(taskName: String) {
            if (taskName.endsWith(".apk", ignoreCase = true)) {
                tasks.register(taskName) {
                    group = "tiktokyou"
                    description = "APK argument placeholder consumed by extract/libGen/patch"
                }
            }
        }
    }
)

tasks.register<Exec>("extract") {
    group = "tiktokyou"
    description = "Extract + normalize mod sources from an APK (./gradlew extract mod.apk)"
    workingDir = project.projectDir
    doFirst {
        val apk = requireApk()
        val outDir = (findProperty("out") as String?)?.let { file(it) }
            ?: layout.buildDirectory.dir("extract/${apk.nameWithoutExtension}").get().asFile
        val args = mutableListOf(
            pythonExe, toolScript("extract_tty.py"),
            "--apk", apk.absolutePath,
            "--out", outDir.absolutePath,
        )
        (findProperty("jadx") as String?)?.let { args += listOf("--jadx", it) }
        (findProperty("stages") as String?)?.let { args += listOf("--stages", it) }
        if (project.hasProperty("keepGoing")) args += "--keep-going"
        commandLine(args)
    }
}

tasks.register<Exec>("libGen") {
    group = "tiktokyou"
    description = "Generate libs/tiktok.jar from a vanilla TikTok APK " +
        "(./gradlew libGen TikTok.apk)"
    workingDir = project.projectDir
    doFirst {
        val apk = requireApk()
        val args = mutableListOf(
            pythonExe, toolScript("gen_lib.py"), apk.absolutePath,
            "--out", file("libs/tiktok.jar").absolutePath,
        )
        (findProperty("dex2jar") as String?)?.let { args += listOf("--dex2jar", it) }
        commandLine(args)
    }
}

tasks.register<Exec>("supportJar") {
    group = "tiktokyou"
    description = "Build build/lib/hook.jar from sources (vendored residue for failing files)"
    dependsOn("patchShadedJar", "extractHiddenApiBypass")
    workingDir = project.projectDir
    inputs.files(fileTree("src") {
        include("a/**", "b/**", "c/**", "org/**", "util/**", "ni/**",
            "com/windukk/stable/**", "com/windukk/hook/**", "com/vapro/**",
            "com/ss/android/ugc/aweme/utils/**")
    })
    inputs.file(toolScript("build_support_jar.py"))
    outputs.file(layout.buildDirectory.file("lib/hook.jar"))
    val niJar  = layout.buildDirectory.file("lib/ni-shikatu-shaded-patched.jar")
    val hapJar = layout.buildDirectory.file("lib/hiddenapibypass-classes.jar")
    val args = mutableListOf(
        pythonExe, toolScript("build_support_jar.py"),
        "--out", layout.buildDirectory.file("lib/hook.jar").get().asFile.absolutePath,
        "--ni-shikatu-jar", niJar.get().asFile.absolutePath,
        "--hiddenapibypass-jar", hapJar.get().asFile.absolutePath,
    )
    (findProperty("vendored") as String?)?.let { args += listOf("--vendored", it) }
    commandLine(args)
}

tasks.named<JavaCompile>("compileJava") {
    dependsOn("supportJar", "patchShadedJar", "extractHiddenApiBypass")
}

tasks.register<Exec>("buildDex") {
    group = "tiktokyou"
    description = "Compile support + payload sources into build/mod/*.dex"
    dependsOn(tasks.named("classes"))
    workingDir = project.projectDir
    val niJar  = layout.buildDirectory.file("lib/ni-shikatu-shaded-patched.jar")
    val hapJar = layout.buildDirectory.file("lib/hiddenapibypass-classes.jar")
    val args = mutableListOf(
        pythonExe, toolScript("build_dex.py"),
        "--out", layout.buildDirectory.dir("mod").get().asFile.absolutePath,
        "--ni-shikatu-jar", niJar.get().asFile.absolutePath,
        "--hiddenapibypass-jar", hapJar.get().asFile.absolutePath,
    )
    (findProperty("javac") as String?)?.let { args += listOf("--javac", it) }
    androidJarPath()?.let { args += listOf("--android-jar", it) }
    buildToolsDir()?.let { bt ->
        File(bt, "d8").takeIf { it.isFile }?.let { args += listOf("--d8", it.absolutePath) }
    }
    (findProperty("stages") as String?)?.let { args += listOf("--stages", it) }
    commandLine(args)
}

tasks.register<Exec>("patch") {
    group = "tiktokyou"
    description = "Patch an APK with the rebuilt mod (./gradlew patch TikTok.apk)"
    dependsOn("buildDex")
    workingDir = project.projectDir
    doFirst {
        val apk = requireApk()
        val dexDir = layout.buildDirectory.dir("mod").get().asFile
        val args = mutableListOf(
            pythonExe, toolScript("patch_apk.py"), apk.absolutePath,
            "--stable", dexDir.resolve("stable.dex").absolutePath,
            "--payload", dexDir.resolve("payload.dex").absolutePath,
            "--out", layout.buildDirectory.dir("patch/${apk.nameWithoutExtension}-patched.apk")
                .get().asFile.absolutePath,
        )
        (findProperty("refMod") as String?)?.let { args += listOf("--ref", it) }
        (findProperty("mode") as String?)?.let { args += listOf("--mode", it) }
        buildToolsDir()?.let { args += listOf("--build-tools", it) }
        if (project.hasProperty("noSign")) args += "--no-sign"
        commandLine(args)
    }
}
