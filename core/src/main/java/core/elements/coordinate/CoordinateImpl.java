package core.elements.coordinate;

import core.utilities.CoreUtils;

import java.util.Map;

/**
 * This class represents a coordinate of the system.
 */
public class Coordinate implements GenericCoordinate {

    private final Map<AxisType, Integer> typeIntegerMap;

    public Coordinate(Map<AxisType, Integer> typeIntegerMap) {
        this.typeIntegerMap = typeIntegerMap;
    }

    /**
     * return a map of axis type which can be represented conventionally as x,y,z or in terms of latitude or longitude
     *
     * @return
     */
    @Override
    public Map<AxisType, Integer> getValues() {
        return typeIntegerMap;
    }

    @Override
    public int hashCode() {
        return 12;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Coordinate)) {
            return false;
        }
        Coordinate c = (Coordinate) obj;
        return this.getValues().equals(c.getValues());
    }

    @Override
    public String toString() {
        return CoreUtils.format("x:{0} y:{1} ");
    }


}
