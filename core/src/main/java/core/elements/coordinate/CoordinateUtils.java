package core.elements.coordinate;

import core.utilities.CoreUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Encapsulates the operations to be done on coordinates
 */
//TODO:Add copyright
public final class CoordinateUtils {

    private CoordinateUtils() {
        // This class represents static utility to be used on coordinate class.
    }

    /**
     * determines next possible coordinates based on jumpFactor.
     * for jumpFactor=1, returns adjacent coordinates. For negative jump factor, the order of occurence will reverse.
     *
     * @param coordinate
     * @return
     */
    public static List<Coordinate> nextPossibleCoordinates(Coordinate coordinate, int jumpFactor) {
        CoreUtils.required("Coordinate", coordinate);
        if (jumpFactor == 0) {
            return List.of(coordinate);
        }
        List<Coordinate> nextMoves = new ArrayList();
        Map<AxisType, Integer> valueAtAxis = coordinate.getValues();
        for (AxisType key : valueAtAxis.keySet()) {
            Integer value1 = valueAtAxis.get(key) + jumpFactor;
            Integer value2 = valueAtAxis.get(key) - jumpFactor;
            Coordinate genericCoordinateImpl1 = getCoordinate(valueAtAxis, key, value1);
            Coordinate genericCoordinateImpl2 = getCoordinate(valueAtAxis, key, value2);
            nextMoves.add(genericCoordinateImpl1);
            nextMoves.add(genericCoordinateImpl2);
        }
        return nextMoves;
    }

    private static Coordinate getCoordinate(Map<AxisType, Integer> valueAtAxis, AxisType key, Integer value1) {
        Map<AxisType, Integer> objectIntegerMap = new TreeMap<>();
        objectIntegerMap.put(key, value1);
        for (AxisType key1 : valueAtAxis.keySet()) {
            if (key1.equals(key)) {
                continue;
            }
            objectIntegerMap.put(key1, valueAtAxis.get(key1));
        }
        return new CoordinateImpl(objectIntegerMap);
    }

}