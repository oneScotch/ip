package duke.task;

public abstract class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public void markAsDone(){
        isDone = true;
    }
    public abstract String getType();
    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    public String getDescription() {
        return description;
    }

    public abstract String store();

    public String toString() {
        return "[" + getStatusIcon() + "] " + getDescription();
    }
}
