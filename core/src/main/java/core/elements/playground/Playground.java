package core.elements.playground;

import core.elements.coordinate.Coordinate;
import core.elements.shape.Shape;

import java.util.List;

public interface Playground {

    /**
     * get the layout of the playground.
     *
     * @return
     */
    List<Coordinate> getCoordinates();

    /**
     * get Shape present at the coordinate
     *
     * @param c
     * @return
     */
    Shape getShapeAtCoordinate(Coordinate c);

}
