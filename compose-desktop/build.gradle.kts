plugins {
    kotlin("multiplatform")
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.jetbrainsCompose)
    application
    id("org.jetbrains.compose-hot-reload") version "1.0.0-dev.2"
}

group = "me.joreilly"
version = "1.0-SNAPSHOT"

composeHotReload {
    useJetBrainsRuntime = true
}

kotlin {
    jvm()

    sourceSets.jvmMain.dependencies {
        implementation(compose.desktop.currentOs)
        implementation(libs.coil3.compose)
        implementation(libs.coil3.network.ktor)

        implementation(projects.common)
    }
}


application {
    mainClass.set("MainKt")
}
