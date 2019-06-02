package core.src.main.java.core.game;

import core.src.main.java.core.api.Property;

import java.util.Map;

class Square2D implements Square {

    private Map<PropType, Property> propTypeObjectMap;
    private final int x;
    private final int y;
    private boolean visited;

    public Square2D(int x, int y) {
        this.x = x;
        this.y = y;
        visited = false;
    }

    @Override
    public boolean canVisit() {
        return !visited;
    }

    @Override
    public void markVisited() {
        visited = true;
    }
}
