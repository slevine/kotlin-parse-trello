val kotlin_version: String by project

plugins {
    application
    kotlin("jvm") version "1.3.60"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

application {
    mainClassName = "com.example.ParseTrelloKt"
}

repositories {
    mavenLocal()
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlin_version")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.10.+")
}


kotlin.sourceSets["main"].kotlin.srcDirs("src")

sourceSets["main"].resources.srcDirs("resources")
