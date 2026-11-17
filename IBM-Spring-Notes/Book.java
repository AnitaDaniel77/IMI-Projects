package com.example.demo;

// One book in our little library
public class Book {
    private final int id; // unique number for the book
    private final String title;
    private final String author;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    // Spring uses these getters to build the JSON
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}