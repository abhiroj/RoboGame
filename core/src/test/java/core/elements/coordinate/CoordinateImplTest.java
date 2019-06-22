package core.elements.coordinate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Map;
import java.util.TreeMap;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class CoordinateImplTest {

    private final Integer COORD1 = 20;
    private final Integer COORD2 = 30;
    private Coordinate coordinate;

    @Before
    public void init() {
        Map<AxisType, Integer> axisTypeIntegerMap = new TreeMap<>();
        axisTypeIntegerMap.put(AxisType.X, COORD1);
        axisTypeIntegerMap.put(AxisType.Y, COORD2);
        coordinate = new CoordinateImpl(axisTypeIntegerMap);
    }

    @Test
    public void getValues_OkResponse_GetMapOfCoordinates() {
        Map<AxisType, Integer> response = coordinate.getValues();
        assertEquals(response.get(AxisType.X), COORD1);
        assertEquals(response.get(AxisType.Y), COORD2);
    }

    @Test
    public void toString_NoParams_GetStringRepresentation() {
        assertTrue(coordinate.toString().length() > 0);
    }

    @Test
    public void equals_differentObject_returnFalse() {
        assertFalse(coordinate.equals(new Object()));
    }

    @Test
    public void hashCode_DifferentCoordinates_DifferentHashCode() {
        CoordinateImpl coordinate1 = new CoordinateImpl(Map.of(AxisType.X, 1, AxisType.Y, 2));
        CoordinateImpl coordinate2 = new CoordinateImpl(Map.of(AxisType.X, 3, AxisType.Y, 4));
        assertNotEquals(coordinate1, coordinate2);
        assertNotEquals(coordinate1.hashCode(), coordinate2.hashCode());
    }
}