package core.src.main.java.core.game;

import core.src.main.java.core.exception.AppException;
import core.src.main.java.core.utilities.CoreUtils;

public class Coordinate {

    enum Type {
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

    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
        this.dimension = Type.TWOD;
    }

    Coordinate(int x, int y, int z) {
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
    public String toString() {
        if (this.dimension.equals(Type.TWOD))
            return CoreUtils.format("{},{}", x, y);
        return CoreUtils.format("{},{},{} ", x, y, z);
    }
}
