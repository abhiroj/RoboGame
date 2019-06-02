package core.src.main.java.core.game;

import java.util.HashMap;
import java.util.Map;

class Square2D implements Shape {

    private Map<PropType, Object> propTypeObjectMap;
    private final int x;
    private final int y;
    private boolean visited;

    Square2D(int x, int y) {
        this.x = x;
        this.y = y;
        visited = false;
        propTypeObjectMap = new HashMap<>();
        propTypeObjectMap.put(PropType.WEATHER, "22F");
        propTypeObjectMap.put(PropType.HUMIDITY, "31H");
        propTypeObjectMap.put(PropType.UVRAD, "10SPF");
    }

    @Override
    public boolean canVisit() {
        return !visited;
    }

    @Override
    public void markVisited() {
        visited = true;
    }

    @Override
    public Map<PropType, Object> collect() {
        return propTypeObjectMap;
    }
}
