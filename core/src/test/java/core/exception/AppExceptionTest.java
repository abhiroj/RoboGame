package core.exception;

import org.junit.Test;

public class AppExceptionTest {

    private final String this_is_a_test_exception = "This is a test exception";
    private final String exception_message = "This can be one";

    @Test(expected = AppException.class)
    public void getException_StringOnly() {
        AppException exception = new AppException(this_is_a_test_exception);
        throw exception;
    }

    @Test(expected = AppException.class)
    public void getException_StringAndThrowable() {
        AppException exception = new AppException(this_is_a_test_exception, new Exception(exception_message));
        throw exception;
    }

    @Test(expected = AppException.class)
    public void getException_ThrowableOnly() {
        AppException exception = new AppException(new Exception(exception_message));
        throw exception;
    }

}