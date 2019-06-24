package core.elements.playground;

import core.elements.coordinate.Coordinate;
import core.elements.shape.SandboxShape;

import java.util.List;

/**
 * Playground can be implemented as adjacency list or adjacency array
 */
public interface Playground {

    /**
     * get the layout of the playground.
     *
     * @return
     */
    List<Coordinate> getCoordinates();

    /**
     * get SandboxShape present at the coordinate
     *
     * @param c
     * @return
     */
    SandboxShape getShapeAtCoordinate(Coordinate c);

}
