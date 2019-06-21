package core.exception;

public class NoCoordinateFound extends AppException {
    public NoCoordinateFound(String message) {
        super(message);
    }

    public NoCoordinateFound(String message, Throwable t) {
        super(message, t);
    }
}