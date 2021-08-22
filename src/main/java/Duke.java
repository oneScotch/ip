import java.util.Scanner;

public class Duke {
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

    public static void level1() {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        if (input.equals("bye")) {
            exit();
            return;
        }
        System.out.println(line + "\n" + input + "\n" + line);
    }

    public static void main(String[] args) {
        greet();
        level1();
    }
}
