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
    implementation("org.apache.commons:commons-dbcp2:2.13.0")

    implementation("org.hibernate:hibernate-core:6.6.11.Final")
    implementation("com.h2database:h2:2.3.232")

    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.10.1")
    testImplementation("org.assertj:assertj-core:3.24.2")
}

tasks.test {
    useJUnitPlatform()
}
