package duke.exception;

public class OutOfRangeException extends Exception {
    public OutOfRangeException() {
        super("InvalidInputException");
    }

    public OutOfRangeException(String message) {
        super(message);
    }
}

