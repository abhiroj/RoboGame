package core.src.main.java.core.context;

import core.src.main.java.core.structure.Playground;
import core.src.main.java.core.structure.Playground2D;

public class GameContext {

    private Playground playground;
    private Playground.Boundary boundary;

    public void init2DGame(int x, int y) {
        boundary = new Playground2D.Boundary(x, y);
        playground = new Playground2D((Playground2D.Boundary) boundary);
    }

}
