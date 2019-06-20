package core.elements.rover;

import core.manager.CollectionProvider;
import core.manager.MovementProvider;
import core.elements.coordinate.Coordinate;

public interface Rover {

    /**
     * get current rovers Id.
     *
     * @return
     */
    int getId();

    /**
     * get rover's status if it is active or not.
     *
     * @return
     */
    boolean isActive();

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
     * Sets Movement Provider
     *
     * @param handler
     */
    void setMovementProvider(MovementProvider handler);

    /**
     * Sets Collection Provider
     *
     * @param handler
     */
    void setCollectionProvider(CollectionProvider handler);


}
