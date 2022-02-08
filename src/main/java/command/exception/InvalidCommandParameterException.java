package command.exception;


public class InvalidCommandParameterException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Invalid param for the command";
    }
}
