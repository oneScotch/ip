package duke.data.task;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
public class TaskList {

    private final List<Task> tasks;

    public TaskList() {
        tasks = new ArrayList<>();
    }

    /**
     * Initialises  based on a list of existing tasks.
     *
     * @param tasks The lists of tasks
     */
    public TaskList(List<Task> tasks) {
        this.tasks = tasks;
    }
    /**
     * Fetch the task at index taskId
     *
     * @param taskId The ID of the task
     */
    public Task getTask(int taskId) {
        return this.tasks.get(taskId - 1);
    }

    public boolean addTask(Task task) {
        return this.tasks.add(task);
    }

    public Task deleteTask(int taskId) {
        return this.tasks.remove(taskId - 1);
    }


    public int size() {
        return this.tasks.size();
    }
    @Override
    public String toString() {
        return IntStream.range(0, tasks.size())
                .mapToObj(i -> String.format("%d. %s", i + 1, tasks.get(i)))
                .collect(Collectors.joining("\n")).trim();
    }

}