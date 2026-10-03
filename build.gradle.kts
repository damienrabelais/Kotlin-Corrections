plugins {
    kotlin("jvm") version "2.1.20"
}

group = "org.exemple"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))

    // Fournit le moteur d'exécution JUnit 5
    implementation("org.junit.jupiter:junit-jupiter:5.10.2")

}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(23)
}