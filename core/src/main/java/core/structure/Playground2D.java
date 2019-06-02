package core.src.main.java.core.structure;

import core.src.main.java.core.exception.AppException;

import java.util.HashMap;
import java.util.Map;

public class Playground2D implements Playground, Rover.EventListener {

    public static class Boundary implements Playground.Boundary {

        private final int limitX;
        private final int limitY;

        public Boundary(int limitX, int limitY) {
            this.limitX = limitX;
            this.limitY = limitY;
        }

        @Override
        public Map<Dimensional, Integer> getBounds() {
            return Map.of(Dimensional.X, limitX, Dimensional.Y, limitY);
        }
    }

    public Playground2D(Boundary boundary) {
        this.boundary = boundary;
        nodes = new Square2D[boundary.getBounds().get(Dimensional.X)][boundary.getBounds().get(Dimensional.Y)];
        deployedRovers = new HashMap<>();
    }

    private Map<Integer, Rover> deployedRovers;
    private Boundary boundary;
    private Square2D[][] nodes;

    @Override
    public void deploy(Rover rover, int x, int y) {
        if (!deployedRovers.containsKey(rover.getId())) {
            throw new AppException("rover already deployed on the playground");
        }
        rover.setInitialCoordinate(x, y);
        rover.start();
    }

    @Override
    public void demobilize(Rover rover) {
        rover.stop();
        deployedRovers.remove(rover.getId());
    }

    @Override
    public boolean canMove(int x, int y) {
        return false;
    }


}