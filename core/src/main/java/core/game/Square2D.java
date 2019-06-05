package core.src.main.java.core.game;

import java.util.HashMap;
import java.util.Map;

class Square2D implements Shape {

    private Map<PropType, Object> propTypeObjectMap;
    private Coordinate coordinate;
    private boolean visited;

    Square2D(Coordinate coordinate) {
        this.coordinate = coordinate;
        visited = false;
        propTypeObjectMap = new HashMap<>();
        propTypeObjectMap.put(PropType.WEATHER, "22F");
        propTypeObjectMap.put(PropType.HUMIDITY, "31H");
        propTypeObjectMap.put(PropType.UVRAD, "10SPF");
    }

    @Override
    public Map<PropType, Object> getProperties() {
        return null;
    }

    @Override
    public Coordinate getCoordinate() {
        return new Coordinate(coordinate.getX(), coordinate.getY());
    }
}
