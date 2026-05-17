package exceptions;

public class MaxFailException extends RuntimeException {
    public MaxFailException(String message) {
        super(message);
    }
}
