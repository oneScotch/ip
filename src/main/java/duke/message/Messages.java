package duke.message;

public class Messages {
    private static final String logo = " ____              ________  \n"
            + "|  _ \\  | |   | |  |__  __| \n"
            + "| |_| | | |   | |    |  |\n"
            + "|____/  | |   | |    |  |\n"
            + "| |\\ \\  | |   | |    |  |\n"
            + "| | \\ \\ | |___| |   --  --\n"
            + "|_|  \\ \\\\ _____ /  | ____|\n";
    public static final String MESSAGE_WELCOME = "Hello from\n" + logo;
    public static final String MESSAGE_GREET = "Hello! I'm Rui\nWhat can I do for you?";
    public static final String MESSAGE_GOODBYE = "Bye. Hope to see you again soon!";
    public static final String MESSAGE_LIST = "Here are the tasks in your list:\n%s";
    public static final String MESSAGE_DONE = "Nice! I've marked this task as done:\n%s";
    public static final String MESSAGE_DELETE = "Noted. I've removed this task: \n%s";
    public static final String MESSAGE_ADD = "Got it. I've added this task:\n%s";
    public static final String MESSAGE_COUNT = "Now you have %d tasks in the list.";

    public static final String MESSAGE_HELP = "Sample commands: \n"
            + "list: show all the tasks\n"
            + "todo <content>: add a todo task\n"
            + "event <content> /at <time>: add an event task \n"
            + "deadline <content> /by <time>: add a deadline task\n"
            + "done <index>: mark the task at index \'index\' as done\n"
            + "delete <index>: delete the task at index \'index\'\n"
            + "bye: close the program\n";

    public static final String MESSAGE_LOADING_ERROR = "No previous data";
    public static final String MESSAGE_INVALID_COMMAND_FORMAT = "Invalid command format! \n%1$s";
    public static final String MESSAGE_INVALID_PERSON_DISPLAYED_INDEX = "The person index provided is invalid";
    public static final String MESSAGE_PERSON_NOT_IN_ADDRESSBOOK = "Person could not be found in address book";
    public static final String MESSAGE_PERSONS_LISTED_OVERVIEW = "%1$d persons listed!";
    public static final String MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE = "Launch command format: "
            + "java seedu.addressbook.Main [STORAGE_FILE_PATH]";
    public static final String MESSAGE_USING_STORAGE_FILE = "Using storage file : %1$s";
}
