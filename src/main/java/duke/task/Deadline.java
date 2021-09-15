package duke.task;

public class Deadline extends Task {

    protected String by;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    public String getType() {
        return "D";
    }


    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }

    public String store() {
        return "D | " + (isDone ? 1 : 0) + " | " +
                super.getDescription() + " | " + by;
    }

}
