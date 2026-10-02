import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class DateTimeDemo {
    public static void main(String[] args) {
        // LocalDate: just the calendar date, no time or timezone
        LocalDate today = LocalDate.now();
        System.out.println("Today's Date: " + today);

        // LocalTime: just the clock time, no date or timezone
        LocalTime now = LocalTime.now();
        System.out.println("Current Time: " + now);

        // LocalDateTime: date and time together, still no timezone
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println("Current Date and Time: " + dateTime);

        // ZonedDateTime: date, time, and timezone all together
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println("Current Date, Time, and Zone: " + zonedDateTime);
    }
}