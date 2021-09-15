package duke.command;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

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
    public static final String FILE_PATH = "data";
    public static final String FILE_NAME = "data/duke.txt";

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
                    tasks.get(index - 1));
            System.out.println(line);
            changeToFile(tasks);
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
        System.out.println("  " + tasks.get(tasks.size() - 1));
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
        System.out.println(line);
        changeToFile(tasks);
    }

    public void delete(String input) throws OutOfRangeException {
        int index = Integer.parseInt(input.substring(input.indexOf(" ") + 1));

        if (index > tasks.size()) {
            throw new OutOfRangeException();
        } else {
            System.out.println(line);
            System.out.println("Noted. I've removed this task: \n" +
                    tasks.get(index - 1));
            tasks.remove(index - 1);
            System.out.println("Now you have " + tasks.size() + " tasks in the list.");
            System.out.println(line);
            changeToFile(tasks);
        }
    }

    public void loadFile() {
        try {
            File f = new File(FILE_NAME);
            if(!f.isFile()){
                throw new FileNotFoundException();
            }
            Scanner s = new Scanner(f);
            while (s.hasNext()) {
                loadCommands(s.nextLine());
            }
        }catch (FileNotFoundException e) {
            System.out.println("No previous data");
        }

    }

    public void loadCommands(String s) {
        String[] taskSplit = s.split(" \\| ");
        String taskType = taskSplit[0].trim();
        String completionStatus = taskSplit[1].trim();
        String task = taskSplit[2].trim();
        Task saved;
        switch (taskType) {
        case "T":
            saved = new ToDo(task);
            break;
        case "D":
            saved = new Deadline(task, taskSplit[3].trim());
            break;
        case "E":
            saved = new Event(task, taskSplit[3].trim());
            break;
        default:
            saved = null;
        }
        if (completionStatus.equals("1")) {
            saved.markAsDone();
        }
        tasks.add(saved);
    }




    private static void changeToFile(ArrayList<Task> tasks) {
        try {
            File f = new File(FILE_NAME);
            File dir = new File(FILE_PATH);
            if (!dir.exists()) {
                boolean isCreated = dir.mkdirs();
                if (!isCreated) {
                    System.out.println("h");
                    throw new IOException();
                }
            }
            if (!f.isFile()) {
                boolean isCreated = f.createNewFile();
                if (!isCreated) {
                    System.out.println("hh");
                    throw new IOException();
                }
            }

            FileWriter fw = new FileWriter(f);
            for (int i = 0; i < tasks.size(); i++) {
                fw.write(tasks.get(i).store());
                fw.write("\r\n");
            }
            /*Iterator<Task> iter = tasks.iterator();
            while (iter.hasNext()) {
                System.out.println(iter.next());
                fw.write(iter.next().store());
                System.out.println("hhh");
            }*/
            fw.close();

        } catch (IOException e) {
            System.out.println("Something went wrong when storing local file");
        }
    }
}

