package core.elements.playground;

import core.elements.coordinate.Coordinate;
import core.elements.coordinate.CoordinateImpl;
import core.elements.shape.Shape;
import core.exception.AppException;
import core.factory.PlaygroundFactory;
import core.factory.ShapesFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(JUnit4.class)
public class Playground2DImplTest {

    private final int ROW_COUNT = 3;
    private final int COL_COUNT = 3;

    private final Shape[][] shapes = ShapesFactory.getArrayRepresentation(ROW_COUNT, COL_COUNT);
    private Playground playground2D;

    @Before
    public void init() {
        playground2D = PlaygroundFactory.get2DPlayground(shapes);
    }

    @Test
    public void getCoordinates_PlaygroundInitialized_TotalNineAndNotNull() {
        List<Coordinate> coordinateList = playground2D.getCoordinates();
        assertThat(coordinateList, is(notNullValue()));
        assertEquals(coordinateList.size(), ROW_COUNT * COL_COUNT);
        for (Coordinate coordinate : coordinateList) {
            assertThat(coordinate, is(notNullValue()));
        }
    }

    @Test
    public void getShapeAtCoordinate_PlaygroundInitialized_NotNullShape() {
        List<Coordinate> coordinateList = playground2D.getCoordinates();
        for (Coordinate coordinate : coordinateList) {
            assertThat(playground2D.getShapeAtCoordinate(coordinate), is(notNullValue()));
        }
    }

    @Test(expected = AppException.class)
    public void getShapeAtCoordinate_CoordinateNotValid_ThrowAppException() {
        playground2D.getShapeAtCoordinate(new CoordinateImpl(Map.of()));
    }

}