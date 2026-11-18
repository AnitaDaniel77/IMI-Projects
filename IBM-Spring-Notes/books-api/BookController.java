package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // this class answers web requests with data
@RequestMapping("/api") // every address starts with /api
public class BookController {

    private final List<Book> books = new ArrayList<>(); // books live in memory

    @Value("${app.description}") // filled from application.properties
    private String description;

    // GET /api/books returns all the books
    @GetMapping("/books")
    public List<Book> getBooks() {
        return books;
    }

    // POST /api/books adds the book sent in the request body
    @PostMapping("/books")
    public Book addBook(@RequestBody Book book) {
        books.add(book);
        return book;
    }

    // GET /api/info/description returns the text from the properties file
    @GetMapping("/info/description")
    public String getDescription() {
        return description;
    }
}