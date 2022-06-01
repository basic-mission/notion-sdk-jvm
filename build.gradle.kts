import org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	kotlin("jvm") version "1.6.10"
	kotlin("plugin.serialization") version "1.6.10"

	id("maven-publish")

	application
	idea
}

group = "com.github.basic-mission"
version = "0.0.3"

val ktorVersion = "2.0.1"
val kotestVersion = "5.3.0"

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
	implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")

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

publishing {
	publications {
		create<MavenPublication>("notionSdkJvm") {
			from(components["java"])

			groupId = "com.github.basic-mission"
			artifactId = "notion-sdk-jvm"
			version = "0.0.3"

			pom {
				name.set("notion-sdk-jvm")
				description.set("unofficially notion sdk for jvm")
				url.set("https://github.com/basic-mission/notion-sdk-jvm")

				developers {
					developer {
						id.set("himitery")
						name.set("Hakjin Lee")
						email.set("himit0131@gmail.com")
					}
					developer {
						id.set("govl6113")
						name.set("Jihyun Bae")
						email.set("govl6113@gmail.com")
					}
				}
			}
		}

	}
}

tasks.withType<Test> {
	useJUnitPlatform()

	testLogging {
		showStandardStreams = true
		showCauses = true
		showExceptions = true
		showStackTraces = true
		exceptionFormat = FULL
	}
}

tasks.withType<KotlinCompile> {
	kotlinOptions.jvmTarget = "11"
}

application {
	mainClass.set("MainKt")
}