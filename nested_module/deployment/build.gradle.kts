import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val quarkusPlatformGroupId: String by project;
val quarkusPlatformArtifactId: String by project;
val quarkusPlatformVersion: String by project;

val kotlinVersion: String by project;
val junitVersion: String by project;
val junitLauncherVersion: String by project;

val projectGroup: String by project;
val projectVersion: String by project;
val projectArtifactId: String by project;

group = projectGroup
version = projectVersion

println("Extension deployment module loaded")

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = projectGroup
            artifactId = "${projectArtifactId}-deployment"
            version = projectVersion

            from(components["java"])
        }
    }
}

dependencies {

    implementation("io.quarkus:quarkus-bom:${quarkusPlatformVersion}")
    implementation("io.quarkus:quarkus-core-deployment:${quarkusPlatformVersion}")
    implementation("io.quarkus:quarkus-arc-deployment:${quarkusPlatformVersion}")
    implementation("io.quarkus:quarkus-undertow-deployment:${quarkusPlatformVersion}")

//    testImplementation("io.quarkus:quarkus-junit5-internal")
    implementation(project(":config-driver"))

    implementation("io.quarkus:quarkus-extension-processor:${quarkusPlatformVersion}")
    annotationProcessor("io.quarkus:quarkus-extension-processor:${quarkusPlatformVersion}")
    kapt("io.quarkus:quarkus-extension-processor:${quarkusPlatformVersion}")
}
