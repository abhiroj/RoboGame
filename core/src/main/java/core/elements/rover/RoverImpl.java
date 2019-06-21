package core.elements.rover;

import core.elements.coordinate.Coordinate;
import core.exception.AppException;
import core.exception.NoCoordinateFoundException;
import core.manager.CollectionProvider;
import core.manager.MovementProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RoverImpl implements Runnable, Rover {

    private static final Logger LOGGER = LoggerFactory.getLogger(RoverImpl.class);

    private Coordinate coordinate;
    private final int id;
    private boolean shouldRun = false;
    private MovementProvider controller;
    private boolean isActive = false;
    private CollectionProvider collector;

    public RoverImpl(int id) {
        this.id = id;
    }

    /**
     * get current rovers Id.
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * activate this rover to tread on the given coordinates.
     * Throws runtime exception.
     */
    @Override
    public void activate(Coordinate coordinate) {
        if (coordinate == null) {
            throw new AppException(this.toString() + " can not be activated without coordinates");
        }
        if (isActive) {
            LOGGER.warn(this.toString() + " can not be activated again as it is on the move!");
            return;
        }
        this.coordinate = coordinate;
        isActive = true;
        shouldRun = true;
        LOGGER.info("everybody, buckle up please! " + this.toString() + " on the move.");
        new Thread(this, this.toString()).start();
    }

    /**
     * stops the current rover. Rover once stopped can not be restarted again.
     */
    public boolean isActive() {
        return isActive;
    }

    /**
     * determines a move of the rover
     */
    @Override
    public void move() {
        LOGGER.info("Visited " + coordinate.toString() + "by " + this.toString());
        collector.collect(this.coordinate);
        try {
            coordinate = controller.nextMove(this.coordinate);
        } catch (NoCoordinateFoundException e) {
            LOGGER.warn(this.toString() + " stopping itself" + " because " + e.getMessage());
            this.stop();
        }
    }

    /**
     * stops the rover from further moving.
     */
    @Override
    public void stop() {
        if (!isActive) {
            LOGGER.warn("can not stop a rover which is not activated!");
            return;
        }
        LOGGER.info("Pulling Aside!");
        shouldRun = false;
    }

    /**
     * get current location of the rover.
     *
     * @return CoordinateImpl
     */
    public Coordinate getCoordinate() {
        return coordinate;
    }

    /**
     * set new location of the rover.
     *
     * @return CoordinateImpl
     */
    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    /**
     * sets movement manager this rover talks to determine next move.
     * pass null to not set it.
     *
     * @param movementProvider
     */
    public void setMovementProvider(MovementProvider movementProvider) {
        this.controller = movementProvider;
    }

    /**
     * sets collection provider the rover commands to make collection at the given coordinate
     *
     * @param collectionProvider
     */
    public void setCollectionProvider(CollectionProvider collectionProvider) {
        this.collector = collectionProvider;
    }

    @Override
    public void run() {
        while (shouldRun) {
            move();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return "Rover = " + this.getId();
    }
}
