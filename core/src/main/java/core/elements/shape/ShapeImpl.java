package core.elements.shape;

import core.elements.PropertyType;
import core.elements.coordinate.Coordinate;

import java.util.Properties;

//TODO:Add copyright

/**
 * A basic implementation of shape class providing features from sandbox
 */
public class ShapeImpl implements SandboxShape {

    private Properties properties;
    private final Coordinate coordinate;

    /**
     * The constructor sets some properties by default. Default properties can be replaced using setters.
     *
     * @param coordinate
     */
    public ShapeImpl(Coordinate coordinate) {
        this.coordinate = coordinate;
        properties = new Properties();
        properties.put(PropertyType.WEATHER, "22F");
        properties.put(PropertyType.HUMIDITY, "31H");
        properties.put(PropertyType.UVRAD, "unit");
    }


    @Override
    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public Properties getProperties() {
        return properties;
    }

    @Override
    public Coordinate getCoordinate() {
        return coordinate;
    }
}
