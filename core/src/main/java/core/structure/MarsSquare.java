package core.src.main.java.core.structure;

import core.src.main.java.core.action.Visitable;
import core.src.main.java.core.collection.Collectable;
import core.src.main.java.core.properties.weather.Weather;

import java.util.HashMap;
import java.util.Map;

public class MarsSquare implements Square, Collectable, Visitable {

    private Weather weather;
    private final int x;
    private final int y;

    private boolean visit = false;

    public MarsSquare(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public Map<String, Object> collect() {
        Map<String, Object> map = new HashMap<>();
        map.put(getCoordinates(), weather.toString());
        return map;
    }

    private String getCoordinates() {
        return x + " " + y;
    }

    @Override
    public boolean isVisited() {
        return visit;
    }

    @Override
    public void markVisited() {
        visit = true;
    }
}

