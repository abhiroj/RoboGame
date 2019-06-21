package core.elements.coordinate;

import java.util.Map;

/**
 * This class represents a coordinate of the system.
 */
//TODO:Add copyright
public class CoordinateImpl implements Coordinate {

    private final Map<AxisType, Integer> typeIntegerMap;

    public CoordinateImpl(Map<AxisType, Integer> typeIntegerMap) {
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
        return typeIntegerMap.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof CoordinateImpl)) {
            return false;
        }
        CoordinateImpl c = (CoordinateImpl) obj;
        return this.getValues().equals(c.getValues());
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Map<AxisType, Integer> value = getValues();
        builder.append("{");
        for (Map.Entry<AxisType, Integer> entry : value.entrySet()) {
            builder.append(entry.getKey().toString() + " : " + entry.getValue() + " ");
        }
        builder.append("}");
        return builder.toString();
    }

}
