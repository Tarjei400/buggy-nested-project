import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val quarkusPlatformGroupId: String by project;
val quarkusExtensionArtifactId: String by project;
val quarkusPlatformArtifactId: String by project;
val quarkusPlatformVersion: String by project;

val kotlinVersion: String by project;
val junitVersion: String by project;
val junitLauncherVersion: String by project;
val http4kVersion: String by project;
val striktVersion: String by project;
val pesticideVersion: String by project;


val projectGroup: String by project;
val projectVersion: String by project;
val projectArtifactId: String by project;
group = projectGroup
version = projectVersion


println("Extension runtime module loaded")

plugins {

    id("io.quarkus.extension")
    kotlin("jvm")
    kotlin("kapt")
}


publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = projectGroup
            artifactId = projectArtifactId
            version = projectVersion

            from(components["java"])
        }
    }
}

dependencies {
    implementation(platform("io.quarkus:quarkus-bom:${quarkusPlatformVersion}"))
    implementation("io.quarkus:quarkus-arc")
    implementation("io.quarkus:quarkus-core")
    implementation("io.quarkus:quarkus-kotlin")
    implementation("io.quarkus:quarkus-undertow")

    implementation("io.quarkus:quarkus-extension-processor:${quarkusPlatformVersion}")
    annotationProcessor("io.quarkus:quarkus-extension-processor:${quarkusPlatformVersion}")
    kapt("io.quarkus:quarkus-extension-processor:${quarkusPlatformVersion}")
}
