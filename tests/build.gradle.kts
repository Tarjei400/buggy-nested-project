import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val quarkusPlatformGroupId: String by project;
val quarkusPlatformArtifactId: String by project;
val quarkusPlatformVersion: String by project;

val kotlinVersion: String by project;
val junitVersion: String by project;
val junitLauncherVersion: String by project;

val jvmTarget: String by project;


group = "org.acme"
version = "1.0.0-SNAPSHOT"

println("Extension tests module loaded")

plugins {
    id("java-library")
    id("io.quarkus")
    kotlin("kapt")
}

dependencies {

    implementation("dev.techyon.configly:config-driver:0.0.1")

}