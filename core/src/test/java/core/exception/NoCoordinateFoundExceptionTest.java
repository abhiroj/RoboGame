package core.exception;

import org.junit.Test;

public class NoCoordinateFoundExceptionTest {

    private final String this_is_a_test_exception = "This is a test exception";
    private final String exception_message = "This can be one";

    @Test(expected = NoCoordinateFoundException.class)
    public void getException_StringOnly() {
        NoCoordinateFoundException exception = new NoCoordinateFoundException(this_is_a_test_exception);
        throw exception;
    }

    @Test(expected = NoCoordinateFoundException.class)
    public void getException_StringAndThrowable() {
        NoCoordinateFoundException exception = new NoCoordinateFoundException(this_is_a_test_exception,
                new Exception(exception_message));
        throw exception;
    }

    @Test(expected = NoCoordinateFoundException.class)
    public void getException_ThrowableOnly() {
        NoCoordinateFoundException exception = new NoCoordinateFoundException(new Exception(exception_message));
        throw exception;
    }

}