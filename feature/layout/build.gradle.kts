@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id("android_feature_catalog.android.library")
    id("android_feature_catalog.android.compose")
}

android.namespace = "com.inspiration.android_feature_catalog.feature.layout"

dependencies {

    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation("androidx.compose.material:material:1.4.3")
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
    implementation(libs.coil)

    implementation(libs.compose.ui)
    implementation(libs.compose.ui.tooling)
    implementation(libs.compose.preview)
    implementation(libs.compose.foundation)
    implementation(libs.activity.compose)
}

//TODO:publish plugin