public class LeaveTrackingDemo {
    public static void main(String[] args) {
        // parameterized constructor
        Employee thabo = new Employee(101, "Thabo Nkosi", "Engineering", "thabo@company.com");

        // default constructor, filled in with placeholder values
        Employee newHire = new Employee();

        // a leave request, with a reason, status auto-set to Pending
        LeaveRequest request1 = new LeaveRequest(1, thabo, "2026-10-05", "2026-10-09", "Family holiday");
        request1.displayInfo();

        // overloaded constructor, no reason given
        LeaveRequest request2 = new LeaveRequest(2, thabo, "2026-11-01", "2026-11-01");
        request2.displayInfo();

        // calculate remaining leave after a 5-day request
        int remaining = thabo.calculateRemainingLeave(5);
        System.out.println(thabo.getName() + " would have " + remaining + " days left");

        // try to set an invalid balance, setter rejects it
        thabo.setLeaveBalance(-3);
        System.out.println(thabo.getName() + "'s balance is still " + thabo.getLeaveBalance());

    }
}