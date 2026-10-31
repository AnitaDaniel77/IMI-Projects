package demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// Starts Spring Boot and turns on component scanning
@SpringBootApplication
public class AnnotationsDemo {
    public static void main(String[] args) {
        SpringApplication.run(AnnotationsDemo.class, args);
    }
}

// @Component: Spring creates one BookService and keeps it in the container
@Component
class BookService {

    // @Value: reads library.name from application.properties, falls back to "City Library"
    @Value("${library.name:City Library}")
    private String libraryName;

    String describe(long id) {
        return "Book " + id + " from " + libraryName;
    }

    String search(String title) {
        return "Searching " + libraryName + " for: " + title;
    }
}

// @RestController: every method returns data directly, not a view
@RestController
class BookRestController {

    private final BookService bookService;

    // Single constructor, so no @Autowired needed. Spring injects the BookService bean.
    BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    // @GetMapping + @PathVariable: /books/7 gives id = 7
    @GetMapping("/books/{id}")
    String book(@PathVariable long id) {
        return bookService.describe(id);
    }

    // @RequestParam: /search?title=Dune gives title = "Dune"
    @GetMapping("/search")
    String search(@RequestParam String title) {
        return bookService.search(title);
    }
}