package duke.command;

import duke.exception.EmptyTaskException;
import duke.exception.MissingParaException;
import duke.exception.OutOfRangeException;
import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.ToDo;

public class DoTask {
    private Task[] tasks = new Task[100];
    private int numOfTasks;
    private static String line = Duke.line;

    public DoTask() {
        numOfTasks = 0;
    }

    public void printList() {
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

    public void done(String input) throws OutOfRangeException {
        int index = Integer.parseInt(input.substring(input.indexOf(" ") + 1));

        if (index > numOfTasks) {
            throw new OutOfRangeException();
        } else {
            tasks[index - 1].markAsDone();
            System.out.println(line);
            System.out.println("Nice! I've marked this task as done:\n[" +
                    tasks[index - 1].getType() + "][X] " + tasks[index - 1].getDescription());
            System.out.println(line);
        }
    }


    public void addTask(String input, String taskType) throws MissingParaException, EmptyTaskException {

        if (input.toLowerCase().split(" ").length < 2) {
            throw new EmptyTaskException();
        }
        String taskName;
        switch (taskType) {
        case "T":
            taskName = input.substring(input.indexOf("todo") + 5);
            tasks[numOfTasks] = new ToDo(taskName);
            break;
        case "E":
            if (!input.contains("/at")) {
                throw new MissingParaException();
            }
            taskName = input.substring(input.indexOf("event") + 6, input.indexOf("/") - 1);
            String at = input.substring(input.indexOf("at") + 3);
            tasks[numOfTasks] = new Event(taskName, at);
            break;
        case "D":
            if (!input.contains("/by")) {
                throw new MissingParaException();
            }
            taskName = input.substring(input.indexOf("deadline") + 9, input.indexOf("/") - 1);
            String by = input.substring(input.indexOf("by") + 3);
            tasks[numOfTasks] = new Deadline(taskName, by);
            break;
        default:
            System.out.println(line);
            System.out.println("Invalid  input!");
            System.out.println(line);
            return;
        }
        System.out.println(line);
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + tasks[numOfTasks]);
        System.out.println("Now you have " + (numOfTasks + 1) + "tasks in the list.");
        System.out.println(line);
        numOfTasks++;
    }
}

