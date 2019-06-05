package core.src.main.java.core.game;

import core.src.main.java.core.controller.GameController;

public interface Rover {

    int getId();

    void move();

    void stop();

    void setStartingCoordinate(Coordinate coordinates);

    Coordinate getCurrentCoordinate();

    void dump();

    void setGameController(GameController handler);

}
