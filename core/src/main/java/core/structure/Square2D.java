package core.src.main.java.core.structure;

import core.src.main.java.core.exception.AppException;

import java.util.Map;

public class Square2D implements Square {

    private final Coordinate coordinate;
    private boolean isVisited;

    private static class Coordinate implements Square.Coordinate {

        private final int x;
        private final int y;

        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public Map<Dimensional, Integer> getCoordinates() {
            return Map.of(Dimensional.X, x, Dimensional.Y, y);
        }
    }

    public Square2D(int locX, int locY) {
        this.coordinate = new Coordinate(locX, locY);
        isVisited = false;
    }

    public boolean canVisit() {
        return !isVisited;
    }

    public void markVisit() {
        if (canVisit()) {
            throw new AppException(this.coordinate.getCoordinates().toString() + " square is already visited");
        }
        isVisited = true;
    }

}
