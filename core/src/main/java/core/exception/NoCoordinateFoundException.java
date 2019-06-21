package core.exception;

/**
 * Exception thrown if no further coordinate is found to make a next move.
 */
public class NoCoordinateFoundException extends AppException {
    public NoCoordinateFoundException(String message) {
        super(message);
    }

    public NoCoordinateFoundException(String message, Throwable t) {
        super(message, t);
    }
}