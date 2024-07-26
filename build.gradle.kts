plugins {
    kotlin("jvm") version "2.0.0"
    checkstyle
}
checkstyle {
    configFile = rootProject.file("checkstyle.xml")
}

group = "ru.af3412"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.10.1")
    testImplementation("org.assertj:assertj-core:3.24.2")
}

tasks.test {
    useJUnitPlatform()
}
