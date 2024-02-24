plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.devtools.ksp)
    alias(libs.plugins.android.kotlin)
    alias(libs.plugins.android.navigation)
}

android {
    namespace = "com.delifit.delifitmobile.utils"
    compileSdk = 34

    defaultConfig {
        minSdk = 26

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
            resValue("string", "app_name", "DeliFit")
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

    implementation(libs.org.coroutines)

    implementation(libs.bundles.androidx.lifecycle.libs)
    implementation(libs.bundles.com.retrofit.libs)
    implementation(libs.bundles.androidx.navigation)

    ksp(libs.com.hilt.compiler)
    ksp(libs.com.glide.compiler)

    testImplementation(libs.test.junit.junit)
    testImplementation(libs.test.coroutines)
    testImplementation(libs.test.robolectric.robolectric)
    testImplementation(libs.bundles.test.mockito.libs)
}
