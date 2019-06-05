package core.src.main.java.core.game;

import java.util.HashMap;
import java.util.Map;

class Square implements Shape {

    private Map<PropType, Object> propTypeObjectMap;
    private Coordinate coordinate;
    private boolean visited;

    Square(Coordinate coordinate) {
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
        if (coordinate.getDimensionType() == Coordinate.Type.TWOD)
            return new Coordinate(coordinate.getX(), coordinate.getY());
        return new Coordinate(coordinate.getX(), coordinate.getY(), coordinate.getZ());
    }
}
