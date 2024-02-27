/*
 * build.gradle.kts - Module core
 * Created by Ulises Gonzalez on 24/02/24
 * Copyright (c) 2023. All rights reserved.
 */
plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.devtools.ksp)
    alias(libs.plugins.android.kotlin)
    alias(libs.plugins.android.navigation)
}

android {
    namespace = "com.delifit.delifitmobile.core"
    compileSdk = 34

    defaultConfig {
        minSdk = 26

        buildConfigField("String", "BASE_URL", "\"http://demo4853406.mockable.io/\"")
        buildConfigField("String", "ENDPOINT_RECIPES", "\"recipes\"")

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }
    buildTypes {
        release {
            // Optimize Code
            isMinifyEnabled = true
            // Optimize Includes
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
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
    }
}

dependencies {

    implementation(project(":utils"))
    implementation(project(":widgets"))

    implementation(libs.androidx.core)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.recyclerview)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.fragment)
    implementation(libs.androidx.test.core)

    implementation(libs.com.okhttp3)
    implementation(libs.com.hilt)

    implementation(libs.org.coroutines)

    implementation(libs.bundles.androidx.lifecycle.libs)
    implementation(libs.bundles.com.retrofit.libs)

    ksp(libs.com.hilt.compiler)

    testImplementation(libs.test.junit.junit)
    testImplementation(libs.test.coroutines)
    testImplementation(libs.test.robolectric.robolectric)

    testImplementation(libs.bundles.test.mockito.libs)
}
