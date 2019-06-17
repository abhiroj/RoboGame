package core.elements.rover;

import core.controller.RoverManager;
import core.elements.coordinate.Coordinate;
import core.exception.AppException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RoverImpl implements Rover, Runnable {

    private Coordinate coordinate;
    private final int id;
    private List<Map<String, Object>> repository;
    private boolean shouldRun = false;
    private RoverManager controller;
    private boolean activate = false;

    public RoverImpl(int id) {
        this.id = id;
        repository = new ArrayList<>();
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
        activate = true;
        shouldRun = true;
        System.out.println("everybody, buckle up please!" + this.toString() + " on the move.");
        new Thread(this, this.toString()).start();
    }

    @Override
    public void move() {
        System.out.println("Visited " + coordinate.toString() + "by " + this.toString());
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
    public void setController(RoverManager handler) {
        this.controller = handler;
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
