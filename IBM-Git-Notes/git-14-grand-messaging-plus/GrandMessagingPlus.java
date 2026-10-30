public class GrandMessagingPlus {

    // the original Grand Messaging feature
    static String send(String text) {
        return "Sent: " + text;
    }

    // new Plus feature we add on our branch
    static String sendScheduled(String text, String time) {
        return "Scheduled for " + time + ": " + text;
    }

    public static void main(String[] args) {
        System.out.println(send("Hello team"));
        System.out.println(sendScheduled("Stand-up notes", "09:00"));
    }
}