import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class TimeZoneSchedulerDemo {
    public static void main(String[] args) {
        // the meeting time, fixed in UTC, this is the single source of truth
        ZonedDateTime meetingTimeUTC = ZonedDateTime.parse("2026-10-06T14:00:00Z");

        // participants' time zones
        String[] participantZones = {
            "America/New_York",
            "Europe/London",
            "Asia/Kolkata",
            "Australia/Sydney"
        };

        // format: date, time, and timezone abbreviation
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");

        System.out.println("Meeting time (UTC): " + meetingTimeUTC.format(formatter));

        for (String zoneName : participantZones) {
            ZoneId zone = ZoneId.of(zoneName);
            // same exact instant, just viewed from a different zone
            ZonedDateTime localTime = meetingTimeUTC.withZoneSameInstant(zone);
            System.out.println(zoneName + ": " + localTime.format(formatter));
        }
    }
}