package core.elements.coordinate;

import core.exception.AppException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class CoordinateUtilsTest {

    private final int TEST_JUMP_FACTOR = 1;
    private final Coordinate coordinate = new CoordinateImpl(Map.of(AxisType.X, 0, AxisType.Y, 0));
    private final Coordinate NEXT_POSSIBLE_1 = new CoordinateImpl(Map.of(AxisType.X, 0, AxisType.Y, 1));
    private final Coordinate NEXT_POSSIBLE_2 = new CoordinateImpl(Map.of(AxisType.X, 0, AxisType.Y, -1));
    private final Coordinate NEXT_POSSIBLE_3 = new CoordinateImpl(Map.of(AxisType.X, 1, AxisType.Y, 0));
    private final Coordinate NEXT_POSSIBLE_4 = new CoordinateImpl(Map.of(AxisType.X, 1, AxisType.Y, 0));

    @Test(expected = AppException.class)
    public void nextPossibleCoordinates_CoordinateNull_ThrowsException() {
        CoordinateUtils.nextPossibleCoordinates(null, TEST_JUMP_FACTOR);
    }

    @Test
    public void nextPossibleCoordinates_CoordinateOk_GetNextCoordinates() {
        List<Coordinate> coordinates = CoordinateUtils.nextPossibleCoordinates(coordinate, TEST_JUMP_FACTOR);
        assertThat(coordinates, is(notNullValue()));
        assertTrue(coordinates.contains(NEXT_POSSIBLE_1));
        assertTrue(coordinates.contains(NEXT_POSSIBLE_2));
        assertTrue(coordinates.contains(NEXT_POSSIBLE_3));
        assertTrue(coordinates.contains(NEXT_POSSIBLE_4));

    }

    @Test
    public void nextPossibleCoordinates_CoordinateOkJumpFactorZero_GetSameCoordinate() {
        List<Coordinate> coordinates = CoordinateUtils.nextPossibleCoordinates(coordinate, 0);
        assertThat(coordinates,is(notNullValue()));
        assertEquals(coordinates.size(),1);
        assertTrue(coordinates.contains(coordinate));
    }

}