package core.manager;

import core.elements.GameStatus;
import core.elements.coordinate.Coordinate;
import core.elements.playground.Playground;
import core.elements.rover.Rover;

import java.util.List;

/**
 * provides the functionality to do actions on the game.
 * methods returns the status of corresponding action back to user
 */
public interface GameManager {

    /**
     * @apiNote creates a game by deploying roverCount number of rovers on the playground
     */
    GameStatus createGame(Playground playground, int roverCount);

    /**
     * @apiNote creates a game by deploying rovers on the playground specified in the list of rovers.
     */
    GameStatus createGame(Playground playground, List<Rover> rovers);

    /**
     * sets the playground
     *
     * @param playground
     * @return
     */
    GameStatus setPlayground(Playground playground);

    /**
     * remove the playground
     *
     * @param playground
     * @return
     */
    GameStatus removePlayground(Playground playground);

    /**
     * System begins playing a game
     */
    GameStatus startGame();

    /**
     * system finishes the game and gets the status
     *
     * @return
     */
    GameStatus finishGame();

    /**
     * get current status of game
     *
     * @return
     */
    GameStatus getStatus();


    /**
     * add roverCount number of rovers in the game given the rover count
     *
     * @param
     * @return
     */
    GameStatus addRovers(int roverCount);

    /**
     * add specified rovers in the game
     *
     * @param
     * @return
     */
    GameStatus addRovers(List<Rover> rovers);

    /**
     * add rovers in the game specifically on the coordinates mentioned in the coordinates.
     *
     * @param
     * @return
     */
    GameStatus addRoversOnCoordinates(List<Coordinate> coordinates);

    /**
     * remove any roverCount number of rovers from the game
     *
     * @param
     * @return
     */
    GameStatus removeRovers(int roverCount);

    /**
     * remove rovers specified in rover list to be removed from the game
     *
     * @param
     * @return
     */
    GameStatus removeRovers(List<Rover> roverList);


    /**
     * remove rovers from coordinates specified in the list.
     *
     * @param
     * @return
     */
    GameStatus removeRoversFromCoordinates(List<Coordinate> coordinates);
}
