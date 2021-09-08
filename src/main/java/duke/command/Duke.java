package duke.command;

import duke.command.DoTask;
import duke.exception.EmptyTaskException;
import duke.exception.InvalidInputException;
import duke.exception.MissingParaException;
import duke.exception.OutOfRangeException;

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

    public static String translate(String input) throws InvalidInputException {
        if (input.contains("done")) {
            return "DONE";
        } else if (input.contains("bye")) {
            return "EXIT";
        } else if (input.contains("list")) {
            return "LIST";
        } else if (input.contains("todo")) {
            return "T";
        } else if (input.contains("deadline")) {
            return "D";
        } else if (input.contains("event")) {
            return "E";
        }else{
            throw new InvalidInputException();
        }

    }

    public static void printError(Exception e) {
        if (e instanceof InvalidInputException) {
            System.out.println(line);
            System.out.println(" OOPS!!! I'm sorry, but I don't know what that means :-(");
            System.out.println(line);
        } else if (e instanceof EmptyTaskException) {
            System.out.println(line);
            System.out.println(" OOPS!!! The description of your task cannot be empty.");
            System.out.println(line);
        } else if (e instanceof MissingParaException) {
            System.out.println(line);
            System.out.println(" OOPS!!! Some variable is missing");
            System.out.println(line);
        } else if (e instanceof OutOfRangeException) {
            System.out.println(line);
            System.out.println(" OOPS!!! The index is out of range");
            System.out.println(line);
        } else {
            System.out.println(line);
            System.out.println(" OOPS!!! The program fails for the reason"+e.getMessage());
            System.out.println(line);
        }
    }


    public static void main(String[] args) {
        try{
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
        } catch (InvalidInputException e) {
            printError(e);
        } catch (MissingParaException e) {
            printError(e);
        } catch (EmptyTaskException e) {
            printError(e);
        } catch (OutOfRangeException e) {
            printError(e);
        }

    }


}

