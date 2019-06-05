package controller;

import core.src.main.java.core.controller.GameController;
import core.src.main.java.core.exception.AppException;
import core.src.main.java.core.game.Coordinate;
import core.src.main.java.core.game.Playground;
import core.src.main.java.core.game.Rover;

import java.util.ArrayList;
import java.util.HashMap;
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
        if (visitedCoordinates.contains(rover.getCurrentCoordinate())) {
            throw new AppException("Unable to deploy rover " + rover.getId());
        }
        deployedRovers.add(rover);
        rover.setGameController(this);
        rover.move();
        System.out.println("Rover " + rover.getId() + " successfully deployed");
    }

    public void demobilze(Rover rover) {
        rover.stop();
        deployedRovers.remove(rover);
        System.out.println("Rover " + rover.getId() + " successfully demobilized");
    }

    public boolean shouldMove(Rover rover) {
        if (visitedCoordinates.contains(rover.getCurrentCoordinate()) && checkBounds(rover.getCurrentCoordinate()))
            return false;
        return true;
    }

    public void setPlayground(Playground playground) {
        this.playground = playground;
    }

    public Playground getPlayground() {
        return playground;
    }

    @Override
    public Map<String, Object> collect(Coordinate coordinate) {
        return new HashMap<>();
    }

    private boolean checkBounds(Coordinate coordinate) {
        List<Coordinate> list = playground.getDimensions();
        for (Coordinate outbound : list) {
            if (outbound.getDimensionType() != coordinate.getDimensionType() && outbound.getX() <= coordinate.getX() && outbound.getY() <= coordinate.getY())
                return false;
        }
        return true;
    }
}
