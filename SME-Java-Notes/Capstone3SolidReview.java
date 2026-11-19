// SME 19 Nov: Capstone 3 review, SOLID applied to payment rails
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

// The contract every rail signs (brief says interface, not abstract class)
interface PaymentMethod {
    boolean processPayment(double amount);
    String getPaymentType();
}

// Small extra interfaces: only rails that can do it sign them (Interface Segregation)
interface Refundable {
    boolean refund(double amount);
}

interface TapToPay {
    boolean tap(double amount);
}

// Shared steps written once; rails can't skip the amount check (Open/Closed)
abstract class BasePaymentMethod implements PaymentMethod {

    @Override
    public final boolean processPayment(double amount) {
        if (!isValidAmount(amount)) {
            System.out.println("Rejected: amount must be greater than R0");
            return false;
        }
        return doProcess(amount); // each rail's own rule
    }

    // Shared check lives here only, not repeated in every rail
    protected boolean isValidAmount(double amount) {
        return amount > 0;
    }

    protected abstract boolean doProcess(double amount);
}

// Card rule: limit per payment
class CardPayment extends BasePaymentMethod implements Refundable, TapToPay {

    private final double limitPerPayment;

    public CardPayment(double limitPerPayment) {
        this.limitPerPayment = limitPerPayment;
    }

    @Override
    protected boolean doProcess(double amount) {
        if (amount > limitPerPayment) {
            System.out.println("Declined: over the card limit of R" + limitPerPayment);
            return false; // decline is a normal answer, not an exception
        }
        System.out.println("CARD paid R" + amount);
        return true;
    }

    @Override
    public String getPaymentType() {
        return "CARD";
    }

    @Override
    public boolean refund(double amount) {
        System.out.println("CARD refunded R" + amount);
        return true;
    }

    @Override
    public boolean tap(double amount) {
        return processPayment(amount); // tap still goes through the shared checks
    }
}

// EFT rule: needs a bank reference
class EftPayment extends BasePaymentMethod {

    private final String bankReference;

    public EftPayment(String bankReference) {
        this.bankReference = bankReference;
    }

    @Override
    protected boolean doProcess(double amount) {
        if (bankReference == null || bankReference.isBlank()) {
            System.out.println("Declined: EFT needs a bank reference");
            return false;
        }
        System.out.println("EFT paid R" + amount + " ref " + bankReference);
        return true;
    }

    @Override
    public String getPaymentType() {
        return "EFT";
    }
}

// Wallet rule: can't spend more than the balance
class WalletPayment extends BasePaymentMethod {

    private BigDecimal balance; // BigDecimal so cents don't drift

    public WalletPayment(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    protected boolean doProcess(double amount) {
        BigDecimal charge = BigDecimal.valueOf(amount);
        if (charge.compareTo(balance) > 0) {
            System.out.println("Declined: more than the balance");
            return false; // balance untouched
        }
        balance = balance.subtract(charge);
        System.out.println("WALLET paid R" + amount + ", balance left R" + balance);
        return true;
    }

    @Override
    public String getPaymentType() {
        return "WALLET";
    }
}

// The brief's test: a new rail is one new class, nothing else changes
class BuyNowPayLaterPayment extends BasePaymentMethod {

    private final double creditLimit;

    public BuyNowPayLaterPayment(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    @Override
    protected boolean doProcess(double amount) {
        if (amount > creditLimit) {
            System.out.println("Declined: over the BNPL credit limit");
            return false;
        }
        System.out.println("BNPL approved R" + amount);
        return true;
    }

    @Override
    public String getPaymentType() {
        return "BNPL";
    }
}

// Value object: no id, can't change, equal when the values match
final class Money {

    private final BigDecimal amount;
    private final String currency;

    public Money(BigDecimal amount, String currency) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Amount can't be empty or negative");
        }
        if (currency == null || currency.length() != 3) {
            throw new IllegalArgumentException("Currency must be a 3-letter code like ZAR");
        }
        this.amount = amount;
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Money)) {
            return false;
        }
        Money that = (Money) other;
        return amount.compareTo(that.amount) == 0 && currency.equals(that.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount.stripTrailingZeros(), currency);
    }

    @Override
    public String toString() {
        return currency + " " + amount;
    }
}

// Entity base: things with an id share this (to be expanded later)
abstract class Entity {

    private final int id;

    protected Entity(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

class Product extends Entity {

    private final String name;
    private final Money price;

    public Product(int id, String name, Money price) {
        super(id);
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Money getPrice() {
        return price;
    }
}

// Simple stand-in for a DI container: hands back the rail the user picked
class PaymentResolver {

    private final Map<String, PaymentMethod> rails = new HashMap<>();

    public void register(PaymentMethod method) {
        rails.put(method.getPaymentType(), method);
    }

    // Returns null instead of crashing, so the app keeps running
    public PaymentMethod resolve(String selection) {
        PaymentMethod method = rails.get(selection);
        if (method == null) {
            System.out.println("Failed to resolve payment rail: " + selection);
        }
        return method;
    }
}

// Checkout only knows the interface (Dependency Inversion)
class PaymentProcessor {

    public void checkout(PaymentMethod method, double total) {
        if (method == null) {
            System.out.println("Checkout stopped: no payment rail");
            return;
        }
        boolean paid = method.processPayment(total);
        if (paid) {
            System.out.println(method.getPaymentType() + " R" + total + " - order complete");
        } else {
            System.out.println(method.getPaymentType() + " R" + total + " - payment failed, order not complete");
        }
    }
}

public class Capstone3SolidReview {

    public static void main(String[] args) {
        // Wiring happens in one place; checkout never says "new CardPayment()"
        PaymentResolver resolver = new PaymentResolver();
        resolver.register(new CardPayment(5000));
        resolver.register(new EftPayment("INV-1042"));
        resolver.register(new WalletPayment(new BigDecimal("300.00")));
        resolver.register(new BuyNowPayLaterPayment(2000));

        PaymentProcessor processor = new PaymentProcessor();
        double total = 400.00; // worked out once, from the order lines

        processor.checkout(resolver.resolve("CARD"), total);
        processor.checkout(resolver.resolve("WALLET"), total); // declined, balance too low
        processor.checkout(resolver.resolve("BNPL"), total);
        processor.checkout(resolver.resolve("CRYPTO"), total); // not registered

        Money a = new Money(new BigDecimal("10.0"), "ZAR");
        Money b = new Money(new BigDecimal("10.00"), "ZAR");
        System.out.println("Same money? " + a.equals(b)); // true, values match
    }
}