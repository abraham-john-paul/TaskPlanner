package model.exception;

public class TaskNotInSprintException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Task for removal doesnt exist in sprint";
    }
}
