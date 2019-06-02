package core.src.main.java.core.game;

class Coordinate {

    enum Type {
        TWOD("Two-Dimensional"), THREED("Three-Dimensional");

        private String s;

        Type(String s) {
            this.s = s;
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

}
