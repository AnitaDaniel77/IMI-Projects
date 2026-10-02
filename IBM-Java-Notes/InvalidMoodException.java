// thrown when a mood fails validation, like a duplicate date and time
public class InvalidMoodException extends Exception {
	public InvalidMoodException() {
		super("Mood on this date and time already exists.");
	}

	public InvalidMoodException(String message) {
		super(message);
	}
}