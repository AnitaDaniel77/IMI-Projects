// Custom login form, logout and BCrypt password hashing
package com.example.demosecurity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

// Security rules
@Configuration
@EnableWebSecurity
public class FormSecurityDemo {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/public/**").permitAll() // open pages
                .anyRequest().authenticated() // rest needs login
            )
            .formLogin(form -> form
                .loginPage("/login") // our own login page
                .permitAll() // everyone can see it
            )
            .logout(logout -> logout.permitAll()); // allow sign out
        return http.build();
    }

    // BCrypt for hashing passwords
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

// Shows the login page
@Controller
class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login"; // templates/login.html
    }
}

// User table in the database
@Entity
class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password; // stored as hash

    public Long getId() { return id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}

// Database access for users
interface UserRepository extends JpaRepository<AppUser, Long> {
}

// Hashes the password before saving
@Service
class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public AppUser register(String username, String plainPassword) {
        AppUser user = new AppUser();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(plainPassword)); // hash it first
        return userRepository.save(user);
    }
}

/*
src/main/resources/templates/login.html (key parts)

<form th:action="@{/login}" method="post">
    <label>Username</label>
    <input type="text" name="username">

    <label>Password</label>
    <input type="password" name="password">

    <button type="submit">Log in</button>
</form>

<p th:if="${param.error}">Wrong username or password</p>
<p th:if="${param.logout}">You have logged out</p>
*/