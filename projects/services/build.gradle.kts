subprojects {
    dependencies {
        implementation(project(":projects:shared"))
        implementation(project(":projects:commons"))

        implementation("org.springframework.boot:spring-boot-starter-web")
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.1.0")
        implementation("org.springframework:spring-webflux:6.0.9")
        implementation("mysql:mysql-connector-java:8.0.33")
        
        implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client:4.0.2")
        implementation("org.springframework.cloud:spring-cloud-starter-circuitbreaker-resilience4j:3.0.2")
        implementation("org.springframework.boot:spring-boot-starter-actuator")

        testImplementation("org.springframework.boot:spring-boot-starter-test")
        testImplementation("com.h2database:h2:2.1.214")
    }
}