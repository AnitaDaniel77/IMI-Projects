import java.io.*;
import java.util.*;

// Console app for registering pets, booking appointments and viewing reports.
public class PetCareScheduler {
    private static Scanner scanner = new Scanner(System.in);        // one shared reader for all input
    private static Map<String, Pet> pets = new HashMap<>();         // pets by ID, each holds its own appointments

    public static void main(String[] args) {
        loadData(); // bring back anything saved last time
        boolean running = true;

        while (running) {
            System.out.println("\n=== PetCare Scheduler ===");
            System.out.println("1. Register a Pet");
            System.out.println("2. Schedule an Appointment");
            System.out.println("3. Display All Pets");
            System.out.println("4. Display Appointments for a Pet");
            System.out.println("5. Display Upcoming Appointments");
            System.out.println("6. Display Appointment History");
            System.out.println("7. Generate Reports");
            System.out.println("8. Save Data");
            System.out.println("9. Save and Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine().trim();

            try {
                switch (choice) {
                    case "1":
                        registerPet();
                        break;
                    case "2":
                        scheduleAppointment();
                        break;
                    case "3":
                        displayPets();
                        break;
                    case "4":
                        displayPetAppointments();
                        break;
                    case "5":
                        displayUpcomingAppointments();
                        break;
                    case "6":
                        displayAppointmentHistory();
                        break;
                    case "7":
                        generateReports();
                        break;
                    case "8":
                        saveData();
                        break;
                    case "9":
                        saveData();
                        running = false;
                        System.out.println("Data saved. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please select 1-9.");
                }
            } catch (Exception e) {
                // keeps one bad action from closing the whole app
                System.out.println("Something went wrong: " + e.getMessage());
            }
        }
    }

    // Reads saved pets from file when the app starts
    @SuppressWarnings("unchecked")
    private static void loadData() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("pets.ser"))) {
            pets = (Map<String, Pet>) in.readObject();
            System.out.println("Data loaded.");
        } catch (FileNotFoundException e) {
            // first run, nothing saved yet
            System.out.println("No saved data found. Starting fresh.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }

    // Handlers below are filled in during Task 3
    private static void registerPet() {
        System.out.println("Register a pet is coming in Task 3.");
    }

    private static void scheduleAppointment() {
        System.out.println("Schedule an appointment is coming in Task 3.");
    }

    private static void displayPets() {
        System.out.println("Display pets is coming in Task 3.");
    }

    private static void displayPetAppointments() {
        System.out.println("Display pet appointments is coming in Task 3.");
    }

    private static void displayUpcomingAppointments() {
        System.out.println("Display upcoming appointments is coming in Task 3.");
    }

    private static void displayAppointmentHistory() {
        System.out.println("Display appointment history is coming in Task 3.");
    }

    private static void generateReports() {
        System.out.println("Generate reports is coming in Task 3.");
    }

    private static void saveData() {
        System.out.println("Save data is coming in Task 3.");
    }
}