import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// A registered pet and the list of appointments booked for it.
public class Pet implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;                    // fixed once registered
    private String name;
    private String species;
    private int age;
    private String ownerName;
    private String contactInfo;
    private LocalDate registrationDate;   // fixed once registered
    private List<Appointment> appointments;

    public Pet(String id, String name, String species, int age, String ownerName, String contactInfo) {
        this.id = id;
        this.name = name;
        this.species = species;
        setAge(age); // age rule is checked in one place
        this.ownerName = ownerName;
        this.contactInfo = contactInfo;
        this.registrationDate = LocalDate.now(); // set automatically on registration
        this.appointments = new ArrayList<>();
    }

    // The only way to add an appointment to this pet
    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    // Read-only view so outside code can't edit the list directly
    public List<Appointment> getAppointments() {
        return Collections.unmodifiableList(appointments);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative.");
        }
        this.age = age;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Species: " + species
                + ", Age: " + age + ", Owner: " + ownerName
                + ", Contact: " + contactInfo + ", Registered: " + registrationDate;
    }
}