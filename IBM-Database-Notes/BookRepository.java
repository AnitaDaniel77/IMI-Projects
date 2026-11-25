// Repository: Spring writes the CRUD code for Book at startup
package com.example.bookstore;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

    // Spring reads the method name and builds: SELECT * FROM book WHERE author = ?
    List<Book> findByAuthor(String author);
}