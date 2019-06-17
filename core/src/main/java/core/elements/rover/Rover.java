package core.elements.rover;

import core.controller.RoverManager;
import core.elements.coordinate.Coordinate;

public interface Rover {

    /**
     * get current rovers Id.
     *
     * @return
     */
    int getId();

    /**
     * activate this rover to tread.
     * Throws runtime exception if coordinates are not set.
     */
    void activate();

    /**
     * activate this rover to tread on the given coordinates
     */
    void activate(Coordinate coordinate);

    /**
     * determines a move of the rover
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
     *
     * @param handler
     */
    void setController(RoverManager handler);


}
