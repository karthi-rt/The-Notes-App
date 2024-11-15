// Top-level build file where you can add configuration options common to all sub-projects/modules.

//plugins {
//    alias(libs.plugins.android.application) apply false
//    alias(libs.plugins.kotlin.android) apply false
//}

plugins {
    alias(libs.plugins.android.application) apply false
    id ("com.android.library") version "7.3.1" apply false
    alias(libs.plugins.kotlin.android) apply false
    // alternative for kapt plugin
    // 2.0.0 -> Kotlin version
    id("com.google.devtools.ksp") version "2.0.0-1.0.21" apply false
}

buildscript {
    repositories {
        google()
    }

    dependencies {
        val navVersion = "2.7.5"
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$navVersion")
    }
}
