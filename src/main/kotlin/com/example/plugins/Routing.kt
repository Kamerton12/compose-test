package com.example.plugins

import io.ktor.routing.*
import io.ktor.application.*
import io.ktor.http.content.*
import io.ktor.response.*

fun Application.configureRouting() {

    // Starting point for a Ktor app:
    routing {
        get("/") {
            call.respondText("Hello World4!\n")
        }

        static("/.well-known") {
            resource("assetlinks.json", "files/assetlinks.json")
        }
    }
}