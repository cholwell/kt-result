group = "cholwell.dev"

version = "1.3"

plugins {
    alias(libs.plugins.kotlin)
    `maven-publish`
}

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/cholwell/kotlin-result")
            credentials {
                username = project.findProperty("gpruser") as String? ?: System.getenv("gpruser")
                password = project.findProperty("gprkey") as String? ?: System.getenv("gprkey")
            }
        }
    }
    publications { register<MavenPublication>("gpr") { from(components["java"]) } }
}
