package duke.data.task;

public class ToDo extends Task {

    public ToDo(String description) {
        super(description);
    }

    public String getType() {
        return "T";
    }

    public String toString() {
        return "[T]" + super.toString() ;
    }

    @Override
    public String store() {return "T | " +(isDone ? 1 : 0) +" | "+
            super.getDescription();}

}
