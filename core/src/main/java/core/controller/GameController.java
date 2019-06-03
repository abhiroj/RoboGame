package core.src.main.java.core.controller;

import core.src.main.java.core.game.*;

import java.util.HashMap;
import java.util.Map;

//TODO: Create an abstract game controller, this one focuses more towards 2D game
public class GameController {

    Playground playground;
    MessageHandler messageHandler;

    public GameController() {
        messageHandler = (MessageHandler) this;
    }

    public GameController(MessageHandler messageHandler) {
        this.messageHandler = messageHandler;
    }

    public void create2DGame(int x, int y) {
        System.out.println("Constructing 2D Game...");
        playground = PlaygroundFactory.getInstance().get2DPlayground(x, y);
        System.out.println("Constructed 2D Game");
    }

    public void deploy(int x, int y) {
        Rover rover = RoverFactory.getInstance().request2DRover(x, y);
        rover.setMessageHandler(messageHandler);
        playground.deploy(rover);
    }

    public void demobilize(int id) {

    }

    public Map<String, Object> collect(Coordinate coordinate) {
        Map<Object, Object> collection = playground.collectable(coordinate);
        Map<String, Object> res = new HashMap<>();
        for (Map.Entry e : collection.entrySet()) {
            res.put(e.getKey().toString(), e.getValue());
        }
        return res;
    }

    public boolean shouldMove(Coordinate coordinate) {
        playground.checkBounds(coordinate);
        return playground.isValid(coordinate);
    }
}
