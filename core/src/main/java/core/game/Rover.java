package core.src.main.java.core.game;

import core.src.main.java.core.controller.GameController;

public interface Rover {

    /**
     * get current rovers Id.
     *
     * @return
     */
    int getId();

    /**
     * activate this rover to tread on playground.
     */
    void activate();

    /**
     * determines one move of the rover
     */
    void move();

    /**
     * stops the current rover. Rover in stop phase can not be restarted again.
     */
    void stop();

    /**
     * get current location
     *
     * @return Coordinate
     */
    Coordinate getCurrentCoordinate();

    /**
     * Show a dump of collected properties
     */
    void dump();

    /**
     * Sets the controller which controls this rover
     * @param handler
     */
    void setGameController(GameController handler);

    void setCoordinate(Coordinate coordinate);

}
