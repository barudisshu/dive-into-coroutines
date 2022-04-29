group = "info.galudisu"
version = "1.0-SNAPSHOT"

val kotlinCoroutinesVersion = "1.6.1"
// log
val log4j2Version = "2.17.2"
// Test
val jupiterVersion = "5.8.2"
val platformVersion = "1.8.2"

plugins {
  kotlin("jvm") version "1.6.20"
  idea
  application
}

idea {
  module.isDownloadJavadoc = true
  module.isDownloadSources = true
}

dependencies {
  implementation(kotlin("stdlib"))
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinCoroutinesVersion")
  implementation("org.apache.logging.log4j:log4j-api:$log4j2Version")
  implementation("org.apache.logging.log4j:log4j-core:$log4j2Version")
  implementation("org.apache.logging.log4j:log4j-slf4j-impl:$log4j2Version")
  testImplementation(kotlin("test"))
  testImplementation("org.junit.jupiter:junit-jupiter-api:$jupiterVersion")
  testImplementation("org.junit.jupiter:junit-jupiter-engine:$jupiterVersion")
  testImplementation("org.junit.platform:junit-platform-runner:$platformVersion")
}

tasks.test {
  useJUnitPlatform()
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
  kotlinOptions.jvmTarget = "11"
  kotlinOptions.freeCompilerArgs = listOf("-Xopt-in=kotlin.RequiresOptIn", "-Xjsr305=strict")
}

application {
  mainClass.set("info.galudisu.MainKt")
}
