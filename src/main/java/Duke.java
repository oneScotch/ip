import java.util.Scanner;


public class Duke {
    public static String line = "____________________________________________________________";
    private static DoTask doTask = new DoTask();

    public static void greet() {
        String logo = " ____              ________  \n"
                + "|  _ \\  | |   | |  |__  __| \n"
                + "| |_| | | |   | |    |  |\n"
                + "|____/  | |   | |    |  |\n"
                + "| |\\ \\  | |   | |    |  |\n"
                + "| | \\ \\ | |___| |   --  --\n"
                + "|_|  \\ \\\\ _____ /  | ____|\n";
        System.out.println("Hello from\n" + logo);

        System.out.println(line + "\nHello! I'm Rui\nWhat can I do for you?\n" + line);
    }

    public static void exit() {
        System.out.println("Bye. Hope to see you again soon!\n" + line);
    }

    public static String translate(String input){
        if (input.contains("done")) {
            return "DONE";
        }
        if (input.contains("bye")) {
            return "EXIT";
        }
        if (input.contains("list")) {
            return "LIST";
        }
        if (input.contains("todo")) {
            return "T";
        } else if (input.contains("deadline")) {
            return "D";
        } else if (input.contains("event")) {
            return "E";
        }
       return "F";
    }




    public static void main(String[] args) {
        greet();
        Scanner sc = new Scanner(System.in);

        while (true) {
            String input = sc.nextLine();
            String request = translate(input);
            switch (request) {
            case "DONE":
                doTask.done(input);
                break;
            case "EXIT":
                exit();
                break;
            case "LIST":
                doTask.printList();
                break;
            default:
                doTask.addTask(input, request);

            }
        }
    }


}

