plugins {
    id("java")
    id("application")
    id("org.openjfx.javafxplugin") version "0.1.0"
    kotlin("jvm")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    // for installing JSONPATH
    implementation("com.jayway.jsonpath:json-path:2.9.0")
    // Added to ignore the slf4j-nop errors.
    implementation("org.slf4j:slf4j-nop:2.0.9")
    implementation(kotlin("stdlib-jdk8"))
}

javafx {
    version = "22"
    modules("javafx.controls", "javafx.fxml")
}
application {
    mainClass.set("edu.bsu.cs.view.GUI.WikipediaGUI")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(20)
}