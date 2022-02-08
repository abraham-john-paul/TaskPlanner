package model.exception;

public class TaskAlreadyInSprintException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Task already exist in the sprint";
    }
}
