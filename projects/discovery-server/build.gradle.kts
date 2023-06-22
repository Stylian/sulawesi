
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
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	testImplementation("org.springframework.boot:spring-boot-starter-test")

	implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.1.0")
	implementation("org.springframework:spring-webflux:6.0.9")
	implementation("mysql:mysql-connector-java:8.0.33")

	implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-server:4.0.2")

	testImplementation("org.testcontainers:junit-jupiter:1.18.3")
}
