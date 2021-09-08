public class DoTask {
    private Task[] tasks = new Task[100];
    private int numOfTasks;
    private static String line = Duke.line;

    public DoTask() {
        numOfTasks = 0;
    }
    public  void printList() {
        if (numOfTasks == 0) {
            System.out.println("No task added yet!");
            return;
        }
        System.out.println(line + "\nHere are the tasks in your list:");
        for (int i = 0; i < numOfTasks; i++) {
            System.out.println((i + 1) + "." + tasks[i]);
        }
        System.out.println(line);
    }

    public void done(String input) {
        int index = Integer.parseInt(input.substring(input.indexOf(" ") + 1));
        System.out.println(line);
        if (index > numOfTasks) {
            System.out.println("Invalid task index");
        } else {
            tasks[index - 1].markAsDone();
            System.out.println("Nice! I've marked this task as done:\n["+tasks[index - 1].getType()+"][X] " + tasks[index - 1].getDescription());
        }
        System.out.println(line);
    }


    public void addTask(String input, String taskType) {

        System.out.println(line);
        String taskName;
        switch (taskType) {
        case "T":
            taskName = input.substring(input.indexOf("todo") + 5);
            tasks[numOfTasks] = new ToDo(taskName);
            break;
        case "E":
            taskName = input.substring(input.indexOf("event") + 6, input.indexOf("/") - 1);
            String at = input.substring(input.indexOf("at") + 3);
            tasks[numOfTasks] = new Event(taskName, at);
            break;
        case "D":
            taskName = input.substring(input.indexOf("deadline") + 9, input.indexOf("/") - 1);
            String by = input.substring(input.indexOf("by") + 3);
            tasks[numOfTasks] = new Deadline(taskName, by);
            break;
        default:
            System.out.println("Invalid  input!");
            System.out.println(line);
            return;
        }
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + tasks[numOfTasks]);
        System.out.println("Now you have " + (numOfTasks + 1) + "tasks in the list.");
        System.out.println(line);
        numOfTasks++;
    }
}
