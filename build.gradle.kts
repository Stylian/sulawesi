import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


val kotlinVersion = "1.8.21"
plugins {
    val kotlinVersion = "1.8.21"
    kotlin("jvm") version kotlinVersion
}

repositories {
    mavenCentral()
}

subprojects {
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

