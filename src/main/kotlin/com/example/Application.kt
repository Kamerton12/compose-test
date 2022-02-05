package com.example

import io.ktor.server.engine.*
import com.example.plugins.*
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.server.netty.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureRouting()
        install(CallLogging)
    }.start(wait = true)
}
