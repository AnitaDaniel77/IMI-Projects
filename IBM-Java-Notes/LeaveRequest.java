public class LeaveRequest {
    private int requestId;
    private Employee employee;
    private String startDate;
    private String endDate;
    private String status; // "Pending", "Approved", "Denied"
    private String reason;

    // main constructor, status always starts as Pending, never passed in
    public LeaveRequest(int requestId, Employee employee, String startDate, String endDate, String reason) {
        this.requestId = requestId;
        this.employee = employee;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = "Pending";
        this.reason = reason;
    }

    // overloaded constructor, for when no reason is given
    public LeaveRequest(int requestId, Employee employee, String startDate, String endDate) {
        this(requestId, employee, startDate, endDate, "No reason provided");
    }

    // getters
    public int getRequestId() {
        return requestId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getStatus() {
        return status;
    }

    public String getReason() {
        return reason;
    }

    // setter, only status should change after creation
    public void setStatus(String status) {
        this.status = status;
    }

    void displayInfo() {
        System.out.println("Request #" + requestId + " for " + employee.getName()
                + ": " + startDate + " to " + endDate
                + " (" + status + ") - " + reason);
    }
}