import java.util.List;

// every fraud rule follows this shape
interface FraudRule {
    boolean flags(double amount);
}

// flags any amount above R10 000
class HighAmountRule implements FraudRule {
    public boolean flags(double amount) {
        return amount > 10000;
    }
}

// the checker is handed its rules, it never builds them
class FraudChecker {
    private final List<FraudRule> rules;

    FraudChecker(List<FraudRule> rules) {
        this.rules = rules;
    }

    boolean isSuspicious(double amount) {
        for (FraudRule rule : rules) {
            if (rule.flags(amount)) {
                return true;
            }
        }
        return false;
    }
}

public class ManualWiring {
    public static void main(String[] args) {
        // I wire it by hand here, Spring will do this step for me later
        List<FraudRule> rules = List.of(new HighAmountRule());
        FraudChecker checker = new FraudChecker(rules);

        System.out.println(checker.isSuspicious(12500)); // true
        System.out.println(checker.isSuspicious(800));   // false
    }
}