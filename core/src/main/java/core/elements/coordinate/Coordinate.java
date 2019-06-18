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

    DimensionType getDimensionType();

    boolean lessThan(Coordinate c);

    boolean greaterThan(Coordinate c);

    boolean equalTo(Coordinate c);

    List<Coordinate> getForwardCoordinates();

    List<Coordinate> getBackwardCoordinates();
}
