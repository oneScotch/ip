package duke.command;

import duke.data.exception.EmptyTaskException;
import duke.data.exception.MissingParaException;
import duke.data.exception.OutOfRangeException;
import duke.data.task.*;
import duke.message.Messages;
import duke.storage.Storage;
import duke.ui.Ui;

public class AddCommand extends Command{
    private Task task;
    public AddCommand(Task task) {
        this.task = task;
    }
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        tasks.addTask(task);
        storage.changeToFile(tasks);
        System.out.printf((Messages.MESSAGE_ADD) + "%n",task);
        System.out.printf((Messages.MESSAGE_COUNT)+ "%n",tasks.size());
    }

}

