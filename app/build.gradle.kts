plugins {
    application
    checkstyle
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"
application { mainClass.set("hexlet.code.App") }

repositories { mavenCentral() }

dependencies {

}
java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(20))
    }
}

val run by tasks.getting(JavaExec::class) {
    standardInput = System.`in`
}
