package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // this class answers web requests with data
@RequestMapping("/api") // every address starts with /api
public class BookController {

    // Builds the list of books we serve
    private List<Book> loadBooks() {
        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "Clean Code", "Robert C. Martin"));
        books.add(new Book(2, "Effective Java", "Joshua Bloch"));
        books.add(new Book(3, "Head First Java", "Kathy Sierra"));
        return books;
    }

    // GET /api/books returns every book as JSON
    @GetMapping("/books")
    public List<Book> getBooks() {
        return loadBooks();
    }

    // GET /api/books/2 returns only the book with id 2
    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable int id) {
        for (Book book : loadBooks()) {
            if (book.getId() == id) { // found the matching book
                return book;
            }
        }
        return null; // no match (a proper 404 comes later)
    }
}