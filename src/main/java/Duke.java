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
            System.out.println((i + 1) + ".[" + tasks[i].getStatusIcon() + "] " + tasks[i].getDescription());
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

    public static void level3() {
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
                tasks[numOfTasks] = new Task(input);
                numOfTasks++;
                System.out.println(line + "\ntask added: " + input + "\n" + line);
            }

        }
    }

    public static void main(String[] args) {
        greet();
        level3();
    }
}

