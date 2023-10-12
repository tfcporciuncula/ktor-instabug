package com.fredporciuncula.ktorinstabug

import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.forms.formData
import io.ktor.client.request.forms.submitFormWithBinaryData
import io.ktor.http.ContentType
import io.ktor.http.Headers
import io.ktor.http.HttpHeaders
import io.ktor.utils.io.core.toByteArray

object KtorClient {

  private val clientEngine = createClientEngine()

  private val httpClient = HttpClient(clientEngine) {
    install(Logging) {
      logger = object : Logger {
        override fun log(message: String) = co.touchlab.kermit.Logger.v { message }
      }
      level = LogLevel.ALL
    }
  }

  suspend fun submitForm() {
    httpClient.submitFormWithBinaryData(
      url = "http://192.168.1.189:8080/upload", // Update IP address to wherever the Ktor server is running
      formData = formData {
        append("description", "whatever")
        append("file", "whatever".toByteArray(), Headers.build {
          append(HttpHeaders.ContentType, ContentType.MultiPart.FormData.toString())
          append(HttpHeaders.ContentDisposition, "filename=\"test-file.png\"")
        })
      }) {
    }
  }
}

expect fun createClientEngine(): HttpClientEngine
