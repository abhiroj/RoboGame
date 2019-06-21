package core.elements.rover;

import core.elements.coordinate.Coordinate;
import core.exception.AppException;
import core.exception.NoCoordinateFoundException;
import core.manager.CollectionProvider;
import core.manager.MovementProvider;

public class Rover implements Runnable, GenericRover {

    private Coordinate coordinate;
    private final int id;
    private boolean shouldRun = false;
    private MovementProvider controller;
    private boolean isActive = false;
    private CollectionProvider collector;

    public Rover(int id) {
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
            throw new AppException(this.toString() + " can not be activated again");
        }
        this.coordinate = coordinate;
        isActive = true;
        shouldRun = true;
        System.out.println("everybody, buckle up please! " + this.toString() + " on the move.");
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
        System.out.println("Visited " + coordinate.toString() + "by " + this.toString());
        collector.collect(this.coordinate);
        try {
            coordinate = controller.nextMove(this.coordinate);
        } catch (NoCoordinateFoundException e) {
            System.out.println(this.toString() + " stopping itself" + " because " + e.getMessage());
            this.stop();
        }
    }

    /**
     * stops the rover from further moving.
     */
    @Override
    public void stop() {
        if (!isActive) {
            System.out.println("can not stop a rover which is not activated!");
            return;
        }
        System.out.println("Pulling Aside!");
        shouldRun = false;
    }

    /**
     * get current location of the rover.
     *
     * @return CoordinateImpl
     */
    public Coordinate getCurrentCoordinate() {
        return coordinate;
    }

    /**
     * sets movement manager this rover talks to determine next move.
     * pass null to not set it.
     *
     * @param handler
     */
    public void setMovementProvider(MovementProvider handler) {
        this.controller = handler;
    }

    /**
     * sets collection provider the rover commands to make collection at the given coordinate
     *
     * @param handler
     */
    public void setCollectionProvider(CollectionProvider handler) {
        this.collector = handler;
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
