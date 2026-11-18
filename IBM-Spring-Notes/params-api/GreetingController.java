package com.example.params;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api") // every address starts with /api
public class GreetingController {

    // GET /api/greeting?name=Anita
    @GetMapping("/greeting")
    public String greet(@RequestParam(required = false, defaultValue = "World") String name) {
        return "Hello, " + name + "!"; // name comes from the query part of the URL
    }
}