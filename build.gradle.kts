plugins {
    kotlin("jvm") version "1.5.10"
}

group = "ru.otus.okb.first"
version = "0.0.1"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))

    testImplementation(kotlin("test-junit"))
}