import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.10"
    id("org.jetbrains.compose") version "1.1.0"
}

group = "me.dragongod365"
version = "1.0"

repositories {
    google()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

dependencies {
    implementation(compose.desktop.currentOs)
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}

compose.desktop {
    application {
        mainClass = "MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "StopWatchDesktop"
            packageVersion = "1.0.0"
            description = "A simple stopwatch application"
            copyright = "Copyright 2024 NLP"
            vendor = "Arqam Ahmad Siddiqui"

            windows {
                menuGroup = "Stopwatch Applications"
            }
            macOS {
                dockName = "StopwatchApp"
            }
            linux {
                appCategory = "Utility"
            }
        }
    }
}