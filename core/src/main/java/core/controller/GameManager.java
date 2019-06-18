package core.controller;

import core.elements.GameStatus;
import core.elements.playground.Playground;
import core.elements.rover.Rover;

import java.util.List;

/**
 * provides the functionality to do actions on the game.
 * methods returns the status of corresponding action back to user
 */
public interface GameManager {

    /**
     * @apiNote creates a game by deploying rovers on the playground
     */
    GameStatus createGame(Playground playground, int roverCount);

    /**
     * @apiNote creates a game by deploying rovers on the playground
     */
    GameStatus createGame(Playground playground, List<Rover> rovers);

    /**
     * give the game a playground to play upon
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
    GameStatus getGameStatus();


    /**
     * add @param roverCount number of rovers in the game given the rover count
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
     * remove @param roverCount number of rovers form the game
     *
     * @param
     * @return
     */
    GameStatus removeRovers(int roverCount);

    /**
     * @param
     * @return
     */
    GameStatus removeRovers(List<Rover> roverList);
}
