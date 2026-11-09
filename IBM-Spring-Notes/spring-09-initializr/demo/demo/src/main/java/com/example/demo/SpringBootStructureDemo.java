package com.anitadaniel.fraudengine;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.UUID;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// simplified from my fraud engine, one file so every layer is visible together
@SpringBootApplication // entry point: configuration, auto-configuration, component scan
public class SpringBootStructureDemo {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootStructureDemo.class, args);
    }
}

@Entity // one object is one row in the table
class DemoTransaction {

    @Id
    private String id = UUID.randomUUID().toString(); // unique id for each row

    protected DemoTransaction() { // JPA needs an empty constructor
    }

    public String getId() {
        return id;
    }
}

// repository layer: Spring builds the real clerk from this interface
interface DemoTransactionRepository extends JpaRepository<DemoTransaction, String> {
}

@Service // service layer: business logic goes here
class DemoFraudService {

    private final DemoTransactionRepository repository;

    DemoFraudService(DemoTransactionRepository repository) { // single constructor, so no @Autowired needed
        this.repository = repository;
    }

    DemoTransaction find(String id) {
        return repository.findById(id).orElseThrow(); // fails if the id does not exist
    }
}

@RestController // controller layer: receives requests, returns JSON
@RequestMapping("/api/demo") // every address here starts with /api/demo
class DemoTransactionController {

    private final DemoFraudService service;

    DemoTransactionController(DemoFraudService service) {
        this.service = service;
    }

    @GetMapping("/{id}") // GET /api/demo/some-id
    DemoTransaction getOne(@PathVariable("id") String id) {
        return service.find(id);
    }
}