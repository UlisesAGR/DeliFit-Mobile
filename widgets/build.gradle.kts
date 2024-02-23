/*
 * build.gradle.kts - Module widgets
 * Created by Ulises Gonzalez on 23/02/24
 * Copyright (c) 2023. All rights reserved.
 */
plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.devtools.ksp)
    alias(libs.plugins.android.kotlin)
    alias(libs.plugins.android.navigation)
}

android {
    namespace = "com.delifit.delifitmobile.widgets"
    compileSdk = 34

    defaultConfig {
        minSdk = 26

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        buildConfig = true
        viewBinding = true
    }
}

dependencies {
    implementation(libs.androidx.core)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.recyclerview)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.splashscreen)

    implementation(libs.com.glide)
    implementation(libs.com.material)

    implementation(libs.bundles.androidx.navigation)

    ksp(libs.com.glide.compiler)

    androidTestImplementation(libs.androidTest.junit.junit)
    androidTestImplementation(libs.androidTest.espresso.core)
}
