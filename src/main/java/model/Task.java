package model;

import lombok.*;
import lombok.experimental.SuperBuilder;
import model.strategy.IsCompletedTaskStrategy;

import java.util.List;

@Getter
@SuperBuilder
@AllArgsConstructor
public abstract class Task extends BaseModel {
    private final String description;
    private final TaskType taskType;
    @Setter
    private TaskStatus taskStatus;
    private final IsCompletedTaskStrategy isCompletedTaskStrategy;

    private final Sprint sprint;
    private final Developer developer;

    public boolean isCompleted(@NonNull final Task task) {
        return isCompletedTaskStrategy.isCompleted(task);
    }

    public List<Task> getDelayedTasks(@NonNull final Task task) {
        return isCompleted(task) ? List.of() : List.of(task);
    }

//    void printTask();
}
// kishan@nurture.farm