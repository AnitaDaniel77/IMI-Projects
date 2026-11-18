package com.example.mvc;

import java.math.BigDecimal;

// The Model: one book in the bookstore
public class Book {
    private final String title;
    private final String author;
    private final BigDecimal price; // BigDecimal for money

    public Book(String title, String author, BigDecimal price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Thymeleaf reads these getters to fill the page
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public BigDecimal getPrice() {
        return price;
    }
}