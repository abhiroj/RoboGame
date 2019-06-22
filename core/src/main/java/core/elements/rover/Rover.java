package core.elements.rover;

import core.consumer.CollectionConsumer;
import core.consumer.MovementConsumer;
import core.elements.coordinate.Coordinate;

/**
 * Contract for functionalities that defines a generic rover.It should be able to activate, move and stop itself.
 * Functional contract for a rover object to be used in the system
 */
public interface Rover extends MovementConsumer, CollectionConsumer {

    /**
     * activate this rover to move.
     */
    void activate(Coordinate coordinate);

    /**
     * Returns status of Rover where rover is active or not.
     *
     * @return
     */
    boolean isActive();

    /**
     * determines a move of the rover
     */
    void move();

    /**
     * stops the rover from further moving.
     */
    void stop();

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