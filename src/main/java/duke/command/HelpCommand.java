package duke.command;

import duke.data.task.TaskList;
import duke.storage.Storage;
import duke.ui.Ui;


public class HelpCommand extends Command{
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showHelp();
    }
}
