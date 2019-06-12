package core.src.main.java.core.game;

import core.src.main.java.core.exception.AppException;
import core.src.main.java.core.utilities.CoreUtils;

import java.util.InputMismatchException;

public class Coordinate implements Comparable<Coordinate> {

    public enum Type {
        TWOD("Two-Dimensional "), THREED("Three-Dimensional ");

        private String s;

        Type(String s) {
            this.s = s;
        }

        public String valueOf() {
            return s;
        }

    }

    private int x;
    private int y;
    private int z;
    private Type dimension;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
        this.dimension = Type.TWOD;
    }

    public Coordinate(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.dimension = Type.THREED;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getZ() {
        if (!this.dimension.equals(Type.THREED)) {
            throw new AppException("Z-Axis not supported by " + this.dimension.valueOf());
        }
        return this.z;
    }

    public Type getDimensionType() {
        return dimension;
    }

    @Override
    public int hashCode() {
        if (this.dimension.equals(Type.TWOD)) {
            int var1 = x * 10 + y;
            return var1;
        }
        return x * 100 + y * 10 + z;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Coordinate)) {
            return false;
        }
        Coordinate c = (Coordinate) obj;
        if (this.dimension.equals(Type.TWOD)) {
            int var1 = x * 10 + y;
            int var2 = c.getX() * 10 + c.getY();
            return var1 == var2;
        }
        int var1 = x * 100 + y * 10 + z;
        int var2 = x * 100 + y * 10 + z;
        return var1 == var2;
    }

    @Override
    public String toString() {
        if (this.dimension.equals(Type.TWOD))
            return CoreUtils.format("x:{0} y:{1} ", x, y);
        return CoreUtils.format("x:{0} y:{1} z:{2} ", x, y, z);
    }

    public boolean lessThan(Coordinate c) {
        if (this.getDimensionType() != c.getDimensionType()) {
            throw new AppException("Can't compare oranges with apples", new InputMismatchException());
        }
        return (getDimensionType() == Type.THREED)?this.getX() < c.getX() || this.getY() < c.getY() || this.getZ() < c.getZ() : this.getX() < c.getX() || this.getY() < c.getY();
    }

    public boolean greaterThan(Coordinate c) {
        if (this.getDimensionType() != c.getDimensionType()) {
            throw new AppException("Can't compare oranges with apples", new InputMismatchException());
        }
        return (getDimensionType() == Type.THREED)?this.getX() > c.getX() || this.getY() > c.getY() || this.getZ() > c.getZ() : this.getX() > c.getX() || this.getY() > c.getY();
    }

    public boolean equalTo(Coordinate c) {
        if (this.getDimensionType() != c.getDimensionType()) {
            throw new AppException("Can't compare oranges with apples", new InputMismatchException());
        }
        return (getDimensionType() == Type.THREED)?this.getX() == c.getX() || this.getY() == c.getY() ||  this.getZ() == c.getZ():this.getX() == c.getX() || this.getY() == c.getY();
    }

    @Override
    public int compareTo(Coordinate o) {
        if (lessThan(o)) return -1;
        if (greaterThan(o)) return 1;
        return 0;
    }


}
