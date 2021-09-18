package duke.command;

import duke.data.task.TaskList;
import duke.storage.Storage;
import duke.ui.Ui;
import duke.message.Messages;

public class ListCommand extends Command {
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        if (tasks.size() == 0) {
            System.out.println("No task added yet!");
        } else {
            System.out.println(String.format(Messages.MESSAGE_LIST, tasks));
        }
    }

}
