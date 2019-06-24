package core.elements.shape;

import core.elements.coordinate.Coordinate;

/**
 * defines abstract shape contract for the system.
 * This class encapsulates the mapping of coordinate.
 *
 * @implNote Implementation should be initialized with coordinate {@link Coordinate} which will locate the class.
 */
public interface AbstractShape {

    Coordinate getCoordinate();

}