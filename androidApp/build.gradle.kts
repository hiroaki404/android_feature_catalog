plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "com.inspiration.android_feature_catalog.android"
    compileSdk = 34
    defaultConfig {
        applicationId = "com.inspiration.android_feature_catalog.android"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
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
    implementation(project(":shared"))
    implementation(project(":feature:layout"))
    implementation("androidx.compose.material:material:1.4.3")
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.tooling)
    implementation(libs.compose.preview)
    implementation(libs.compose.foundation)
    implementation(libs.material)
    implementation(libs.activity.compose)
}