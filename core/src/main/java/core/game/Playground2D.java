package core.src.main.java.core.game;

import core.src.main.java.core.exception.AppException;

import java.util.ArrayList;
import java.util.List;

class Playground2D implements Playground {

    private final Shape[][] shape2D;

    Playground2D(Shape[][] shape2D) {
        this.shape2D = shape2D;
    }

    @Override
    public List<Coordinate> getBoundaryCoordinates() {
        List<Coordinate> originCoordinate = new ArrayList<>();
        originCoordinate.add(shape2D[0][0].getCoordinate());
        originCoordinate.add(shape2D[shape2D.length - 1][shape2D[0].length - 1].getCoordinate());
        return originCoordinate;
    }

    @Override
    public Type getDimensionType() {
        return Type.TWOD;
    }

    @Override
    public Shape getShapeAtCoordinate(Coordinate c) {
        if (c.getDimensionType() != Type.TWOD)
            throw new AppException("Illegal Method Access!");
        for (Shape[] row : shape2D) {
            for (Shape col : row) {
                if (col.getCoordinate().equals(c))
                    return col;
            }
        }
        throw new AppException("Shape does not exist!");
    }
}
