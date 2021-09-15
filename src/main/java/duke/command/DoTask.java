package duke.command;

import java.util.ArrayList;

import duke.exception.EmptyTaskException;
import duke.exception.MissingParaException;
import duke.exception.OutOfRangeException;
import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.ToDo;

public class DoTask {
    private ArrayList<Task> tasks;
    private static String line = Duke.line;

    public DoTask() {
        tasks = new ArrayList<>();
    }

    public void printList() {
        if (tasks.size() == 0) {
            System.out.println("No task added yet!");
            return;
        }
        System.out.println(line + "\nHere are the tasks in your list:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + "." + tasks.get(i));
        }
        System.out.println(line);
    }

    public void done(String input) throws OutOfRangeException {
        int index = Integer.parseInt(input.substring(input.indexOf(" ") + 1));

        if (index > tasks.size()) {
            throw new OutOfRangeException();
        } else {
            tasks.get(index - 1).markAsDone();
            System.out.println(line);
            System.out.println("Nice! I've marked this task as done:\n[" +
                    tasks.get(index - 1).getType() + "][X] " + tasks.get(index - 1).getDescription());
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
            tasks.add(new ToDo(taskName));
            break;
        case "E":
            if (!input.contains("/at")) {
                throw new MissingParaException();
            }
            taskName = input.substring(input.indexOf("event") + 6, input.indexOf("/") - 1);
            String at = input.substring(input.indexOf("at") + 3);
            tasks.add(new Event(taskName, at));
            break;
        case "D":
            if (!input.contains("/by")) {
                throw new MissingParaException();
            }
            taskName = input.substring(input.indexOf("deadline") + 9, input.indexOf("/") - 1);
            String by = input.substring(input.indexOf("by") + 3);
            tasks.add(new Deadline(taskName, by));
            break;
        default:
            System.out.println(line);
            System.out.println("Invalid  input!");
            System.out.println(line);
            return;
        }
        System.out.println(line);
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + tasks.get(tasks.size()-1));
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
        System.out.println(line);
    }

    public void delete(String input) throws OutOfRangeException {
        int index = Integer.parseInt(input.substring(input.indexOf(" ") + 1));

        if (index > tasks.size()) {
            throw new OutOfRangeException();
        } else {
            System.out.println(line);
            System.out.println("Noted. I've removed this task: \n[" +
                    tasks.get(index - 1).getType() + "][" + tasks.get(index - 1).getStatusIcon() + "] "
                    + tasks.get(index - 1).getDescription());
            tasks.remove(index - 1);
            System.out.println("Now you have " + tasks.size() + " tasks in the list.");
            System.out.println(line);
        }
    }
}

