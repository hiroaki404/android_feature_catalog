package com.inspiration.android_feature_catalog

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform