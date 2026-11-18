package com.example.params;

import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books") // every address starts with /api/books
public class BookController {

    private final Map<Integer, Book> books = new HashMap<>(); // id -> book, kept in memory
    private int nextId = 1; // id for the next new book

    // GET /api/books returns every book
    @GetMapping
    public Map<Integer, Book> getAllBooks() {
        return books;
    }

    // GET /api/books/1 returns one book (id comes from the path)
    @GetMapping("/{id}")
    public Book getBook(@PathVariable int id) {
        return books.get(id); // empty if the id does not exist
    }

    // POST /api/books adds the book sent in the body
    @PostMapping
    public String addBook(@RequestBody Book book) {
        int id = nextId;
        nextId = nextId + 1; // move the counter on
        books.put(id, book);
        return "Book added with id " + id;
    }

    // PUT /api/books/1 replaces the book with that id
    @PutMapping("/{id}")
    public String updateBook(@PathVariable int id, @RequestBody Book book) {
        if (!books.containsKey(id)) {
            return "Book not found";
        }
        books.put(id, book);
        return "Book " + id + " updated";
    }

    // DELETE /api/books/1 removes the book with that id
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable int id) {
        if (!books.containsKey(id)) {
            return "Book not found";
        }
        books.remove(id);
        return "Book " + id + " deleted";
    }
}