package com.example.multiapps

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform