package model.strategy;

import lombok.NonNull;
import model.Task;

public interface IsCompletedTaskStrategy {
    boolean isCompleted(@NonNull final Task task);
}
