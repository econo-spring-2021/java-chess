package Chess.exception;

public class InvalidUserInputException extends IllegalArgumentException {
    public InvalidUserInputException(String message) {
        super(message);
    }
}
