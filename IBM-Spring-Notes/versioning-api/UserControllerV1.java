package com.example.versioning;

import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users") // version 1 addresses start here
public class UserControllerV1 {

    // GET /api/v1/users/1 returns basic user information
    @GetMapping("/{id}")
    public Map<String, Object> getUser(@PathVariable int id) {
        return Map.of("id", id, "name", "Thabo Mokoena");
    }
}