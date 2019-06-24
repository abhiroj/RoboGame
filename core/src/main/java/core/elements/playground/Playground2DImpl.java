package core.elements.playground;

import core.elements.coordinate.Coordinate;
import core.elements.shape.SandboxShape;
import core.exception.AppException;
import core.utilities.CoreUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * The playground is implemented as an adjacency array
 */
public class Playground2DImpl implements Playground {

    private final SandboxShape[][] shape2D;

    public Playground2DImpl(SandboxShape[][] shape2D) {
        this.shape2D = shape2D;
    }

    @Override
    public List<Coordinate> getCoordinates() {
        List<Coordinate> coordinates = new ArrayList<>();
        for (SandboxShape[] row : shape2D) {
            for (SandboxShape s : row) {
                coordinates.add(s.getCoordinate());
            }
        }
        return coordinates;
    }

    @Override
    public SandboxShape getShapeAtCoordinate(Coordinate c) {
        CoreUtils.required("Coordinate", c);
        for (SandboxShape[] row : shape2D) {
            for (SandboxShape col : row) {
                if (col.getCoordinate().equals(c))
                    return col;
            }
        }
        throw new AppException("SandboxShape does not exist at" + c.toString());
    }
}
