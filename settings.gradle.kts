pluginManagement {

  val quarkusPlatformVersion: String by settings
  val quarkusPluginId: String by settings
  val kotlinVersion: String by settings

  repositories {
    mavenLocal()
    mavenCentral()
    gradlePluginPortal()
  }

  plugins {
    id("io.quarkus") version quarkusPlatformVersion
    id("io.quarkus.extension") version quarkusPlatformVersion
    kotlin("jvm") version kotlinVersion
    kotlin("kapt") version kotlinVersion
  }
}
val projectArtifactId: String by settings

include(":runtime", ":deployment", ":tests")

project(":runtime").name = "config-driver"
rootProject.name = "config-driver-extension"