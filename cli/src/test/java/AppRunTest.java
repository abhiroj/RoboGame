import core.elements.GameStatus;
import core.manager.GameManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;

@RunWith(MockitoJUnitRunner.class)
public class AppRunTest {

    @Mock
    private GameManager gameManager;

    @InjectMocks
    private AppRun appRun = new AppRun();

    private final String this_is_a_test_status = "This is a test status";

    private GameStatus TEST_GAME_STATUS = GameStatus.createStatus(GameStatus.Code.OK, this_is_a_test_status);

    @Test
    public void main_NoArgs_NoExceptionToThrow() throws InterruptedException {
        appRun.main(new String[]{});
    }

}