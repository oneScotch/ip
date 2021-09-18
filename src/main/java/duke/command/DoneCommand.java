package duke.command;

import duke.data.exception.OutOfRangeException;
import duke.data.task.Task;
import duke.data.task.TaskList;
import duke.message.Messages;
import duke.storage.Storage;
import duke.ui.Ui;

public class DoneCommand extends Command {
    private final int Index;

    public DoneCommand(int Index) {
        this.Index = Index;
    }
    public void execute(TaskList tasks, Ui ui, Storage storage) throws OutOfRangeException{
        if (Index > tasks.size()) {
            throw new OutOfRangeException("in Done task");
        } else {
            Task task = tasks.getTask(Index);
            tasks.getTask(Index).markAsDone();
            storage.changeToFile(tasks);
            System.out.printf((Messages.MESSAGE_DONE) + "%n", task);

        }
    }
}
