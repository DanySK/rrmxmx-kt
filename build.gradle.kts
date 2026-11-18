@file:OptIn(ExperimentalKotlinGradlePluginApi::class, ExperimentalWasmDsl::class)

import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.dokka)
    alias(libs.plugins.gitSemVer)
    alias(libs.plugins.kotlin.qa)
    alias(libs.plugins.npm.publish)
    alias(libs.plugins.publishOnCentral)
    alias(libs.plugins.taskTree)
}

group = "org.danilopianini"

repositories {
    google()
    mavenCentral()
}

kotlin {

    compilerOptions {
        allWarningsAsErrors = true
        freeCompilerArgs.add("-Xexpect-actual-classes")
    }

    jvm {
        testRuns["test"].executionTask.configure {
            useJUnitPlatform()
        }
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_1_8)
        }
    }

    sourceSets {
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }

    js(IR) {
        browser()
        nodejs()
        binaries.library()
    }

    wasmJs {
        browser()
        nodejs()
        d8()
        binaries.library()
    }

    wasmWasi {
        nodejs()
        binaries.library()
    }

    val nativeSetup: KotlinNativeTarget.() -> Unit = {
        binaries {
            // uncomment these lines to produce native executables. Not needed for a pure Kotlin library.
//            sharedLib()
//            staticLib()
        }
    }

    applyDefaultHierarchyTemplate()
    /*
     * Linux 64
     */
    linuxX64(nativeSetup)
    linuxArm64(nativeSetup)
    /*
     * Win 64
     */
    mingwX64(nativeSetup)
    /*
     * Android Native
     */
    androidNativeArm32(nativeSetup)
    androidNativeArm64(nativeSetup)
    androidNativeX86(nativeSetup)
    androidNativeX64(nativeSetup)
    /*
     * Apple OSs
     */
    macosArm64(nativeSetup)
    iosArm64(nativeSetup)
    iosSimulatorArm64(nativeSetup)
    tvosArm64(nativeSetup)
    tvosSimulatorArm64(nativeSetup)
    watchosArm32(nativeSetup)
    watchosArm64(nativeSetup)
    watchosSimulatorArm64(nativeSetup)
    watchosDeviceArm64(nativeSetup)
    // Shared configuration
    targets.all {
        compilations.all {
            compileTaskProvider.configure {
                compilerOptions {
                    allWarningsAsErrors = true
                    freeCompilerArgs.add("-Xexpect-actual-classes")
                }
            }
        }
    }
}

signing {
    if (System.getenv("CI") == "true") {
        useInMemoryPgpKeys(
            providers.gradleProperty("signingKey").orNull,
            providers.gradleProperty("signingPassword").orNull,
        )
    }
}

publishOnCentral {
    repoOwner = "DanySK"
    projectLongName.set("rrmxmx for Kotlin-MP")
    projectDescription.set("A Kotlin implementation of the rrmxmx hash function")
    repository("https://maven.pkg.github.com/danysk/${rootProject.name}".lowercase()) {
        user.set("DanySK")
        password.set(System.getenv("GITHUB_TOKEN"))
    }
    publishing {
        publications {
            withType<MavenPublication> {
                pom {
                    developers {
                        developer {
                            name.set("Danilo Pianini")
                            email.set("danilo.pianini@gmail.com")
                            url.set("http://www.danilopianini.org/")
                        }
                    }
                }
            }
        }
    }
}

npmPublish {
    registries {
        register("npmjs") {
            uri.set("https://registry.npmjs.org")
            val npmToken = providers.gradleProperty("npmToken")
            authToken.set(npmToken)
            dry.set(npmToken.map { it.isBlank() }.orElse(true))
        }
    }
}
