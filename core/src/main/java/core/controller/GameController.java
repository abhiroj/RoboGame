package core.src.main.java.core.controller;

import core.src.main.java.core.game.Playground;
import core.src.main.java.core.game.PlaygroundFactory;

public class GameController {

    Playground playground;

    public void create2DGame(int x, int y) {
        System.out.println("Constructing 2D Game...");
        playground = PlaygroundFactory.getInstance().get2DPlayground(x, y);
        System.out.println("Constructed 2D Game");
    }

    public void create3DGame(int x, int y, int z) {
        System.out.println("Feature coming soon...");
    }



}
