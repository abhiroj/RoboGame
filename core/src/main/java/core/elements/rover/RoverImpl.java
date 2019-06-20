package core.elements.rover;

import core.elements.coordinate.Coordinate;
import core.exception.AppException;
import core.exception.NoCoordinateFound;
import core.manager.CollectionProvider;
import core.manager.MovementProvider;

public class RoverImpl implements Rover, Runnable {

    private Coordinate coordinate;
    private final int id;
    private boolean shouldRun = false;
    private MovementProvider controller;
    private boolean isActive = false;
    private CollectionProvider collector;

    public RoverImpl(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void activate() {
        activate(coordinate);
    }

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
        System.out.println("everybody, buckle up please!" + this.toString() + " on the move.");
        new Thread(this, this.toString()).start();
    }

    public boolean isActive() {
        return isActive;
    }

    @Override
    public void move() {
        System.out.println("Visited " + coordinate.toString() + "by " + this.toString());
        collector.collect(this.coordinate);
        try {
            coordinate = controller.nextMove(this.coordinate);
        } catch (NoCoordinateFound e) {
            System.out.println(this.toString() + " stopping itself" + " because " + e.getMessage());
            this.stop();
        }
    }

    @Override
    public void stop() {
        if (!isActive) {
            System.out.println("can not stop a rover which is not activated!");
            return;
        }
        System.out.println("Pulling Aside!");
        shouldRun = false;
    }

    @Override
    public Coordinate getCurrentCoordinate() {
        return coordinate;
    }

    @Override
    public void setMovementProvider(MovementProvider handler) {
        this.controller = handler;
    }

    @Override
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
        return "Rover " + this.getId();
    }
}
