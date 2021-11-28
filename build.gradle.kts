import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.6.0"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.6.0"
    kotlin("plugin.spring") version "1.6.0"
}

group = "com.zbogdan.app"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-security:2.5.6")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf:2.5.6")
    implementation("org.springframework.boot:spring-boot-starter-web:2.5.6")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.0")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.thymeleaf.extras:thymeleaf-extras-springsecurity5:3.0.4.RELEASE")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2-native-mt")
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb:2.5.6")
    implementation("org.springframework.boot:spring-boot-starter-data-cassandra:2.5.6")
    implementation("org.springframework.boot:spring-boot-starter-data-redis:2.5.6")
    implementation("org.springframework.boot:spring-boot-starter-data-couchbase:2.5.6")
    implementation("com.github.javafaker:javafaker:1.0.2")
    testImplementation("org.springframework.boot:spring-boot-starter-test:2.5.6")
    testImplementation("org.springframework.security:spring-security-test:5.5.1")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
