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

}
