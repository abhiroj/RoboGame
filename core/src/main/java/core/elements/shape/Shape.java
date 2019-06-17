package core.elements.shape;

import core.elements.PropertyType;
import core.elements.coordinate.Coordinate;

import java.util.Map;

public interface Shape {

    Map<PropertyType, Object> getProperties();

    Coordinate getCoordinate();

}
