package core.src.main.java.core.structure;

import java.util.Map;

public interface Rover {

    interface EventListener {

        boolean canMove(int x, int y);

    }

    interface Collectable{

    }

    enum Directional {
        UP(0, 1), DOWN(0, -1), LEFT(-1, 0), RIGHT(1, 0);

        final int x;
        final int y;

        Directional(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    void start();

    int getId();

    void setInitialCoordinate(int x, int y);

    void stop();

    void registerEventListener(EventListener eventListener);

    void unregisterEventListener();

}
