import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.*;

// Console app for registering pets, booking appointments and viewing reports.
public class PetCareScheduler {
    private static Scanner scanner = new Scanner(System.in);        // one shared reader for all input
    private static Map<String, Pet> pets = new HashMap<>();         // pets by ID, each holds its own appointments

    // Only these appointment types are accepted
    private static final List<String> APPOINTMENT_TYPES = Arrays.asList("vet visit", "vaccination", "grooming");
    private static final String VET_VISIT = "vet visit";

    // Strict mode rejects impossible dates like 30 February
    private static final DateTimeFormatter INPUT_FORMAT =
            DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm").withResolverStyle(ResolverStyle.STRICT);

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
                        // only leave if the save worked, so nothing is lost
                        if (saveData()) {
                            running = false;
                            System.out.println("Goodbye!");
                        }
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

    // Keeps asking until the user types something that isn't blank
    private static String readRequired(String prompt) {
        while (true) {
            System.out.print(prompt);
            String value = scanner.nextLine().trim();
            if (!value.isEmpty()) {
                return value;
            }
            System.out.println("This cannot be empty.");
        }
    }

    // Pets in ID order so the output is the same every run
    private static List<Pet> sortedPets() {
        List<Pet> list = new ArrayList<>(pets.values());
        list.sort(Comparator.comparing(Pet::getId));
        return list;
    }

    // A pet's appointments in date order
    private static List<Appointment> sortedAppointments(Pet pet) {
        List<Appointment> list = new ArrayList<>(pet.getAppointments());
        list.sort(Comparator.comparing(Appointment::getDateTime));
        return list;
    }

    // Lab step 1: register a new pet and add it to the map
    private static void registerPet() {
        String id = readRequired("Enter pet ID: ");

        // stop early if the ID is already taken
        if (pets.containsKey(id)) {
            System.out.println("Error: Pet ID already exists.");
            return;
        }

        String name = readRequired("Enter pet name: ");
        String species = readRequired("Enter species/breed: ");

        int age = 0;
        while (true) {
            try {
                System.out.print("Enter age in years: ");
                age = Integer.parseInt(scanner.nextLine().trim());
                if (age < 0) throw new IllegalArgumentException();
                break; // valid age, leave the loop
            } catch (IllegalArgumentException e) {
                // also catches NumberFormatException, which is a subclass
                System.out.println("Invalid age. Must be a whole number, 0 or more.");
            }
        }

        String ownerName = readRequired("Enter owner name: ");
        String contactInfo = readRequired("Enter contact info: ");

        Pet pet = new Pet(id, name, species, age, ownerName, contactInfo);
        pets.put(id, pet);

        // registration date was set automatically by the Pet constructor
        System.out.println("Pet registered successfully on " + pet.getRegistrationDate());
    }

    // Lab step 2: add an appointment to an existing pet
    private static void scheduleAppointment() {
        String id = readRequired("Enter pet ID: ");
        Pet pet = pets.get(id);

        // appointments can only be set for pets that exist
        if (pet == null) {
            System.out.println("Error: Pet ID not found.");
            return;
        }

        // keep asking until the type is one we allow
        String type = "";
        while (true) {
            System.out.print("Enter appointment type (vet visit/vaccination/grooming): ");
            type = scanner.nextLine().trim().toLowerCase();
            if (APPOINTMENT_TYPES.contains(type)) {
                break;
            }
            System.out.println("Invalid type. Choose vet visit, vaccination or grooming.");
        }

        // keep asking until the date parses and is in the future
        LocalDateTime dateTime = null;
        while (true) {
            System.out.print("Enter date and time (yyyy-MM-dd HH:mm): ");
            try {
                dateTime = LocalDateTime.parse(scanner.nextLine().trim(), INPUT_FORMAT);
                if (dateTime.isAfter(LocalDateTime.now())) {
                    break;
                }
                System.out.println("The appointment must be in the future.");
            } catch (DateTimeParseException e) {
                System.out.println("Invalid format. Use yyyy-MM-dd HH:mm, for example 2026-11-14 09:30.");
            }
        }

        System.out.print("Enter notes (optional, press Enter to skip): ");
        String notes = scanner.nextLine().trim();

        Appointment appointment = new Appointment(type, dateTime, notes);
        pet.addAppointment(appointment);
        System.out.println("Appointment scheduled for " + pet.getName() + ": " + appointment);
    }

    // Lab step 3: write all pets (and their appointments) to a file
    private static boolean saveData() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("pets.ser"))) {
            out.writeObject(pets);
            System.out.println("Data saved.");
            return true;
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
            return false;
        }
    }

    // Lab step 4a: show every registered pet
    private static void displayPets() {
        if (pets.isEmpty()) {
            System.out.println("No pets registered.");
            return;
        }
        System.out.println("\nRegistered Pets:");
        for (Pet pet : sortedPets()) {
            System.out.println(pet);
        }
    }

    // Lab step 4b: show all appointments for one pet
    private static void displayPetAppointments() {
        String id = readRequired("Enter pet ID: ");
        Pet pet = pets.get(id);

        if (pet == null) {
            System.out.println("Error: Pet ID not found.");
            return;
        }

        System.out.println("\nAppointments for " + pet.getName() + ":");
        List<Appointment> list = sortedAppointments(pet);
        if (list.isEmpty()) {
            System.out.println("No appointments scheduled.");
            return;
        }
        int number = 1;
        for (Appointment appointment : list) {
            System.out.println(number + ". " + appointment);
            number++;
        }
    }

    // Lab step 4c: show appointments still to come, for all pets
    private static void displayUpcomingAppointments() {
        LocalDateTime now = LocalDateTime.now();
        boolean found = false;

        System.out.println("\nUpcoming Appointments:");
        for (Pet pet : sortedPets()) {
            for (Appointment appointment : sortedAppointments(pet)) {
                if (appointment.getDateTime().isAfter(now)) {
                    System.out.println(pet.getName() + " (ID: " + pet.getId() + "): " + appointment);
                    found = true;
                }
            }
        }
        if (!found) {
            System.out.println("No upcoming appointments.");
        }
    }

    // Lab step 4d: show appointments already past, for each pet
    private static void displayAppointmentHistory() {
        if (pets.isEmpty()) {
            System.out.println("No pets registered.");
            return;
        }

        LocalDateTime now = LocalDateTime.now();
        System.out.println("\nAppointment History:");
        for (Pet pet : sortedPets()) {
            System.out.println(pet.getName() + " (ID: " + pet.getId() + "):");
            boolean found = false;
            for (Appointment appointment : sortedAppointments(pet)) {
                if (appointment.getDateTime().isBefore(now)) {
                    System.out.println("  " + appointment);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("  No past appointments.");
            }
        }
    }

    // Lab step 5: next-week appointments and pets overdue for a vet visit
    private static void generateReports() {
        if (pets.isEmpty()) {
            System.out.println("No pets registered.");
            return;
        }

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime nextWeek = now.plusDays(7);
        LocalDateTime sixMonthsAgo = now.minusMonths(6);

        // report 1: anything booked in the next 7 days
        System.out.println("\n--- Appointments in the next 7 days ---");
        boolean anyUpcoming = false;
        for (Pet pet : sortedPets()) {
            for (Appointment appointment : sortedAppointments(pet)) {
                LocalDateTime when = appointment.getDateTime();
                if (when.isAfter(now) && !when.isAfter(nextWeek)) {
                    System.out.println(pet.getName() + " (ID: " + pet.getId() + "): " + appointment);
                    anyUpcoming = true;
                }
            }
        }
        if (!anyUpcoming) {
            System.out.println("None.");
        }

        // report 2: no vet visit in the last 6 months
        System.out.println("\n--- Pets overdue for a vet visit (none in the last 6 months) ---");
        boolean anyOverdue = false;
        for (Pet pet : sortedPets()) {
            LocalDateTime lastVisit = null; // most recent past vet visit
            for (Appointment appointment : pet.getAppointments()) {
                LocalDateTime when = appointment.getDateTime();
                if (appointment.getType().equals(VET_VISIT) && when.isBefore(now)
                        && (lastVisit == null || when.isAfter(lastVisit))) {
                    lastVisit = when;
                }
            }
            if (lastVisit == null || lastVisit.isBefore(sixMonthsAgo)) {
                String detail = (lastVisit == null) ? "no vet visit on record" : "last visit " + lastVisit.toLocalDate();
                System.out.println(pet.getName() + " (ID: " + pet.getId() + "): " + detail);
                anyOverdue = true;
            }
        }
        if (!anyOverdue) {
            System.out.println("None.");
        }
    }
}