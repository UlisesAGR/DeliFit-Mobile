/*
 * build.gradle.kts - Module app
 * Created by Ulises Gonzalez on 23/02/24
 * Copyright (c) 2023. All rights reserved.
 */
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.devtools.ksp)
    alias(libs.plugins.android.kotlin)
    alias(libs.plugins.android.hilt)
    alias(libs.plugins.android.navigation)
}

android {
    namespace = "com.delifit.delifitmobile"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.delifit.delifitmobile"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "com.delifit.delifitmobile.utils.Runner"
    }

    buildTypes {
        release {
            isDebuggable = false
            // Optimize Code
            isMinifyEnabled = true
            // Optimize Resource
            isShrinkResources = true
            // Optimize Includes
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
            resValue("string", "app_name", "DeliFit")
        }
        debug {
            isDebuggable = true
            resValue("string", "app_name", "DeliFit Debug")
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
        viewBinding = true
    }
}

dependencies {

    implementation(project(":core"))
    implementation(project(":utils"))
    implementation(project(":widgets"))

    implementation(libs.androidx.core)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.recyclerview)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.fragment)
    implementation(libs.androidx.splashscreen)
    implementation(libs.androidx.test.core)

    implementation(libs.com.glide)
    implementation(libs.com.material)
    implementation(libs.com.okhttp3)
    implementation(libs.com.hilt)
    implementation(libs.com.maps)

    implementation(libs.org.coroutines)

    implementation(libs.bundles.androidx.lifecycle.libs)
    implementation(libs.bundles.com.retrofit.libs)
    implementation(libs.bundles.androidx.navigation)

    ksp(libs.com.hilt.compiler)
    ksp(libs.com.glide.compiler)

    testImplementation(libs.test.junit)
    testImplementation(libs.test.coroutines)
    testImplementation(libs.bundles.test.mockito.libs)

    androidTestImplementation(libs.androidTest.junit)
    androidTestImplementation(libs.androidTest.mockito)
    androidTestImplementation(libs.androidTest.coroutines)
    androidTestImplementation(libs.androidTest.hilt)

    androidTestImplementation(libs.bundles.androidTest.espresso.libs)

    debugImplementation(libs.debug.test.fragment)
}
