package model.strategy;

import lombok.NonNull;
import model.Task;
import model.TaskStatus;

public class IsCompletedWhenDoneTaskStrategy implements IsCompletedTaskStrategy {
    @Override
    public boolean isCompleted(@NonNull final Task task) {
        return task.getTaskStatus() == TaskStatus.DONE;
    }
}
