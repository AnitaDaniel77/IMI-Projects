// Dependency Inversion Principle: high-level code should depend on an abstraction, not a concrete class
public class SolidDIP {
    public static void main(String[] args) {
        // BEFORE - locked to one sender
        RigidNotifier rigid = new RigidNotifier();
        rigid.notifyUser("Welcome!");

        // AFTER - depends on an abstraction, the sender is handed in from outside
        FlexibleNotifier notifier = new FlexibleNotifier(new EmailSender());
        notifier.notifyUser("Welcome!");
    }
}

class EmailSenderOnly {
    void send(String message) {
        System.out.println("[email] " + message);
    }
}

class RigidNotifier {
    private final EmailSenderOnly email = new EmailSenderOnly();

    void notifyUser(String message) {
        email.send(message);
    }
}

interface MessageSender {
    void send(String message);
}

class EmailSender implements MessageSender {
    public void send(String message) {
        System.out.println("[email] " + message);
    }
}

class FlexibleNotifier {
    private final MessageSender sender;

    FlexibleNotifier(MessageSender sender) {
        this.sender = sender;
    }

    void notifyUser(String message) {
        sender.send(message);
    }
}