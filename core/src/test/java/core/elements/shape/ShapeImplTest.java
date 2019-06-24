package core.elements.shape;

import core.elements.PropertyType;
import core.elements.coordinate.AxisType;
import core.elements.coordinate.Coordinate;
import core.elements.coordinate.CoordinateImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class ShapeImplTest {

    private ShapeImpl shape;

    private Coordinate coordinate;
    private Properties properties;

    @Before
    public void init() {
        coordinate = new CoordinateImpl(Map.of(AxisType.X, 0, AxisType.Y, 0));
        shape = new ShapeImpl(coordinate);
        properties = new Properties();
        properties.put(PropertyType.WEATHER, "22F");
        properties.put(PropertyType.HUMIDITY, "31H");
        properties.put(PropertyType.UVRAD, "unit");
    }

    @Test
    public void testPropertiesSetterGetter() {
        shape.setProperties(properties);
        assertEquals(shape.getProperties(), properties);
    }

    @Test
    public void testCoordinateGetter() {
        assertEquals(shape.getCoordinate(), coordinate);
    }

}