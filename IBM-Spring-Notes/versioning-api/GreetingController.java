package com.example.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // this class answers web requests with data
public class GreetingController {

    // Version 1 of the greeting
    @GetMapping("/api/v1/greeting")
    public String getGreetingV1() {
        return "Hello from version 1";
    }

    // Version 2 of the greeting
    @GetMapping("/api/v2/greeting")
    public String getGreetingV2() {
        return "Hello from version 2, now with more features";
    }
}