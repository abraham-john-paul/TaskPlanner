package repository.exception;

public class InvalidIdInRepoException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Id is invalid for repo";
    }
}
