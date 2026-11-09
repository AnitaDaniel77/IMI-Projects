package com.anitadaniel.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// what Initializr generates: a main class like this one
// settings used: Maven, Java 21, Group com.anitadaniel, Artifact demo, dependency Spring Web
@SpringBootApplication
public class InitializrDemo {

    public static void main(String[] args) {
        SpringApplication.run(InitializrDemo.class, args); // starts the app and the embedded server
    }

    // extra bit I add to prove Spring Web works
    @RestController
    static class HelloController {

        @GetMapping("/hello") // answers GET http://localhost:8080/hello
        String hello() {
            return "Hello from Spring Initializr";
        }
    }
}

// to run it from the project folder in the terminal:
// ./mvnw spring-boot:run