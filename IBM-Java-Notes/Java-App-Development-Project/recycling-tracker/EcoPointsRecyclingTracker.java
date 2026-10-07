// Main app for the Eco-Points Recycling Tracker, menu-driven console app
import java.io.*;
import java.util.*;
import java.time.LocalDate;

public class EcoPointsRecyclingTracker {
    private static Scanner scanner = new Scanner(System.in);

    // all households, keyed by household ID
    private static Map<String, Household> households = new HashMap<>();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("\n=== Eco-Points Recycling Tracker ===");
            System.out.println("1. Register Household");
            System.out.println("2. Log Recycling Event");
            System.out.println("3. Display Households");
            System.out.println("4. Display Household Recycling Events");
            System.out.println("5. Generate Reports");
            System.out.println("6. Save and Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            // You will handle the choice entered here using switch(case)
        }
    }

    // Add the methods to handle each choice here
}