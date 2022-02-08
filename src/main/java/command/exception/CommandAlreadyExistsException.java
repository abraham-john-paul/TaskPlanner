package command.exception;

public class CommandAlreadyExistsException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Command already exists in registry";
    }
}
