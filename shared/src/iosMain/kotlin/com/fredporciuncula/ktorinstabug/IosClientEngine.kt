package com.fredporciuncula.ktorinstabug

import io.ktor.client.engine.darwin.Darwin

actual fun createClientEngine() = Darwin.create()
