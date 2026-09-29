import java.time.LocalDateTime;
import java.util.UUID;

public class Task {
    // final: id and createdAt are locked in at creation,
    // nothing later in the app can edit when or what a task was
    private final String taskId;
    private final LocalDateTime createdAt;

    public Task(String description) {
        this.taskId = UUID.randomUUID().toString();
        this.createdAt = LocalDateTime.now();
    }
}