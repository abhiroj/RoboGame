package core.elements.shape;

import core.elements.Properties;
import core.elements.coordinate.Coordinate;

/**
 * defines abstract shape contract for the system.
 * This class encapsulates the mapping of coordinate with property associated.
 */
//TODO:Add copyright
public interface Shape {

    Properties getProperties();

    Coordinate getCoordinate();

}
