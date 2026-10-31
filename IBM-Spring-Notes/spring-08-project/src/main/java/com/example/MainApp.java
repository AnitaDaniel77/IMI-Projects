package com.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

    public static void main(String[] args) {
        // start Spring using AppConfig, closes itself at the end
        try (var context = new AnnotationConfigApplicationContext(AppConfig.class)) {
            // ask the container for the bean
            HelloBean hello = context.getBean(HelloBean.class);
            hello.sayHello();
        }
    }
}