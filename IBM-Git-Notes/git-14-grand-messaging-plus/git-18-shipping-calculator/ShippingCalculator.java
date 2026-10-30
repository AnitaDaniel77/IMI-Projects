public class ShippingCalculator {

    // base fee plus a charge per kilogram and per kilometre
    static double cost(double weightKg, double distanceKm) {
        double base = 50.0;
        return base + (weightKg * 8.5) + (distanceKm * 1.2);
    }

    // one day for every 400 km, never less than one day
    static int estimateDays(double distanceKm) {
        return Math.max(1, (int) Math.ceil(distanceKm / 400.0));
    }

    public static void main(String[] args) {
        double weight = 12.5;
        double distance = 950;
        System.out.printf("Cost: R%.2f%n", cost(weight, distance));
        System.out.println("Delivery in " + estimateDays(distance) + " days");
    }
}