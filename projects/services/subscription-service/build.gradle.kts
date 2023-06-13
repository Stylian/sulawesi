import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.1.0"
	id("io.spring.dependency-management") version "1.1.0"
	kotlin("jvm") version "1.8.21"
	kotlin("plugin.spring") version "1.8.21"
}

group = "el.stylian.sulawesi"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	testImplementation("org.springframework.boot:spring-boot-starter-test")

	implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.1.0")
	implementation("org.springframework:spring-webflux:6.0.9")
	implementation("mysql:mysql-connector-java:8.0.33")

//	implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client:4.0.2")
	testImplementation("com.h2database:h2:2.1.214")

	testImplementation("org.testcontainers:testcontainers:1.18.3")
	testImplementation("org.testcontainers:mongodb:1.18.3")
	testImplementation("org.testcontainers:junit-jupiter:1.18.3")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
