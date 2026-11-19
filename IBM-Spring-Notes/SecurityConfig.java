// Basic Spring Security setup: logins, roles and password hashing
package com.example.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableMethodSecurity // turns on @PreAuthorize
public class SecurityConfig {

    // URL rules and login types
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/", "/public/**").permitAll() // open to everyone
                .requestMatchers("/admin/**").hasRole("ADMIN") // admins only
                .anyRequest().authenticated() // everything else needs login
            )
            .formLogin(withDefaults()) // default login page
            .httpBasic(withDefaults()); // allow basic auth too
        // CSRF protection is on by default
        return http.build();
    }

    // Hashes passwords one-way
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Two test users kept in memory
    @Bean
    public UserDetailsService users(PasswordEncoder encoder) {
        UserDetails teller = User.withUsername("teller")
                .password(encoder.encode("teller123"))
                .roles("USER")
                .build();

        UserDetails manager = User.withUsername("manager")
                .password(encoder.encode("manager123"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(teller, manager);
    }
}

// Method-level check example
@Service
class AccountService {

    @PreAuthorize("hasRole('ADMIN')") // only admins can run this
    public void closeAccount(String accountNumber) {
        System.out.println("Closing account " + accountNumber);
    }
}