package core.src.main.java.core.game;

import java.util.Map;

public interface Playground {

    void deploy(Rover rover);

    void demobilize(Rover rover);

    Map<Object, Object> collectable(Coordinate coordinate);

    void checkBounds(Coordinate coordinate);

    boolean isValid(Coordinate coordinate);
}
