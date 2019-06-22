package core.elements.playground;

import core.elements.coordinate.Coordinate;
import core.elements.shape.Shape;
import core.exception.AppException;
import core.utilities.CoreUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * The playground is implemented as an adjacency array
 */
public class Playground2DImpl implements Playground {

    private final Shape[][] shape2D;

    public Playground2DImpl(Shape[][] shape2D) {
        this.shape2D = shape2D;
    }

    @Override
    public List<Coordinate> getCoordinates() {
        List<Coordinate> coordinates = new ArrayList<>();
        for (Shape[] row : shape2D) {
            for (Shape s : row) {
                coordinates.add(s.getCoordinate());
            }
        }
        return coordinates;
    }

    @Override
    public Shape getShapeAtCoordinate(Coordinate c) {
        CoreUtils.required("Coordinate", c);
        for (Shape[] row : shape2D) {
            for (Shape col : row) {
                if (col.getCoordinate().equals(c))
                    return col;
            }
        }
        throw new AppException("Shape does not exist at" + c.toString());
    }
}
