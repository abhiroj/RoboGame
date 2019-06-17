package core.elements.playground;

import core.elements.DimensionType;
import core.elements.coordinate.Coordinate;
import core.elements.shape.Shape;

import java.util.List;

public interface Playground {

    /**
     * @return
     */
    List<Coordinate> getBoundaryCoordinates();

    DimensionType getDimensionType();

    Shape getShapeAtCoordinate(Coordinate c);

}
