package core.elements.coordinate;

import java.util.Map;

/**
 * This class represents generic coordinate
 */
//TODO:Add copyright
public interface Coordinate {

    /**
     * return a map of axis type which can be represented conventionally as x,y,z or any other dimension that gets added
     * Currently supports AxisType but later this can be even more abstracted into
     * an abstract type <code>CoordinateType</code>. <code>AxisType</code> or <code>GeographicCoordinateType</code>
     * can then extend from <code>CoordinateType</code> to provide such functionalities.
     *
     * @return
     */
    Map<AxisType, Integer> getValues();

}