// Model and controller for the user sign-up form, with validation
package com.example.userform;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

// Model: holds the form data plus the rules for it
class User {

    @NotEmpty(message = "First name is required")
    @Size(min = 2, max = 30, message = "First name must be 2 to 30 characters")
    private String firstName;

    @NotEmpty(message = "Last name is required")
    @Size(min = 2, max = 30, message = "Last name must be 2 to 30 characters")
    private String lastName;

    @NotEmpty(message = "Email is required")
    @Email(message = "Enter a valid email address")
    private String email;

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}

// Controller: handles the form requests
@Controller
public class UserController {

    // Show the empty form
    @GetMapping("/userForm")
    public String showForm(Model model) {
        model.addAttribute("user", new User()); // blank user for the form to fill
        return "userForm"; // templates/userForm.html
    }

    // Handle the submitted form
    @PostMapping("/submitForm")
    public String submitForm(@Valid @ModelAttribute("user") User user,
                             BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "userForm"; // send back with errors
        }
        model.addAttribute("user", user); // pass data to result page
        return "formResult"; // templates/formResult.html
    }
}

/*
templates/userForm.html (key parts)

<form th:action="@{/submitForm}" th:object="${user}" method="post">
    <input type="text" th:field="*{firstName}">
    <div th:if="${#fields.hasErrors('firstName')}" th:errors="*{firstName}"></div>

    <input type="text" th:field="*{lastName}">
    <div th:if="${#fields.hasErrors('lastName')}" th:errors="*{lastName}"></div>

    <input type="email" th:field="*{email}">
    <div th:if="${#fields.hasErrors('email')}" th:errors="*{email}"></div>

    <button type="submit">Submit</button>
</form>

templates/formResult.html (key parts)

<p th:text="${user.firstName}"></p>
<p th:text="${user.lastName}"></p>
<p th:text="${user.email}"></p>
*/