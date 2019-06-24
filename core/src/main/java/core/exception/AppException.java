package core.exception;

//TODO:Add copyright
public class AppException extends RuntimeException {

    public AppException(String message) {
        super(message);
    }

    public AppException(String message, Throwable t) {
        super(message, t);
    }

    public AppException(Throwable t) {
        super(t);
    }

}
