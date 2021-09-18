package duke.data.task;

import duke.data.exception.InvalidDateInputException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class Event extends Task {

    protected LocalDate at;

    public Event(String description, String at) throws InvalidDateInputException {
        super(description);
        try {
            this.at = LocalDate.parse(at);
        } catch (DateTimeParseException e) {
            throw new InvalidDateInputException(at);
        }
    }


    @Override
    public String getType() {
        return "E";
    }

    public String toString() {
        return "[E]" + super.toString() + " (at: " + at.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + ")";
    }

    public String store() {
        return "E | " + (isDone ? 1 : 0) + " | " +
                super.getDescription() + " | " + at.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
    }
}
