package com.fredporciuncula.ktorinstabug

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform