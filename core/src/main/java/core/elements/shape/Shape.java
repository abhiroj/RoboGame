package core.elements.shape;

import core.elements.coordinate.Coordinate;

import java.util.Properties;

/**
 * defines abstract shape contract for the system.
 * This class encapsulates the mapping of coordinate with property associated.
 */
//TODO:Add copyright
public interface Shape {

    Properties getProperties();

    void setProperties(Properties properties);

    Coordinate getCoordinate();

}
