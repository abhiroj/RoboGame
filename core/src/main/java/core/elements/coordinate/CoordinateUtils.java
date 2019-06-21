package core.elements.coordinate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Encapsulates the operations to be done on coordinates
 */
public final class CoordinateImplUtils {

    private CoordinateImplUtils() {
        // This class represents static utility to be used on coordinate class.
    }

    /**
     * determines next possible coordinates based on jumpFactor.
     * for jumpFactor=1, returns adjacent coordinates.
     *
     * @param coordinate
     * @return
     */
    public static List<CoordinateImpl> nextPossibleCoordinates(GenericCoordinate coordinate, int jumpFactor) {
        List<CoordinateImpl> nextMoves = new ArrayList();
        Map<AxisType, Integer> valueAtAxis = coordinate.getValues();
        for (AxisType key : valueAtAxis.keySet()) {
            Integer value1 = valueAtAxis.get(key) + jumpFactor;
            Integer value2 = valueAtAxis.get(key) - jumpFactor;
            CoordinateImpl genericCoordinateImpl1 = getCoordinate(valueAtAxis, key, value1);
            CoordinateImpl genericCoordinateImpl2 = getCoordinate(valueAtAxis, key, value2);
            nextMoves.add(genericCoordinateImpl1);
            nextMoves.add(genericCoordinateImpl2);
        }
        return nextMoves;
    }

    private static CoordinateImpl getCoordinate(Map<AxisType, Integer> valueAtAxis, AxisType key, Integer value1) {
        Map<AxisType, Integer> objectIntegerMap = new HashMap<>();
        objectIntegerMap.put(key, value1);
        for (AxisType key1 : valueAtAxis.keySet()) {
            if (key1.equals(key)) {
                continue;
            }
            objectIntegerMap.put(key1, valueAtAxis.get(key));
        }
        return new CoordinateImpl(objectIntegerMap);
    }

}