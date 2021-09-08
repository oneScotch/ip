package duke.exception;

public class EmptyTaskException extends Exception {
    public EmptyTaskException() {
        super("EmptyTaskException");
    }

    public EmptyTaskException(String message) {
        super(message);
    }
}

