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

    public static void level2() {
        String[] list = new String[100];
        Scanner sc = new Scanner(System.in);
        int count = 0;
        while (true) {
            String input = sc.nextLine();
            switch (input) {
            case ("bye"):
                exit();
                return;
            case ("list"):
                System.out.println(line);
                for (int i = 0; i < count; i++) {
                    System.out.println((i + 1) + ". " + list[i]);
                }
                System.out.println(line);
                break;
            default:
                list[count] = input;
                count++;
                System.out.println(line + "\nadded: " + input + "\n" + line);
            }

        }
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
        level2();
    }
}
