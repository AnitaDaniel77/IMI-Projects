// SME 26 Nov: Capstone 4 prep, strategy pattern for picking a payment rail, plus fraud score and decision trace
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Capstone4RoutingPrep {

    // Order validates itself, so a bad order can't even be created
    record Order(String id, BigDecimal amount) {
        Order {
            if (id == null || id.isBlank()) {
                throw new IllegalArgumentException("Order id is required");
            }
            if (amount == null || amount.signum() <= 0) {
                throw new IllegalArgumentException("Order amount must be greater than zero: " + amount);
            }
        }
    }

    // Fraud report built step by step (Builder pattern), score 0 to 5
    static final class FraudReport {
        private final int score;
        private final List<String> passedChecks;

        private FraudReport(Builder builder) {
            this.score = builder.passedChecks.size();
            this.passedChecks = List.copyOf(builder.passedChecks);
        }

        int score() { return score; }
        List<String> passedChecks() { return passedChecks; }

        static class Builder {
            private final List<String> passedChecks = new ArrayList<>();

            // Each passed check adds one point
            Builder passed(String check) {
                if (passedChecks.size() < 5) {
                    passedChecks.add(check);
                }
                return this;
            }

            FraudReport build() {
                return new FraudReport(this);
            }
        }
    }

    // The strategy: every rail answers the same three questions
    interface PaymentRailStrategy {
        boolean supports(Order order, FraudReport report);
        String railName();
        int riskLevel(); // lower is safer
    }

    static class WalletRail implements PaymentRailStrategy {
        public boolean supports(Order order, FraudReport report) {
            return order.amount().compareTo(new BigDecimal("500")) <= 0; // up to R500
        }
        public String railName() { return "WALLET"; }
        public int riskLevel() { return 2; }
    }

    static class CardRail implements PaymentRailStrategy {
        public boolean supports(Order order, FraudReport report) {
            BigDecimal amount = order.amount();
            boolean inBand = amount.compareTo(new BigDecimal("500")) > 0
                    && amount.compareTo(new BigDecimal("10000")) <= 0; // R500 to R10,000
            return inBand && report.score() >= 2; // needs card details and identity
        }
        public String railName() { return "CARD"; }
        public int riskLevel() { return 3; }
    }

    static class EftRail implements PaymentRailStrategy {
        public boolean supports(Order order, FraudReport report) {
            BigDecimal amount = order.amount();
            return amount.compareTo(new BigDecimal("500")) > 0
                    && amount.compareTo(new BigDecimal("100000")) <= 0; // R500 to R100,000
        }
        public String railName() { return "EFT"; }
        public int riskLevel() { return 1; }
    }

    static class RtgsRail implements PaymentRailStrategy {
        public boolean supports(Order order, FraudReport report) {
            boolean bigAmount = order.amount().compareTo(new BigDecimal("100000")) > 0; // over R100,000
            return bigAmount && report.score() >= 4; // high value needs a strong fraud score
        }
        public String railName() { return "RTGS"; }
        public int riskLevel() { return 1; }
    }

    // Why a rail was chosen, so every decision can be traced
    record RoutingDecision(String orderId, String rail, String reason) {}

    // The context: holds the strategies and picks one
    static class PaymentRailSelector {
        private final List<PaymentRailStrategy> strategies;

        PaymentRailSelector(List<PaymentRailStrategy> strategies) {
            this.strategies = List.copyOf(strategies); // list order = priority
        }

        // Hilbert's demo: first rail that supports the order wins
        RoutingDecision firstMatch(Order order, FraudReport report) {
            for (PaymentRailStrategy rail : strategies) {
                if (rail.supports(order, report)) {
                    return new RoutingDecision(order.id(), rail.railName(),
                            "first rail in priority order that supports R" + order.amount());
                }
            }
            return new RoutingDecision(order.id(), "NONE", "no rail supports R" + order.amount()
                    + " with fraud score " + report.score());
        }

        // His suggested upgrade: check every rail, keep the lowest risk
        RoutingDecision lowestRisk(Order order, FraudReport report) {
            PaymentRailStrategy best = null;
            for (PaymentRailStrategy rail : strategies) {
                if (rail.supports(order, report)) {
                    if (best == null || rail.riskLevel() < best.riskLevel()) {
                        best = rail;
                    }
                }
            }
            if (best == null) {
                return new RoutingDecision(order.id(), "NONE", "no rail supports R" + order.amount()
                        + " with fraud score " + report.score());
            }
            return new RoutingDecision(order.id(), best.railName(),
                    "lowest risk (" + best.riskLevel() + ") of the rails that support R" + order.amount());
        }
    }

    public static void main(String[] args) {
        PaymentRailSelector selector = new PaymentRailSelector(List.of(
                new WalletRail(), new CardRail(), new EftRail(), new RtgsRail()));

        FraudReport verified = new FraudReport.Builder()
                .passed("identity confirmed")
                .passed("card details provided")
                .passed("address confirmed")
                .passed("device recognised")
                .build();
        FraudReport unverified = new FraudReport.Builder().build(); // score 0

        List<Order> orders = List.of(
                new Order("ORD-1", new BigDecimal("250")),
                new Order("ORD-2", new BigDecimal("1200")),
                new Order("ORD-3", new BigDecimal("25000")),
                new Order("ORD-4", new BigDecimal("250000")));

        for (Order order : orders) {
            System.out.println("First match: " + selector.firstMatch(order, verified));
            System.out.println("Lowest risk: " + selector.lowestRisk(order, verified));
        }

        // Same R250,000 order, but nobody proved who they are
        System.out.println("Unverified:  " + selector.firstMatch(orders.get(3), unverified));

        // A bad order is stopped before any routing happens
        try {
            new Order("ORD-5", BigDecimal.ZERO);
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected:    " + e.getMessage());
        }
    }
}