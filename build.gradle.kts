import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "el.stylian.sulawesi"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

plugins {
    val kotlinVersion = "1.8.21"
    kotlin("jvm") version kotlinVersion

    kotlin("plugin.spring") version kotlinVersion
    kotlin("plugin.allopen") version kotlinVersion
    kotlin("plugin.noarg") version kotlinVersion
    kotlin("plugin.jpa") version kotlinVersion
}

subprojects {
    val kotlinVersion = "1.8.21"
    apply(plugin = "org.jetbrains.kotlin.jvm")

    dependencies {
        implementation(kotlin("stdlib-jdk8"))
        testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlinVersion")
        testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
    }

    repositories {
        mavenCentral()
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
}

