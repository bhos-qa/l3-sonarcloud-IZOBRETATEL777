plugins {
    id("java")
    id("org.sonarqube") version "4.3.1.3277"
    id("jacoco")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
//    Junit
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")

//    Lombok
    compileOnly("org.projectlombok:lombok:1.18.30")
    annotationProcessor("org.projectlombok:lombok:1.18.30")
    testCompileOnly ("org.projectlombok:lombok:1.18.30")
    testAnnotationProcessor ("org.projectlombok:lombok:1.18.30")

//    JaCoCo
    testImplementation("org.jacoco:org.jacoco.agent:0.8.10")
}

tasks.test {
    useJUnitPlatform()
}

sonar {
    properties {
        property("sonar.projectKey", "bhos-qa_l3-sonarcloud-IZOBRETATEL777")
        property("sonar.organization", "bhos-qa")
        property("sonar.host.url", "https://sonarcloud.io")
        property("sonar.groovy.jacoco.reportPath", "build/reports/tests/JaCoCo/xml/coverage.xml")
    }
}

tasks.withType<JacocoReport> {
    classDirectories.setFrom(
            fileTree(
                    mapOf("dir" to "build/classes/java/main",
                            "excludes" to listOf("**/Main.class"))
            )
    )
    reports {
        xml.required = true
        xml.outputLocation = file("$buildDir/reports/tests/JaCoCo/xml/coverage.xml")

        html.required = true
        html.outputLocation = file("$buildDir/reports/tests/JaCoCo/html")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
    finalizedBy("jacocoTestReport")
    reports {
        junitXml.required = true
        junitXml.outputLocation = file("$buildDir/reports/tests/JUnit/xml")

        html.required = true
        html.outputLocation = file("$buildDir/reports/tests/JUnit/html")
    }
}