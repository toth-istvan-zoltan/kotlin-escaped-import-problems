/*
 * Copyright © 2020-2024, Simplexion, Hungary and contributors. Use of this source code is governed by the Apache 2.0 license.
 */


plugins {
    alias(libs.plugins.kotlinMultiplatform)
}

repositories {
    mavenCentral()
}

kotlin {
    jvmToolchain(11)

    jvm()

    sourceSets {
        commonMain.dependencies {
            implementation(libs.declaration)
        }
    }
}