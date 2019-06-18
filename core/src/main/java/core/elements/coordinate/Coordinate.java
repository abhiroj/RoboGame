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
     * @deprecated use <code>getCoordinates instead</code>
     */
    Map<CoordinateType, Integer> getCoordinates();

    /**
     * returns the dimensionial type of the coordinate
     *
     * @return
     */
    DimensionType getDimensionType();

    /**
     * return true if this coordinate less than @param Coordinate
     *
     * @param c
     * @return
     */
    boolean lessThan(Coordinate c);

    /**
     * @param c
     * @return
     */
    boolean greaterThan(Coordinate c);

    boolean equalTo(Coordinate c);

    @Deprecated
    List<Coordinate> getForwardCoordinates();

    @Deprecated
    List<Coordinate> getBackwardCoordinates();
}
