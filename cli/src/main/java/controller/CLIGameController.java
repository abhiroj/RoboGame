package controller;

import core.src.main.java.core.controller.GameController;
import core.src.main.java.core.exception.AppException;
import core.src.main.java.core.game.Coordinate;
import core.src.main.java.core.game.Playground;
import core.src.main.java.core.game.Rover;
import core.src.main.java.core.game.Type;

import java.util.*;

public class CLIGameController implements GameController {

    List<Rover> deployedRovers;
    List<Coordinate> visitedCoordinates;
    Playground playground;

    public CLIGameController() {
        deployedRovers = new ArrayList<>();
        visitedCoordinates = new ArrayList<>();
    }

    @Override
    public void deploy(Rover rover) {
        if (rover.getCurrentCoordinate() == null) {
            rover.setCoordinate(getFirstValidCoordinate());
        } else if (visited(rover.getCurrentCoordinate()) || !inBounds(rover.getCurrentCoordinate())) {
            throw new AppException("Not valid coordinates " + rover.getCurrentCoordinate());
        }
        rover.activate();
        deployedRovers.add(rover);
    }

    private Coordinate getFirstValidCoordinate() {
        Coordinate c1 = null;
        List<Coordinate> list = playground.getBoundaryCoordinates();
        Coordinate min = new Coordinate(Integer.MAX_VALUE, Integer.MAX_VALUE);
        for (Coordinate c : list) {
            if (c.lessThan(min)) {
                min = c;
            }
        }
        c1 = nextPossibleCoordinate(min);
        return c1;
    }

    private Coordinate nextPossibleCoordinate(Coordinate c) {
        Queue<Coordinate> counter = new LinkedList<>();
        if (c.getDimensionType() == Type.TWOD) {
            counter.offer(new Coordinate(c.getX() + 1, c.getY()));
            counter.offer(new Coordinate(c.getX() - 1, c.getY()));
            counter.offer(new Coordinate(c.getX(), c.getY() + 1));
            counter.offer(new Coordinate(c.getX(), c.getY() - 1));
        } else if (c.getDimensionType() == Type.THREED) {
            counter.offer(new Coordinate(c.getX() + 1, c.getY() + 1, c.getZ() + 1));
            counter.offer(new Coordinate(c.getX() + 1, c.getY(), c.getZ()));
            counter.offer(new Coordinate(c.getX(), c.getY() + 1, c.getZ()));
            counter.offer(new Coordinate(c.getX(), c.getY(), c.getZ() + 1));
            counter.offer(new Coordinate(c.getX() + 1, c.getY() + 1, c.getZ()));
            counter.offer(new Coordinate(c.getX(), c.getY() + 1, c.getZ() + 1));
        }
        do {
            c = counter.poll();
            if (!inBounds(c)) {
                continue;
            }
            if (!visited(c)) {
                return c;
            }
        } while (!counter.isEmpty());
        throw new AppException("No Possible coordinate found!");
    }

    @Override
    public void demobilze(Rover rover) {
        if (!deployedRovers.contains(rover)) {
            throw new AppException(rover.toString() + " not deployed! unable to demobilize.");
        }
        rover.stop();
        deployedRovers.remove(rover);
    }

    @Override
    public synchronized Coordinate nextMove(Coordinate coordinate) {
        visitedCoordinates.add(coordinate);
        Coordinate c = nextPossibleCoordinate(coordinate);
        return isValid(c) ? c : null;
    }

    public void setPlayground(Playground playground) {
        this.playground = playground;
    }

    public Playground getPlayground() {
        return playground;
    }

    @Override
    public Map<String, Object> collect(Coordinate coordinate) {
        return null;
    }

    private boolean visited(Coordinate coordinate) {
        if (coordinate == null || visitedCoordinates.contains(coordinate)) {
            return true;
        }
        return false;
    }

    private boolean inBounds(Coordinate coordinate) {
        List<Coordinate> list = playground.getBoundaryCoordinates();
        Coordinate max = new Coordinate(-1, -1);
        Coordinate min = new Coordinate(Integer.MAX_VALUE, Integer.MAX_VALUE);
        for (Coordinate c : list) {
            if (c.lessThan(min)) {
                min = c;
            }
            if (c.greaterThan(max)) {
                max = c;
            }
        }
        boolean lessThan = coordinate.lessThan(min);
        boolean greaterThan = coordinate.greaterThan(max);
        if (lessThan || greaterThan)
            return false;
        return true;
    }

    private boolean isValid(Coordinate c) {
        return !(visited(c) || !inBounds(c));
    }
}
