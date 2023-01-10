println("Extention build kts")
val quarkusPlatformGroupId: String by project;
val quarkusPlatformArtifactId: String by project;
val quarkusPlatformVersion: String by project;

val kotlinVersion: String by project;
val junitVersion: String by project;
val junitLauncherVersion: String by project;

val jvmTarget: String by project;
val projectGroup: String by project;
val projectVersion: String by project;


plugins {

  id("java")
  kotlin("jvm")
  kotlin("kapt")
}


repositories {
  mavenLocal()
  mavenCentral()
  gradlePluginPortal()
}

dependencies {
  implementation(platform("${quarkusPlatformGroupId}:${quarkusPlatformArtifactId}:${quarkusPlatformVersion}"))

}


subprojects {

  group = projectGroup
  version = projectVersion

  apply {
    plugin("java-library")
    plugin("maven-publish")
    plugin("org.jetbrains.kotlin.jvm")
    plugin("org.jetbrains.kotlin.kapt")


  }

  configurations.all {
    resolutionStrategy {
      force("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.7.20")
      force("org.jetbrains.kotlin:kotlin-reflect:1.7.20")
    }
  }



  repositories {
    mavenLocal()
    mavenCentral()
    gradlePluginPortal()
  }

  java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
  }

  dependencies {
    implementation(platform("${quarkusPlatformGroupId}:${quarkusPlatformArtifactId}:${quarkusPlatformVersion}"))

    implementation("io.quarkus:quarkus-bom:${quarkusPlatformVersion}")
    implementation("io.quarkus:quarkus-core:${quarkusPlatformVersion}")
    implementation("io.quarkus:quarkus-jackson")
    implementation("io.quarkus:quarkus-resteasy-jackson")
    implementation("io.quarkus:quarkus-rest-client-jackson")
    testImplementation("io.quarkus:quarkus-bom:${quarkusPlatformVersion}")
    testImplementation("io.quarkus:quarkus-core:${quarkusPlatformVersion}")
    testImplementation("io.quarkus:quarkus-arc-deployment:${quarkusPlatformVersion}")
    testImplementation("io.quarkus:quarkus-core-deployment:${quarkusPlatformVersion}")
    testImplementation("io.quarkus:quarkus-jaxb-deployment:${quarkusPlatformVersion}")
    testImplementation("io.quarkus:quarkus-undertow-deployment:${quarkusPlatformVersion}")
    testImplementation("io.quarkus:quarkus-devtools-testing:${junitVersion}")
    testImplementation("io.quarkus:quarkus-junit5:${junitVersion}")
    testImplementation("io.quarkus:quarkus-junit5-internal:${junitVersion}")
    testImplementation("io.mockk:mockk:1.13.3")
    testImplementation("org.assertj:assertj-core:3.23.1")
    testImplementation("io.quarkus:quarkus-junit5")
    testImplementation("io.rest-assured:rest-assured")
    testImplementation("io.quarkiverse.mockk:quarkus-junit5-mockk:1.1.1")
    testImplementation("org.mockito:mockito-core:4.8.0")
  }

  tasks.test {
    // Use the built-in JUnit support of Gradle.
    systemProperty("java.util.logging.manager", "org.jboss.logmanager.LogManager")
    useJUnitPlatform()
  }
}