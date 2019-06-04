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
        for (int i = 0; i < dimen_x; i++) {
            for (int j = 0; j < dimen_y; j++) {
                square2D[i][j] = new Square2D(i, j);
            }
        }
    }

    @Override
    public void deploy(Rover rover) {
        rover.move();
    }

    @Override
    public void demobilize(Rover rover) {
        System.out.println(rover.getId() + " requesting demobilization!");
        rover.stop();
    }

    @Override
    public Map<Object, Object> collectable(Coordinate coordinate) {
        Map<Shape.PropType, Object> map = square2D[coordinate.getX()][coordinate.getY()].collect();
        Map<Object, Object> res = new HashMap<>();
        for (Map.Entry e : map.entrySet()) {
            Shape.PropType s = (Shape.PropType) e.getKey();
            Object val = e.getValue();
            res.put(s, val);
        }
        square2D[coordinate.getX()][coordinate.getY()].markVisited();
        return res;
    }

    @Override
    public void checkBounds(Coordinate coordinate) {
        if (!coordinate.getDimensionType().equals(Coordinate.Type.TWOD)) {
            throw new AppException("Cannot deploy " + coordinate.getDimensionType().valueOf() + " Rover on a Two-Dimensional Playground");
        }
        if (coordinate.getX() < 0 || coordinate.getX() >= dimen_x || coordinate.getY() < 0 || coordinate.getY() >= dimen_y) {
            throw new AppException("Out of Bounds request can not be fulfilled");
        }
    }

    @Override
    public boolean isValid(Coordinate coordinate) {
        return square2D[coordinate.getX()][coordinate.getY()].canVisit();
    }
}
