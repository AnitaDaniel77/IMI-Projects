// Entity: one Book object maps to one row in the books table
package com.example.bookstore;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // MySQL auto-increment makes the id
    private Long id;

    private String title;
    private String author;
    private BigDecimal price; // BigDecimal so rands and cents stay exact

    public Book() {
        // JPA needs an empty constructor to build objects from rows
    }

    public Book(String title, String author, BigDecimal price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public Long getId() { return id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    @Override
    public String toString() {
        return id + " | " + title + " | " + author + " | R" + price;
    }
}