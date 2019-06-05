package core.src.main.java.core.controller;

import core.src.main.java.core.game.Coordinate;
import core.src.main.java.core.game.Playground;
import core.src.main.java.core.game.Rover;

import java.util.Map;

public interface GameController {

    void deploy(Rover rover);

    void demobilze(Rover rover);

    boolean shouldMove(Rover rover);

    void setPlayground(Playground playground);

    Playground getPlayground();

    Map<String, Object> collect(Coordinate coordinate);

    void pause();

    void resume();

}
