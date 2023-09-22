plugins {
    `kotlin-dsl`
}
repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    compileOnly(gradleApi())
    implementation(libs.kotlinGradlePlugin)
    implementation(libs.androidGradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidLibrary") {
            id = "android_feature_catalog.android.library"
            implementationClass = "AndroidLibraryPlugin"
        }
        register("androidCompose") {
            id = "android_feature_catalog.android.compose"
            implementationClass = "part.AndroidComposePlugin"
        }
    }
}