package core.exception;

/**
 * Exception thrown if no further coordinate is found to make a next move.
 */
//TODO:Add copyright
public class NoCoordinateFoundException extends AppException {
    public NoCoordinateFoundException(String message) {
        super(message);
    }

    public NoCoordinateFoundException(String message, Throwable t) {
        super(message, t);
    }

    public NoCoordinateFoundException(Throwable t) {
        super(t);
    }
}