package com.example.mvc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller // returns view names, not raw data
public class SearchController {

    private final List<Book> books = new ArrayList<>(); // our little bookstore

    public SearchController() {
        books.add(new Book("Clean Code", "Robert C. Martin", new BigDecimal("599.00")));
        books.add(new Book("Effective Java", "Joshua Bloch", new BigDecimal("749.50")));
        books.add(new Book("Head First Java", "Kathy Sierra", new BigDecimal("499.99")));
    }

    // GET /search?title=java
    @GetMapping("/search")
    public String search(@RequestParam(defaultValue = "") String title, Model model) {
        List<Book> results = new ArrayList<>();
        for (Book book : books) {
            // match ignoring capital letters
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                results.add(book);
            }
        }
        model.addAttribute("books", results); // data for the view
        model.addAttribute("searchTerm", title);
        return "searchResults"; // ViewResolver finds searchResults.html
    }
}