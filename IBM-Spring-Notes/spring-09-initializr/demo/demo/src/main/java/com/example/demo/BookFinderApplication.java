package com.example.bookfinder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// application.properties for this app:
// server.port=8080
// logging.level.com.example.bookfinder=INFO
@SpringBootApplication
public class BookFinderApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookFinderApplication.class, args); // starts the app and the embedded server
    }
}

// model: private fields with getters and setters (encapsulation)
class Book {

    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

@RestController // this class answers web requests
class BookController {

    private static final Logger log = LoggerFactory.getLogger(BookController.class); // one logger per class

    @GetMapping("/book") // answers GET http://localhost:8080/book
    public String getBook() {
        log.info("getBook was called"); // appears in the console
        Book book = new Book("Clean Code", "Robert C. Martin"); // hard-coded for now
        return book.getTitle();
    }
}