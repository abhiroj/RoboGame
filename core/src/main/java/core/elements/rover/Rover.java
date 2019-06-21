package core.elements.rover;

import core.elements.coordinate.Coordinate;
import core.manager.CollectionProvider;
import core.manager.MovementProvider;

/**
 * Contract for functionalities that defines a generic rover.It should be able to activate, move and stop itself.
 * Functional contract for a rover object to be used in the system
 */
public interface Rover {

    /**
     * activate this rover to move.
     */
    void activate(Coordinate coordinate);

    /**
     * determines a move of the rover
     */
    void move();

    /**
     * stops the rover from further moving.
     */
    void stop();

    /**
     * sets movement manager to which this rover talks to determine next move.
     * pass null to unset.
     * throws runtime exception if not implemented and tried to be used.
     *
     * @param movementProvider
     */
    void setMovementProvider(MovementProvider movementProvider);

    /**
     * sets collection provider the rover commands to make collection at the given coordinate
     * pass null to unset.
     * throws runtime exception if not implemented and tried to be used.
     *
     * @param collectionProvider
     */
    void setCollectionProvider(CollectionProvider collectionProvider);

    /**
     * get current location of this rover's on the playground.
     *
     * @return
     */
    Coordinate getCoordinate();

    /**
     * set new location of this rover's on the playground.
     *
     * @return
     */
    void setCoordinate(Coordinate coordinate);
}