package core.src.main.java.core.game;

import java.util.HashMap;

public abstract class ShapeFactory {

    public abstract Shape[][] request2DShapeAsArray(int x, int y);

    public abstract Shape[][][] request3DShapeAsArray(int x, int y, int z);

}
