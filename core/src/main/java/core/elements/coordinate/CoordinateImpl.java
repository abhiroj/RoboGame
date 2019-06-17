package core.elements.coordinate;

import core.elements.DimensionType;
import core.exception.AppException;
import core.utilities.CoreUtils;

import java.util.InputMismatchException;
import java.util.Map;

public class CoordinateImpl implements Comparable<Coordinate>, Coordinate {

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
        int var1 = x * 10 + y;
        int var2 = c.getX() * 10 + c.getY();
        return var1 == var2;
    }

    @Override
    public String toString() {
        return CoreUtils.format("x:{0} y:{1} ", x, y);
    }

    @Override
    public boolean lessThan(Coordinate c) {
        if (this.getDimensionType() != c.getDimensionType()) {
            throw new AppException("Can't compare oranges with apples", new InputMismatchException());
        }
        return this.getX() < c.getX() || this.getY() < c.getY();
    }

    @Override
    public boolean greaterThan(Coordinate c) {
        if (this.getDimensionType() != c.getDimensionType()) {
            throw new AppException("Can't compare oranges with apples", new InputMismatchException());
        }
        return this.getX() > c.getX() || this.getY() > c.getY();
    }

    @Override
    public boolean equalTo(Coordinate c) {
        if (this.getDimensionType() != c.getDimensionType()) {
            throw new AppException("Can't compare oranges with apples", new InputMismatchException());
        }
        return this.getX() == c.getX() || this.getY() == c.getY();
    }

    @Override
    public int compareTo(Coordinate o) {
        if (lessThan(o)) return -1;
        if (greaterThan(o)) return 1;
        return 0;
    }


}
