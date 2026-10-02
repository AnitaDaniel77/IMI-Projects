import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Pattern;

public class DateParsingDemo {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // basic parsing
        LocalDate basicDate = LocalDate.parse("2030-02-21", formatter);
        System.out.println("Parsed date: " + basicDate);

        // different format
        DateTimeFormatter slashFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate slashDate = LocalDate.parse("21/02/2030", slashFormatter);
        System.out.println("Parsed slash date: " + slashDate);

        // extracting a date from a sentence
        String sentence = "The event is scheduled on 2030-02-21.";
        int startIndex = sentence.indexOf("on") + 3; // skip past "on "
        int endIndex = sentence.indexOf(".");
        String dateText = sentence.substring(startIndex, endIndex);
        try {
            LocalDate extracted = LocalDate.parse(dateText, formatter);
            System.out.println("Extracted from sentence: " + extracted);
        } catch (DateTimeParseException e) {
            System.out.println("Could not parse date from sentence");
        }

        // extracting multiple dates, split on comma or " and "
        String multiText = "2030-02-21, 2030-03-15 and 2030-04-10";
        String[] parts = multiText.split(",| and ");
        for (String part : parts) {
            String trimmed = part.trim();
            try {
                LocalDate date = LocalDate.parse(trimmed, formatter);
                System.out.println("Valid date: " + date);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date: " + trimmed);
            }
        }

        // extracting dates from mixed content using regex
        String mixedText = "Meet me on 2030-02-21 for lunch and again 2030-03-15 maybe";
        String[] words = mixedText.split(" ");
        Pattern datePattern = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");
        for (String word : words) {
            if (datePattern.matcher(word).matches()) {
                LocalDate date = LocalDate.parse(word, formatter);
                System.out.println("Found date in text: " + date);
            }
        }
    }
}