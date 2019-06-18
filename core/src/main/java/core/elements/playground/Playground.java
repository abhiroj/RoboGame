package core.elements.playground;

import core.elements.DimensionType;
import core.elements.coordinate.Coordinate;
import core.elements.shape.Shape;

import java.util.List;

public interface Playground {

    /**
     * get boundary limits for a coordinate
     *
     * @return
     */
    List<Coordinate> getBoundaryCoordinates();

    /**
     * get dimensional type of playground
     *
     * @return
     */
    DimensionType getDimensionType();

    /**
     * get Shape present at the coordinate
     *
     * @param c
     * @return
     */
    Shape getShapeAtCoordinate(Coordinate c);

}
