package core.src.main.java.core.game;

import core.src.main.java.core.controller.GameController;

import java.util.Map;

public interface EventHandler {

    Map<String, Object> collect(Coordinate coordinate);

    boolean shouldMove(Coordinate coordinate);

    void requestDemobilization(Rover rover);

    void registerController(GameController gameController);
}
