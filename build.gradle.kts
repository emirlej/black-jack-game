import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    kotlin("jvm") version "1.8.10"
    id("com.github.johnrengelman.shadow") version "5.2.0"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.8.1")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClassName = "com.emir.learning.kotlin.MainKt"
}

val shadowJar = tasks.getByName("shadowJar") as ShadowJar
shadowJar.apply {
    manifest {
        attributes["Main-Class"] = "com.emir.learning.kotlin.MainKt"
    }
    archiveBaseName.set("black-jack-game")
    archiveVersion.set("1.0.0")
    archiveClassifier.set("")
}
tasks.jar {
    enabled = false
}
