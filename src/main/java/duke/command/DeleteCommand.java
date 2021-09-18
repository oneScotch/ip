package duke.command;

import duke.data.exception.OutOfRangeException;
import duke.data.task.Task;
import duke.data.task.TaskList;
import duke.message.Messages;
import duke.storage.Storage;
import duke.ui.Ui;

public class DeleteCommand extends Command {
    private final int Index;

    public DeleteCommand(int Index) {
        this.Index = Index;
    }

    public void execute(TaskList tasks, Ui ui, Storage storage) throws OutOfRangeException {
        if (Index > tasks.size()) {
            throw new OutOfRangeException("in Delete task");
        } else {
            Task task = tasks.deleteTask(Index);
            System.out.printf((Messages.MESSAGE_DELETE)+ "%n",task);
            System.out.printf((Messages.MESSAGE_COUNT)+ "%n", tasks.size());
            storage.changeToFile(tasks);
        }
    }
}
