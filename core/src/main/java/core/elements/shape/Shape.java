package core.elements.shape;

import core.elements.Properties;
import core.elements.coordinate.Coordinate;

/**
 * defines abstract shape contract for the system.
 * This call encapsulates the mapping of coordinate with property associated
 */
public interface Shape {

    Properties getProperties();

    Coordinate getCoordinate();

}
