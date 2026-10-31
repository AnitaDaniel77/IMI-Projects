package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// the entry point Spring Initializr generates for you
@SpringBootApplication
public class PingApp {

    public static void main(String[] args) {
        SpringApplication.run(PingApp.class, args);
    }
}

// one endpoint, this is what IntelliJ Ultimate's Endpoints window would list
@RestController
class PingController {

    @GetMapping("/ping")
    String ping() {
        return "pong";
    }
}