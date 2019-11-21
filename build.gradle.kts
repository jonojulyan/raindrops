import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.2.1.RELEASE" apply true
    id("io.spring.dependency-management") version "1.0.8.RELEASE" apply true
    id("com.github.johnrengelman.shadow") version "5.2.0" apply true
    id("org.jetbrains.kotlin.plugin.noarg") version "1.3.50" apply true
    id("org.jetbrains.kotlin.plugin.jpa") version "1.3.50" apply true
    kotlin("jvm") version "1.3.50" apply true
    kotlin("plugin.spring") version "1.3.50" apply true
}

group = "za.co.bsg"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
    maven { url = uri("https://repo.spring.io/milestone") }
}

extra["springCloudVersion"] = "Hoxton.RC2"

dependencies {
    implementation(group = "org.springframework.boot", name = "spring-boot-starter")
    implementation(group = "org.springframework.boot", name = "spring-boot-starter-web")
    implementation(group = "org.springframework.boot", name = "spring-boot-starter-data-jpa")
    implementation(group = "com.h2database", name = "h2")
    implementation(group = "org.jetbrains.kotlin", name = "kotlin-reflect")
    implementation(group = "org.jetbrains.kotlin", name = "kotlin-allopen")
    implementation(group = "org.jetbrains.kotlin", name = "kotlin-maven-noarg")
    implementation(group = "org.jetbrains.kotlin", name = "kotlin-stdlib-jdk8")
    implementation(group = "org.slf4j", name = "slf4j-api", version = "1.7.29")
    implementation(group = "org.slf4j", name = "log4j-over-slf4j", version = "1.7.29")
    implementation(group = "ch.qos.logback", name = "logback-classic", version = "1.2.3")
    implementation(group = "ch.qos.logback", name = "logback-core", version = "1.2.3")
    implementation(group = "com.fasterxml.jackson.dataformat", name = "jackson-dataformat-xml", version = "2.10.1")
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}
