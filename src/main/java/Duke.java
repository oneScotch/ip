import java.util.Scanner;


public class Duke {
    private static Task[] tasks = new Task[100];
    private static int numOfTasks = 0;
    public static String line = "____________________________________________________________";

    public static void greet() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        System.out.println(line + "\nHello! I'm Duke\nWhat can I do for you?\n" + line);
    }

    public static void exit() {
        System.out.println("Bye. Hope to see you again soon!\n" + line);
    }

    public static void printList() {
        System.out.println(line + "\nHere are the tasks in your list:");
        for (int i = 0; i < numOfTasks; i++) {
            System.out.println((i + 1) + "." + tasks[i]);
        }
        System.out.println(line);
    }

    public static void doTask(int index) {
        System.out.println(line);
        if (index > numOfTasks) {
            System.out.println("Invalid task index");
        } else {
            tasks[index - 1].markAsDone();
            System.out.println("Nice! I've marked this task as done:\n[X] " + tasks[index - 1].getDescription());
        }
        System.out.println(line);
    }

    public static void level4() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String input = sc.nextLine();
            if (input.contains("done")) {
                doTask(Integer.parseInt(input.substring(input.indexOf(" ") + 1)));
                continue;
            }
            switch (input) {
            case ("bye"):
                exit();
                return;
            case ("list"):
                printList();
                break;
            default:
                if (input.contains("todo")) {
                    String taskName = input.substring(input.indexOf("todo") + 5);
                    tasks[numOfTasks] = new ToDo(taskName);
                } else if (input.contains("deadline")) {
                    String taskName = input.substring(input.indexOf("deadline") + 9, input.indexOf("/") - 1);
                    String by = input.substring(input.indexOf("by") + 3);
                    tasks[numOfTasks] = new Deadline(taskName, by);
                } else if (input.contains("event")) {
                    String taskName = input.substring(input.indexOf("event") + 6, input.indexOf("/") - 1);
                    String at = input.substring(input.indexOf("at") + 3);
                    tasks[numOfTasks] = new Event(taskName, at);
                } else {
                    System.out.println("Invalid  input!");
                    break;
                }
                System.out.println(line);
                System.out.println("Got it. I've added this task:");
                System.out.println("  " + tasks[numOfTasks]);
                System.out.println("Now you have " + (numOfTasks+1) +"tasks in the list.");
                System.out.println(line);
                numOfTasks++;
            }

        }
    }

    public static void main(String[] args) {
        greet();
        level4();
    }
}

