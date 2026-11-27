// REST endpoints for books: full CRUD, structured responses, status codes, paging and logging
package com.example.bookstore;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/books")
public class Db15BookController {

    private static final Logger log = LoggerFactory.getLogger(Db15BookController.class);

    private final BookRepository bookRepository;

    public Db15BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // READ all
    @GetMapping
    public ResponseEntity<ApiResponse<List<Book>>> getAll() {
        log.info("Fetching all books");
        List<Book> books = bookRepository.findAll();
        return ResponseEntity.ok(new ApiResponse<>(true, books.size() + " books found", books));
    }

    // READ one page, e.g. /api/books/paged?page=0&size=5&sort=title,asc
    @GetMapping("/paged")
    public ResponseEntity<ApiResponse<Page<Book>>> getPaged(Pageable pageable) {
        log.info("Fetching page {} with size {}", pageable.getPageNumber(), pageable.getPageSize());
        Page<Book> page = bookRepository.findAll(pageable);
        return ResponseEntity.ok(new ApiResponse<>(true, "Page loaded", page));
    }

    // READ one
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Book>> getById(@PathVariable Long id) {
        log.info("Fetching book {}", id);
        Optional<Book> book = bookRepository.findById(id);
        if (book.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse<>(false, "Book " + id + " not found", null));
        }
        return ResponseEntity.ok(new ApiResponse<>(true, "Book found", book.get()));
    }

    // CREATE
    @PostMapping
    public ResponseEntity<ApiResponse<Book>> create(@Valid @RequestBody Book book) {
        Book saved = bookRepository.save(book);
        log.info("Created book {}", saved.getId());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>(true, "Book created", saved));
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Book>> update(@PathVariable Long id, @Valid @RequestBody Book changes) {
        Optional<Book> existing = bookRepository.findById(id);
        if (existing.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse<>(false, "Book " + id + " not found", null));
        }
        Book book = existing.get();
        book.setTitle(changes.getTitle());
        book.setAuthor(changes.getAuthor());
        book.setPrice(changes.getPrice());
        Book saved = bookRepository.save(book); // same id, so JPA updates
        log.info("Updated book {}", id);
        return ResponseEntity.ok(new ApiResponse<>(true, "Book updated", saved));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {
        if (!bookRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse<>(false, "Book " + id + " not found", null));
        }
        bookRepository.deleteById(id);
        log.info("Deleted book {}", id);
        return ResponseEntity.ok(new ApiResponse<>(true, "Book deleted", null));
    }
}