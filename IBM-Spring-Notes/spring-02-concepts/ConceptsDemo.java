package demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

// every fraud rule follows this shape
interface FraudRule {
    String name();
    boolean flags(double amount);
}

// component: Spring creates this bean for me
@Component
class HighAmountRule implements FraudRule {
    public String name() { return "HighAmountRule"; }
    public boolean flags(double amount) { return amount > 10000; }
}

// second rule, flags suspicious round amounts
@Component
class RoundAmountRule implements FraudRule {
    public String name() { return "RoundAmountRule"; }
    public boolean flags(double amount) { return amount > 0 && amount % 1000 == 0; }
}

// Spring injects every FraudRule bean here, no new keyword anywhere
@Component
class FraudChecker {
    private final List<FraudRule> rules;

    FraudChecker(List<FraudRule> rules) {
        this.rules = rules;
    }

    List<String> check(double amount) {
        List<String> hits = new ArrayList<>();
        for (FraudRule rule : rules) {
            if (rule.flags(amount)) {
                hits.add(rule.name());
            }
        }
        return hits;
    }
}

@SpringBootApplication
public class ConceptsDemo {

    public static void main(String[] args) {
        SpringApplication.run(ConceptsDemo.class, args);
    }

    // bean method: Spring passes in the checker it already built
    @Bean
    CommandLineRunner run(FraudChecker checker) {
        return args -> {
            System.out.println("12000 -> " + checker.check(12000)); // both rules flag it
            System.out.println("800 -> " + checker.check(800));     // empty list
        };
    }
}