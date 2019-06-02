package core.src.main.java.core.game;

import java.util.Map;

public interface Rover {

    /**
     * Get Rover's ID assigned by factory
     *
     * @return
     */
    int getId();

    /**
     * make rover choose and make next move
     */
    void move();

    /**
     * stop all operations of this rover. This can optionally be used to demobilize the rover.
     */
    void stop();

    /**
     * Set Coordinates of rover to make a move
     *
     * @param coordinates
     */
    void setStartingCoordinate(Coordinate coordinates);

    /**
     * get Current location of Rover
     *
     * @return
     */
    Coordinate getCoordinate();

    /**
     * Dump all the properties that has been collected by rover.
     */
    void dump();

    void setMediator(Mediator mediator);

}
