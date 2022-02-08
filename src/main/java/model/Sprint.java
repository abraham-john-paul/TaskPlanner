package model;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import model.exception.TaskAlreadyInSprintException;
import model.exception.TaskNotInSprintException;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Collectors;

@Getter
@Builder
public class Sprint extends BaseModel {
    private final Map<String, Task> taskMap = new HashMap<>();
    private final SprintMaster sprintMaster;
    private final Date startDate;
    private final Date endDate;

    public void addTask(@NonNull final Task task) {
        if (taskMap.containsKey(task.getId())) {
            throw new TaskAlreadyInSprintException();
        }
        taskMap.put(task.getId(), task);
    }

    public void removeTask(@NotNull final Task task) {
        if (taskMap.containsKey(task.getId())) {
            taskMap.remove(task.getId());
            return;
        }

        throw new TaskNotInSprintException();
    }

    public void printSprintDetails() {

    }

    private List<Task> getDelayedTasks() {
        var delayedTasks = new ArrayList<Task>();
        for (final Task task : taskMap.values()) {
            delayedTasks.addAll(task.getDelayedTasks(task));
        }

        return delayedTasks;
    }

    private Map<User, Task> getUserTaskMapping() {
        var tasks = taskMap.values();
        return tasks.stream()
                .collect(Collectors.toMap((task) -> task.getDeveloper(), (task) -> task));

    }
}
