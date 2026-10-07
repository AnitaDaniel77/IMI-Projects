import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// One booking for a pet: what it is, when it is, and any notes.
public class Appointment implements Serializable {
    private static final long serialVersionUID = 1L;

    private String type;            // vet visit, vaccination, grooming
    private LocalDateTime dateTime; // date and time together
    private String notes;           // optional

    public Appointment(String type, LocalDateTime dateTime, String notes) {
        this.type = type;
        this.dateTime = dateTime;
        this.notes = notes;
    }

    // Notes are optional, so this one defaults them to empty
    public Appointment(String type, LocalDateTime dateTime) {
        this(type, dateTime, "");
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String text = type + " on " + dateTime.format(formatter);
        if (notes != null && !notes.isEmpty()) {
            text += " (" + notes + ")";
        }
        return text;
    }
}