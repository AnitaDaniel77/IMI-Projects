package com.example.versioning;

import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/users") // version 2 addresses start here
public class UserControllerV2 {

    // GET /api/v2/users/1 returns extended user information
    @GetMapping("/{id}")
    public Map<String, Object> getUser(@PathVariable int id) {
        return Map.of("id", id, "name", "Thabo Mokoena", "email", "thabo@example.com");
    }
}