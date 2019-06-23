package manager;

import core.elements.GameStatus;
import core.elements.playground.Playground;
import core.elements.rover.Rover;
import core.exception.AppException;
import core.factory.PlaygroundFactory;
import core.factory.RoverFactory;
import core.factory.ShapesFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.spy;

@RunWith(JUnit4.class)
public class CLIGameManagerTest {

    private CLIGameManager cliGameManager = new CLIGameManager();

    @Test(expected = AppException.class)
    public void createGame_NotImplemented_ThrowAppException() {
        Playground playground = PlaygroundFactory.get2DPlayground(null);
        GameStatus gameStatus = cliGameManager.createGame(playground, 2);
    }

    @Test
    public void createGame_PlaygroundNotNullRoveListNotNull_GetGameStatus() {
        Playground playground = PlaygroundFactory.get2DPlayground(null);
        GameStatus gameStatus = cliGameManager.createGame(playground, List.of(RoverFactory.createRover()));
        assertThat(gameStatus, is(notNullValue()));
        assertThat(gameStatus.getCode(), GameStatus.Code.OK);
    }

    @Test
    public void addRovers_CountMoreThan1_GameStatusOk() {
        GameStatus gameStatus = cliGameManager.addRovers(2);
        assertThat(gameStatus, is(notNullValue()));
    }

    @Test(expected = AppException.class)
    public void addRoversOnCoordinates_NotImplemented_ThrowsAppException() {
        cliGameManager.addRoversOnCoordinates(List.of());
    }

    @Test(expected = AppException.class)
    public void removeRovers_NotImplemented_ThrowAppException() {
        cliGameManager.removeRovers(2);
    }

    @Test
    public void removeRovers_ListOfRovers_OkGameStatus() {
        List roverList = List.of(RoverFactory.createRover(),
                RoverFactory.createRover());
        cliGameManager.addRovers(roverList);
        GameStatus gameStatus = cliGameManager.removeRovers(roverList);
        assertThat(gameStatus, is(notNullValue()));
    }

    @Test(expected = AppException.class)
    public void removeRoversFromCoordinates_NotImplemented_ThrowsAppException() {
        cliGameManager.removeRoversFromCoordinates(List.of());
    }

    @Test
    public void removePlayground_NoParams_OkGameStatus() {
        cliGameManager.setPlayground(PlaygroundFactory.get2DPlayground(null));
        GameStatus gameStatus = cliGameManager.removePlayground();
        assertThat(gameStatus, is(notNullValue()));
    }

    @Test
    public void startGame_GameCreated_OkGameStatus() {
        Rover testRover = spy(RoverFactory.createRover());
        Mockito.doNothing().when(testRover).activate(any());
        cliGameManager.createGame(PlaygroundFactory.get2DPlayground(ShapesFactory.getArrayRepresentation(2, 2)),
                List.of(testRover));
        GameStatus gameStatus = cliGameManager.startGame();
        assertThat(gameStatus, is(notNullValue()));
    }
}