plugins {
	java
	id("org.springframework.boot") version "3.0.4"
	id("io.spring.dependency-management") version "1.1.0"
}

group = "pl.dogout"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web:3.0.4")
	implementation("org.postgresql:postgresql:42.5.4")
	implementation("org.springframework.boot:spring-boot-devtools:3.0.4")
	implementation("org.projectlombok:lombok:1.18.26")
	implementation("io.jsonwebtoken:jjwt:0.9.1")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.0.4")
	testImplementation("org.springframework.boot:spring-boot-starter-test:3.0.4")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
