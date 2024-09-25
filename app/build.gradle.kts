import java.util.regex.Pattern.compile

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id ("org.jetbrains.kotlin.plugin.serialization") version "1.8.0"
}

android {
    namespace = "com.example.b2b"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.b2b"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
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
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.firebase.inappmessaging)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)


    // Image slideshow library
    implementation("com.github.denzcoskun:ImageSlideshow:0.1.2")

    // Google Material Components library (Updated version)
    implementation("com.google.android.material:material:1.9.0")

    // Glide image loading library
    implementation("com.github.bumptech.glide:glide:4.14.2")
    annotationProcessor("com.github.bumptech.glide:compiler:4.14.2")

    // Supabase for Kotlin
    implementation("io.github.jan-tennert.supabase:postgrest-kt:0.7.6")

    // Ktor for HTTP requests
    implementation("io.ktor:ktor-client-cio:2.3.3")

    // Kotlin serialization JSON library
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.0-RC")
}
