package command.exception;

public class InvalidCommandTypeException extends RuntimeException {
    @Override
    public String getMessage() {
        return "CommandType isn't supported";
    }
}
