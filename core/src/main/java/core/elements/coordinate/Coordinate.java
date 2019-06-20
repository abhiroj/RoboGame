package core.elements.coordinate;


import core.elements.DimensionType;

import java.util.List;
import java.util.Map;

public interface Coordinate {

    /**
     * @return
     * @deprecated use <code>getCoordinates instead</code>
     */
    @Deprecated
    int getX();

    /**
     * @return
     * @deprecated use <code>getCoordinates instead</code>
     */
    @Deprecated
    int getY();

    /**
     * @return
     * @deprecated use <code>getCoordinates instead</code>
     */
    @Deprecated
    int getZ();

    /**
     * @return
     */
    Map<CoordinateType, Integer> getCoordinates();

    /**
     * returns the dimensionial type of the coordinate
     *
     * @return
     */
    DimensionType getDimensionType();

    /**
     * Returns a list of coordinates that can be traversed based on the current coordinate object
     *
     * @return
     */
    List<Coordinate> nextPossibleCoordinates();
}
