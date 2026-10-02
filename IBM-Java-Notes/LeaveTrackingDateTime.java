import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

public class LeaveTrackingDateTime {

    // leave request with start/end dates, a creation timestamp, and duration logic
    static class LeaveRequest {
        int requestId;
        LocalDate startDate;
        LocalDate endDate;
        String status;
        LocalDateTime createdAt;
        ZonedDateTime approvalTimestamp;

        LeaveRequest(int requestId, LocalDate startDate, LocalDate endDate) {
            this.requestId = requestId;
            this.startDate = startDate;
            this.endDate = endDate;
            this.status = "Pending";
            this.createdAt = LocalDateTime.now(); // captured the instant the request was made
        }

        int getLeaveDuration() {
            return Period.between(startDate, endDate).getDays() + 1; // inclusive of both ends
        }

        String getCreationTimestamp() {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            return createdAt.format(formatter);
        }

        void approve() {
            this.status = "Approved";
            this.approvalTimestamp = ZonedDateTime.now(ZoneId.of("UTC")); // stored in UTC
        }
    }

    // formats the same LocalDate differently depending on where it's shown
    static String formatForDisplay(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy");
        return date.format(formatter);
    }

    static String formatForStorage(LocalDate date) {
        return date.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    static String formatForReport(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return date.format(formatter);
    }

    // converts a stored UTC approval time into the requested time zone
    static String getLocalApprovalTime(LeaveRequest request, String timeZone) {
        ZonedDateTime localTime = request.approvalTimestamp.withZoneSameInstant(ZoneId.of(timeZone));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");
        return localTime.format(formatter);
    }

    // counts weekdays only, skipping Saturday and Sunday
    static int calculateBusinessDays(LocalDate startDate, LocalDate endDate) {
        int businessDays = 0;
        LocalDate currentDate = startDate;
        while (!currentDate.isAfter(endDate)) {
            if (currentDate.getDayOfWeek().getValue() < 6) { // 1-5 is Mon-Fri
                businessDays++;
            }
            currentDate = currentDate.plusDays(1);
        }
        return businessDays;
    }

    static long daysUntilExpiration(LocalDate leaveDate, int expirationDays) {
        LocalDate expirationDate = leaveDate.plusDays(expirationDays);
        return ChronoUnit.DAYS.between(LocalDate.now(), expirationDate);
    }

    // tries a single expected format, reports a friendly error if it fails
    static LocalDate parseInputDate(String dateString) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            return LocalDate.parse(dateString, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please use MM/DD/YYYY.");
            return null;
        }
    }

    // tries several known formats before giving up, for messier CSV input
    static LocalDate parseFromCsv(String dateString) {
        String[] formats = {"yyyy-MM-dd", "MM/dd/yyyy", "dd-MM-yyyy"};
        for (String format : formats) {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
                return LocalDate.parse(dateString, formatter);
            } catch (DateTimeParseException e) {
                // try the next format
            }
        }
        System.out.println("Error parsing date: " + dateString);
        return null;
    }

    public static void main(String[] args) {
        LeaveRequest request = new LeaveRequest(1, LocalDate.of(2026, 10, 5), LocalDate.of(2026, 10, 9));
        System.out.println("Leave duration: " + request.getLeaveDuration() + " days");
        System.out.println("Created at: " + request.getCreationTimestamp());

        System.out.println("Display format: " + formatForDisplay(request.startDate));
        System.out.println("Storage format: " + formatForStorage(request.startDate));
        System.out.println("Report format: " + formatForReport(request.startDate));

        request.approve();
        System.out.println("Approval (Johannesburg): " + getLocalApprovalTime(request, "Africa/Johannesburg"));
        System.out.println("Approval (London): " + getLocalApprovalTime(request, "Europe/London"));

        int businessDays = calculateBusinessDays(request.startDate, request.endDate);
        System.out.println("Business days taken: " + businessDays);

        long daysLeft = daysUntilExpiration(LocalDate.of(2026, 1, 1), 365);
        System.out.println("Days until leave expires: " + daysLeft);

        LocalDate parsed = parseInputDate("10/05/2026");
        System.out.println("Parsed input date: " + parsed);

        LocalDate csvDate = parseFromCsv("2026-10-05");
        System.out.println("Parsed CSV date: " + csvDate);
    }
}