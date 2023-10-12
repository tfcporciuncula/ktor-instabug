package com.fredporciuncula.ktorinstabug

import io.ktor.client.engine.okhttp.OkHttp

actual fun createClientEngine() = OkHttp.create()
