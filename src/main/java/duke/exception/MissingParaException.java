package duke.exception;

public class MissingParaException extends Exception {
    public MissingParaException() {
        super("InvalidInputException");
    }

    public MissingParaException(String message) {
        super(message);
    }
}
