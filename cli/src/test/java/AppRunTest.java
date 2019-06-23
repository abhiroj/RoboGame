import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class AppRunTest {

    @Test
    public void main_NoArgs_NoExceptionToThrow() throws InterruptedException {
        AppRun appRun = new AppRun();
        appRun.main(new String[]{});
    }

}