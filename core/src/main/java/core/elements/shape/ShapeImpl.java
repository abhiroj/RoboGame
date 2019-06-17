package core.elements.shape;

import core.elements.PropertyType;
import core.elements.coordinate.Coordinate;

import java.util.HashMap;
import java.util.Map;

public class ShapeImpl implements Shape {

    private Map<PropertyType, Object> propTypeObjectMap;
    private Coordinate coordinate;
    private boolean visited;

    public ShapeImpl(Coordinate coordinate) {
        this.coordinate = coordinate;
        visited = false;
        propTypeObjectMap = new HashMap<>();
        propTypeObjectMap.put(PropertyType.WEATHER, "22F");
        propTypeObjectMap.put(PropertyType.HUMIDITY, "31H");
        propTypeObjectMap.put(PropertyType.UVRAD, "10SPF");
    }

    @Override
    public Map<PropertyType, Object> getProperties() {
        return null;
    }

    @Override
    public Coordinate getCoordinate() {
        return coordinate;
    }
}
