package core.src.main.java.core.game;

import core.src.main.java.core.exception.AppException;

import java.util.HashMap;
import java.util.Map;

class Playground2D implements Playground {

    private final int dimen_x;
    private final int dimen_y;
    private final Square2D[][] square2D;

    Playground2D(int dimen_x, int dimen_y) {
        this.dimen_x = dimen_x;
        this.dimen_y = dimen_y;
        square2D = new Square2D[this.dimen_x][this.dimen_y];
    }

    @Override
    public void deploy(Rover rover) {
        checkDimension(rover.getCoordinate().getDimensionType());
        checkBounds(rover.getCoordinate());
        checkDeploymentAvailable(rover.getCoordinate());
        rover.move();
    }

    private void checkDeploymentAvailable(Coordinate coordinate) {
        if (!square2D[coordinate.getX()][coordinate.getY()].canVisit()) {
            throw new AppException(coordinate.toString() + " Shape is already visited. Choose a new version next time");
        }
    }

    @Override
    public void demobilize(Rover rover) {

    }

    @Override
    public Map<Object, Object> collectable(Coordinate coordinate) {
        checkBounds(coordinate);
        Map<Shape.PropType, Object> map = square2D[coordinate.getX()][coordinate.getY()].collect();
        Map<Object, Object> res = new HashMap<>();
        for (Map.Entry e : map.entrySet()) {
            Shape.PropType s = (Shape.PropType) e.getKey();
            Object val = e.getValue();
            res.put(s, val);
        }
        return res;
    }

    private void checkDimension(Coordinate.Type dimensionType) {
        if (!dimensionType.equals(Coordinate.Type.TWOD)) {
            throw new AppException("Cannot deploy " + dimensionType.valueOf() + " Rover on a Two-Dimensional Playground");
        }
    }

    private void checkBounds(Coordinate coordinate) {
        if (coordinate.getX() < 0 || coordinate.getX() >= dimen_x || coordinate.getY() < 0 || coordinate.getY() >= dimen_y) {
            throw new AppException("Out of Bounds request can not be fulfilled");
        }
    }
}
