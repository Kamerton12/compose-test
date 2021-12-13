import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project

plugins {
    id("com.github.johnrengelman.shadow") version "7.1.0"
    application
    kotlin("jvm") version "1.6.0"
    id("war")
    id("org.gretty") version "3.0.6"
}

gretty {
//    servletContainer = "tomcat9"
    contextPath = "/"
    logbackConfigFile = "src/main/resources/logback.xml"
}

group = "com.example"
version = "0.0.1"

application {
    mainClass.set("com.example.ApplicationKt")
}

tasks.withType<ShadowJar> {
    manifest {
        attributes("Main-Class" to application.mainClass)
    }
}

repositories {
    mavenCentral()
}

tasks.withType(org.jetbrains.kotlin.gradle.tasks.KotlinCompile::class.java).all {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

afterEvaluate {
    tasks.findByName("run")!!.dependsOn(tasks.findByName("appRun"))
}

//mainClassName = "io.ktor.server.netty.EngineMain"

dependencies {
    implementation("io.ktor:ktor-server-core:$ktor_version")
//    implementation("io.ktor:ktor-server-servlet:$ktor_version")
    implementation("io.ktor:ktor-server-netty:$ktor_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    testImplementation("io.ktor:ktor-server-tests:$ktor_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
}