package core.elements.coordinate;

import core.elements.DimensionType;
import core.exception.AppException;
import core.utilities.CoreUtils;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;

public class CoordinateImpl implements Coordinate {

    private int x;
    private int y;
    private DimensionType dimension;

    public CoordinateImpl(int x, int y) {
        this.x = x;
        this.y = y;
        this.dimension = DimensionType.TWOD;
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public int getZ() {
        throw new AppException("Z-Axis not supported by " + this.dimension.valueOf());
    }

    @Override
    public Map<CoordinateType, Integer> getCoordinates() {
        return Map.of(CoordinateType.X, x, CoordinateType.Y, y);
    }

    @Override
    public DimensionType getDimensionType() {
        return dimension;
    }

    @Override
    public int hashCode() {
        if (this.dimension.equals(DimensionType.TWOD)) {
            int var1 = x * 10 + y;
            return var1;
        }
        return x * 10 + y;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof CoordinateImpl)) {
            return false;
        }
        Coordinate c = (Coordinate) obj;
        if (this.getDimensionType() != c.getDimensionType()) {
            throw new AppException("can not compare " + this.getDimensionType().valueOf() + " with " + c.getDimensionType().valueOf(), new InputMismatchException());
        }
        return this.getCoordinates().equals(c.getCoordinates());
    }

    @Override
    public String toString() {
        return CoreUtils.format("x:{0} y:{1} ", x, y);
    }

    @Override
    public List<Coordinate> nextPossibleCoordinates() {
        List moves = new ArrayList();
        moves.addAll(getForwardCoordinates());
        moves.addAll(getBackwardCoordinates());
        return moves;
    }

    private List<Coordinate> getForwardCoordinates() {
        Coordinate f1 = new CoordinateImpl(this.x + 1, this.y);
        Coordinate f2 = new CoordinateImpl(this.x, this.y + 1);
        return List.of(f1, f2);
    }

    private List<Coordinate> getBackwardCoordinates() {
        Coordinate f1 = new CoordinateImpl(this.x - 1, this.y);
        Coordinate f2 = new CoordinateImpl(this.x, this.y - 1);
        return List.of(f1, f2);
    }


}
