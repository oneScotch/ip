package duke.exception;

public class InvalidInputException extends Exception {
    public InvalidInputException() {
        super("InvalidInputException");
    }

    public InvalidInputException(String message) {
        super(message);
    }
}
