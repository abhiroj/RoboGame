package core.src.main.java.core.move;

import core.src.main.java.core.exception.AppException;

public class Robo {

    private enum Direction {
        L(-1, 0), R(1, 0), U(0, -1), D(0, 1);

        private final int delx;
        private final int dely;

        Direction(int delx, int dely) {
            this.delx = delx;
            this.dely = dely;
        }
    }

    private Direction primary = null;
    private Direction secondary = null;

    private static final Direction LEFT = Direction.L;
    private static final Direction RIGHT = Direction.R;
    private static final Direction UP = Direction.U;
    private static final Direction DOWN = Direction.D;

    public void setPrimaryDirection(Direction d) {
        if (secondary != null && secondary.equals(d)) {
            throw new AppException("Exists as secondary direction!");
        }
        primary = d;
    }

    public void setSecondaryDirection(Direction d) {
        if (primary != null && primary.equals(d)) {
            throw new AppException("Exists as primary direction!");
        }
        secondary = d;
    }

}

