package core.elements.rover;

import core.controller.CollectionProvider;
import core.controller.MovementProvider;
import core.elements.coordinate.Coordinate;
import core.exception.AppException;

public class RoverImpl implements Rover, Runnable {

    private Coordinate coordinate;
    private final int id;
    private boolean shouldRun = false;
    private MovementProvider controller;
    private boolean activate = false;
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
        if (activate) {
            throw new AppException(this.toString() + " can not be activated again");
        }
        this.coordinate = coordinate;
        activate = true;
        shouldRun = true;
        System.out.println("everybody, buckle up please!" + this.toString() + " on the move.");
        new Thread(this, this.toString()).start();
    }

    @Override
    public void move() {
        System.out.println("Visited " + coordinate.toString() + "by " + this.toString());
        collector.collect(this.coordinate);
        try {
            coordinate = controller.nextMove(this.coordinate);
        } catch (AppException e) {
            e.printStackTrace();
            System.out.println(this.toString() + " stopping itself");
            this.stop();
        }
    }

    @Override
    public void stop() {
        if (!activate) {
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
    public void dump() {

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
        }
    }

    @Override
    public String toString() {
        return "Rover " + this.getId();
    }
}
