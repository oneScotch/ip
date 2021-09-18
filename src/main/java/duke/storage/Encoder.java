package duke.storage;

import duke.data.task.Task;

import java.util.ArrayList;
import java.util.List;

public class Encoder {
    /**
     * Encodes into a list of decodable and readable string presentation for storage.
     */
    public static List<String> encoder(ArrayList<Task> tasks) {
        final ArrayList<String> encodedTasks = new ArrayList<>();
        tasks.stream()
                .forEach(task -> encodedTasks.add(task.store()));
        return encodedTasks;
    }
}
