package core.elements.shape;

import core.elements.Properties;
import core.elements.PropertyType;
import core.elements.coordinate.Coordinate;

import java.util.HashMap;
import java.util.Map;

//TODO:Add copyright
public class ShapeImpl implements Shape {

    private final Map<PropertyType, Object> propTypeObjectMap;
    private final Coordinate coordinate;

    public ShapeImpl(Coordinate coordinate) {
        this.coordinate = coordinate;
        propTypeObjectMap = new HashMap<>();
        propTypeObjectMap.put(PropertyType.WEATHER, "22F");
        propTypeObjectMap.put(PropertyType.HUMIDITY, "31H");
        propTypeObjectMap.put(PropertyType.UVRAD, "unit");
    }

    @Override
    public Properties getProperties() {
        return new Properties() {
            @Override
            public String get() {
                return propTypeObjectMap.toString();
            }
        };
    }

    @Override
    public Coordinate getCoordinate() {
        return coordinate;
    }
}
