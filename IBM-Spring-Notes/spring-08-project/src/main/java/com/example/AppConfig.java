package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    // Spring calls this and keeps the result as a bean
    @Bean
    public HelloBean helloBean() {
        return new HelloBean();
    }
}