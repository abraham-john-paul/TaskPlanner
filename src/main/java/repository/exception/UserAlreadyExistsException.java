package repository.exception;

public class UserAlreadyExistsException extends RuntimeException {
    @Override
    public String getMessage() {
        return "User already present in repo";
    }
}
