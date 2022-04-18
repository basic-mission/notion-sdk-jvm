import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	kotlin("jvm") version "1.6.10"
	kotlin("plugin.serialization") version "1.6.10"
	application
}

group = "me.ey611"
version = "1.0-SNAPSHOT"

val ktorVersion = "2.0.0"
val kotestVersion = "5.2.3"

repositories {
	mavenCentral()
}

dependencies {
	// coroutine
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.1")

	// ktor
	implementation("io.ktor:ktor-client-core:$ktorVersion")
	implementation("io.ktor:ktor-client-java:$ktorVersion")
	implementation("io.ktor:ktor-client-logging:$ktorVersion")
	implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
	implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")

	// serialization
	implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2")

	// logger
	implementation("io.github.microutils:kotlin-logging-jvm:2.1.21")
	testImplementation("org.slf4j:slf4j-simple:1.7.36")

	// test
	testImplementation("io.kotest:kotest-runner-junit5:$kotestVersion")
	testImplementation("io.kotest:kotest-assertions-core:$kotestVersion")
	testImplementation(kotlin("test"))
}

buildscript {
	repositories { mavenCentral() }

	dependencies {
		val kotlinVersion = "1.6.10"
		classpath(kotlin("gradle-plugin", version = kotlinVersion))
		classpath(kotlin("serialization", version = kotlinVersion))
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
	kotlinOptions.jvmTarget = "11"
}

application {
	mainClass.set("MainKt")
}