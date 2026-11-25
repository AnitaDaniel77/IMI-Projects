// Runs once at startup to show save, find, update and delete through the repository
package com.example.bookstore;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Db13JpaDemo implements CommandLineRunner {

    private final BookRepository bookRepository;

    public Db13JpaDemo(BookRepository bookRepository) {
        this.bookRepository = bookRepository; // Spring hands us the repository
    }

    @Override
    public void run(String... args) {
        // CREATE
        Book book = new Book();
        book.setTitle("Advanced Java");
        book.setAuthor("Author X");
        book.setPrice(new BigDecimal("499.99"));
        Book saved = bookRepository.save(book); // JPA writes the INSERT
        System.out.println("Saved: " + saved);

        bookRepository.save(new Book("Spring Boot in Practice", "Author Y", new BigDecimal("560.00")));

        // READ
        System.out.println("All books:");
        for (Book b : bookRepository.findAll()) {
            System.out.println("  " + b);
        }
        System.out.println("By Author X: " + bookRepository.findByAuthor("Author X"));

        // UPDATE: change the object, save it again
        saved.setPrice(new BigDecimal("399.99"));
        bookRepository.save(saved); // same id, so JPA writes an UPDATE
        System.out.println("After update: " + bookRepository.findById(saved.getId()).orElse(null));

        // DELETE
        bookRepository.deleteById(saved.getId());
        System.out.println("Books left: " + bookRepository.count());
    }
}