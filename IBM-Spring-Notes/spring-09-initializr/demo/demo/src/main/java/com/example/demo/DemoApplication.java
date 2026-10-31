package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    // starts Spring Boot and the built-in web server
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}