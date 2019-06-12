package controller;

import core.src.main.java.core.controller.GameController;
import core.src.main.java.core.exception.AppException;
import core.src.main.java.core.game.Coordinate;
import core.src.main.java.core.game.Playground;
import core.src.main.java.core.game.Rover;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CLIGameController implements GameController {

    List<Rover> deployedRovers;
    List<Coordinate> visitedCoordinates;
    Playground playground;

    public CLIGameController() {
        deployedRovers = new ArrayList<>();
        visitedCoordinates = new ArrayList<>();
    }

    public void deploy(Rover rover) {
        if (!isValid(rover.getCurrentCoordinate())) {
            throw new AppException("Not valid coordinates" + rover.getCurrentCoordinate());
        }
        rover.activate();
        deployedRovers.add(rover);
    }

    public void demobilze(Rover rover) {
        if (!deployedRovers.contains(rover)) {
            throw new AppException(rover.toString() + " not deployed! unable to demobilize.");
        }
        rover.stop();
        deployedRovers.remove(rover);
    }

    public Coordinate nextMove(Coordinate coordinate) {
        visitedCoordinates.add(coordinate);
        Coordinate c = new Coordinate(coordinate.getX() + 1, coordinate.getY() + 1);
        return isValid(c) ? c : null;
    }

    public void setPlayground(Playground playground) {
        this.playground = playground;
    }

    public Playground getPlayground() {
        return playground;
    }

    public Map<String, Object> collect(Coordinate coordinate) {
        return null;
    }

    private boolean isValid(Coordinate coordinate) {
        if (coordinate == null || visitedCoordinates.contains(coordinate)) {
            return false;
        }
        List<Coordinate> list = playground.getCoordinateBounds();
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
        if (coordinate.lessThan(min) || coordinate.greaterThan(max) || !coordinate.equalTo(max))
            return false;
        return true;
    }
}
