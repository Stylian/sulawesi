plugins {
    val kotlinVersion = "1.8.21"

    id("org.springframework.boot") version "3.1.0"
    id("io.spring.dependency-management") version "1.1.0"
    kotlin("plugin.spring") version kotlinVersion
    kotlin("plugin.allopen") version kotlinVersion
    kotlin("plugin.noarg") version kotlinVersion
    kotlin("plugin.jpa") version kotlinVersion
}

dependencies {

    testImplementation("org.testcontainers:testcontainers:1.18.3")
    testImplementation("org.testcontainers:mysql:1.18.3")
    testImplementation("org.testcontainers:junit-jupiter:1.18.3")
}
