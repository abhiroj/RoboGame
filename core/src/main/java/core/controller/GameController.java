package core.src.main.java.core.controller;

import core.src.main.java.core.game.Coordinate;
import core.src.main.java.core.game.Playground;
import core.src.main.java.core.game.Rover;

import java.util.Map;

public interface GameController {

    /**
     * deploy a rover on playground
     * @param rover
     */
    void deploy(Rover rover);

    /**
     * demobilize a rover that is a part of playground.
     * Throws runtime exception if rover is not deployed
     * @param rover
     */
    void demobilze(Rover rover);

    /**
     * get next pair of coordinates to move on
     * @param coordinate
     * @return
     */
    Coordinate nextMove(Coordinate coordinate);

    void setPlayground(Playground playground);

    Playground getPlayground();

    /**
     * collect properies on the playground's coordinate
     * @param coordinate
     * @return
     */
    Map<String, Object> collect(Coordinate coordinate);

}
