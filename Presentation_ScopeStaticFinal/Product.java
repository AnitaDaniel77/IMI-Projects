public class Product {
    // final: id and price are set once in the constructor
    // and can never be reassigned after that, real immutability
    private final String id;
    private final BigDecimal price;

    public Product(String id, BigDecimal price) {
        this.id = id;
        this.price = price;
    }
}