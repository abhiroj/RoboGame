package core.utilities;

import core.exception.AppException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static junit.framework.TestCase.assertEquals;

@RunWith(JUnit4.class)
public class CoreUtilsTest {

    @Test
    public void testFormat() {
        String pattern = "{0}";
        String matcher = "a";
        String result = "a";
        assertEquals(CoreUtils.format(pattern, matcher), result);
    }

    @Test(expected = AppException.class)
    public void testRequired() {
        CoreUtils.required("Object", null);
    }

}