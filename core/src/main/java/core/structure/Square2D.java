package core.src.main.java.core.structure;

import core.src.main.java.core.collection.Collectable;
import core.src.main.java.core.exception.AppException;

import java.util.Map;

public class Square2D implements Shape, Collectable {

    private boolean isVisited;
    private final int x;
    private final int y;

    public Square2D(int x, int y) {
        isVisited = false;
        this.x = x;
        this.y = y;
    }

    public boolean canVisit() {
        return !isVisited;
    }

    public void markVisit() {
        if (canVisit()) {
            throw new AppException(x + "," + y + " square is already visited");
        }
        isVisited = true;
    }

    @Override
    public boolean isCollectable() {
        return true;
    }

    @Override
    public Map<String, Object> provide() {
        return null;
    }
}
