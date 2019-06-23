package manager;

import core.elements.GameStatus;
import core.elements.coordinate.AxisType;
import core.elements.coordinate.Coordinate;
import core.elements.playground.Playground;
import core.elements.rover.Rover;
import core.exception.AppException;
import core.exception.NoCoordinateFoundException;
import core.factory.PlaygroundFactory;
import core.factory.RoverFactory;
import core.factory.ShapesFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.spy;

@RunWith(JUnit4.class)
public class CLIGameManagerTest {

    private final int TEST_DIMENSION = 2;

    private final Playground TEST_PLAYGROUND =
            PlaygroundFactory.get2DPlayground(ShapesFactory.getArrayRepresentation(TEST_DIMENSION, TEST_DIMENSION));

    private final int TEST_ROVER_DEPLOY = 1;

    private final Coordinate TEST_DEPLOY_COORDINATE = Coordinate.get(Map.of(AxisType.X, TEST_ROVER_DEPLOY,
            AxisType.Y, TEST_ROVER_DEPLOY));

    private final Coordinate TEST_OUT_OF_BOUND_COORDINATE = Coordinate.get(Map.of(AxisType.X, TEST_DIMENSION + 10,
            AxisType.Y, TEST_DIMENSION + 10));

    private CLIGameManager cliGameManager = new CLIGameManager();

    @Test(expected = AppException.class)
    public void createGame_NotImplemented_ThrowAppException() {
        Playground playground = PlaygroundFactory.get2DPlayground(null);
        GameStatus gameStatus = cliGameManager.createGame(playground, TEST_DIMENSION);
    }

    @Test
    public void createGame_PlaygroundNotNullRoveListNotNull_GetGameStatus() {
        Playground playground = PlaygroundFactory.get2DPlayground(null);
        GameStatus gameStatus = cliGameManager.createGame(playground, List.of(RoverFactory.createRover()));
        assertThat(gameStatus, is(notNullValue()));
        assertEquals(gameStatus.getCode(), GameStatus.Code.OK);
    }

    @Test
    public void addRovers_CountMoreThan1_GameStatusOk() {
        GameStatus gameStatus = cliGameManager.addRovers(TEST_DIMENSION);
        assertThat(gameStatus, is(notNullValue()));
        assertEquals(gameStatus.getCode(), GameStatus.Code.OK);
    }

    @Test(expected = AppException.class)
    public void addRoversOnCoordinates_NotImplemented_ThrowsAppException() {
        cliGameManager.addRoversOnCoordinates(List.of());
    }

    @Test(expected = AppException.class)
    public void removeRovers_NotImplemented_ThrowAppException() {
        cliGameManager.removeRovers(TEST_DIMENSION);
    }

    @Test
    public void removeRovers_ListOfRovers_OkGameStatus() {
        List roverList = new ArrayList();
        roverList.add(RoverFactory.createRover());
        roverList.add(RoverFactory.createRover());
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
        assertEquals(gameStatus.getCode(), GameStatus.Code.OK);
    }

    @Test
    public void startGame_GameCreatedRoverNoCoordinateAlloted_OkGameStatus() {
        Rover testRover = spy(RoverFactory.createRover());
        Mockito.doNothing().when(testRover).activate(any());
        cliGameManager.createGame(PlaygroundFactory.get2DPlayground(ShapesFactory.getArrayRepresentation(TEST_DIMENSION, TEST_DIMENSION)),
                List.of(testRover));
        GameStatus gameStatus = cliGameManager.startGame();
        assertThat(gameStatus, is(notNullValue()));
        assertEquals(gameStatus.getCode(), GameStatus.Code.OK);
    }

    @Test
    public void startGame_GameCreatedRoverCoordinateAlloted_OkGameStatus() {
        Rover testRover = spy(RoverFactory.createRover());
        testRover.setCoordinate(TEST_DEPLOY_COORDINATE);
        Mockito.doNothing().when(testRover).activate(any());
        cliGameManager.createGame(TEST_PLAYGROUND, List.of(testRover));
        GameStatus gameStatus = cliGameManager.startGame();
        assertThat(gameStatus, is(notNullValue()));
        assertEquals(gameStatus.getCode(), GameStatus.Code.OK);
    }

    @Test(expected = AppException.class)
    public void startGame_GameCreatedNoRoversAssigned_ThrowsAppException() {
        cliGameManager.createGame(TEST_PLAYGROUND, List.of());
        GameStatus gameStatus = cliGameManager.startGame();
    }

    @Test
    public void getStatus_GameCreated_OkGameStatus() {
        cliGameManager.createGame(PlaygroundFactory.get2DPlayground(ShapesFactory.getArrayRepresentation(TEST_DIMENSION, TEST_DIMENSION)), List.of());
        cliGameManager.collect(TEST_DEPLOY_COORDINATE);
        GameStatus gameStatus = cliGameManager.getStatus();
        assertThat(gameStatus, is(notNullValue()));
        assertEquals(gameStatus.getCode(), GameStatus.Code.OK);
    }

    @Test(expected = AppException.class)
    public void nextMove_CoordinateAndDirectionStrategy_NotImplemented() {
        cliGameManager.nextMove(null, null);
    }

    @Test
    public void nextMove_CoordinateValid_GetAValidNextCoordinate() {
        cliGameManager.createGame(TEST_PLAYGROUND, List.of());
        Coordinate coordinate = cliGameManager.nextMove(TEST_DEPLOY_COORDINATE);
        assertThat(coordinate, is(notNullValue()));
    }

    @Test(expected = NoCoordinateFoundException.class)
    public void nextMove_CoordinateInvalid_NoCoordinateFoundException() {
        cliGameManager.createGame(TEST_PLAYGROUND, List.of());
        cliGameManager.nextMove(TEST_OUT_OF_BOUND_COORDINATE);
    }

    @Test
    public void finishGame_NoParams_OkGameStatus() {
        List roverList = new ArrayList();
        roverList.add(RoverFactory.createRover());
        roverList.add(RoverFactory.createRover());
        cliGameManager.createGame(TEST_PLAYGROUND, roverList);
        GameStatus gameStatus = cliGameManager.finishGame();
        assertThat(gameStatus, is(notNullValue()));
        assertEquals(gameStatus.getCode(), GameStatus.Code.OK);
    }
}