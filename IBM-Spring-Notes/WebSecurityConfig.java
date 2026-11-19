// Security setup with in-memory users, URL rules and role checks
package com.example.authdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity // needed for @PreAuthorize
public class WebSecurityConfig {

    // Who can reach which URLs
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/public/**").permitAll() // anyone
                .requestMatchers("/user/**").hasRole("USER") // users only
                .requestMatchers("/admin/**").hasRole("ADMIN") // admins only
                .anyRequest().authenticated() // rest needs login
            )
            .formLogin(withDefaults()); // send to login form
        return http.build();
    }

    // Hash passwords before storing
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Test users kept in memory
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
        UserDetails user = User.withUsername("user")
                .password(encoder.encode("password"))
                .roles("USER")
                .build();

        UserDetails admin = User.withUsername("admin")
                .password(encoder.encode("adminpass"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }
}

// Endpoints to test each access level
@RestController
class DemoController {

    @GetMapping("/public/hello")
    public String publicPage() {
        return "Public page, no login needed";
    }

    @PreAuthorize("hasRole('USER')") // only USER role
    @GetMapping("/user/profile")
    public String userProfile() {
        return "Your profile page";
    }

    @PreAuthorize("hasRole('ADMIN')") // only ADMIN role
    @GetMapping("/admin/dashboard")
    public String adminDashboard() {
        return "Admin dashboard";
    }
}