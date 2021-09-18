package duke.data.task;

import duke.data.exception.InvalidDateInputException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Deadline extends Task {

    protected LocalDate by;

    public Deadline(String description, String by) throws InvalidDateInputException {
        super(description);
        try {
            this.by = LocalDate.parse(by);
        } catch (DateTimeParseException e) {
            throw new InvalidDateInputException(by);
        }
    }

    public String getType() {
        return "D";
    }


    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + ")";
    }

    public String store() {
        return "D | " + (isDone ? 1 : 0) + " | " +
                super.getDescription() + " | " + by.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
    }

}
