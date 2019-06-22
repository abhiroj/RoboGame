package core.elements;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class GameStatusTest {

    private GameStatus gameStatus;
    private final int testCode = 200;
    private final String testMessage = "This is a test message";

    @Test
    public void testFunctionality() {
        gameStatus = GameStatus.createStatus(testCode, testMessage);
        assertEquals(gameStatus.getCode(), testCode);
        assertEquals(gameStatus.getMessage(), testMessage);
    }
}