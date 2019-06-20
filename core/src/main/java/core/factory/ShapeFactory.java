package core.factory;

import core.elements.coordinate.CoordinateImpl;
import core.elements.shape.Shape;
import core.elements.shape.Shape2DImpl;

public class ShapeFactory {

    private static ShapeFactory sqFactory = null;

    public Shape[][] request2DShapeAsArray(int x, int y) {
        Shape[][] shape2D = new Shape2DImpl[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                shape2D[i][j] = new Shape2DImpl(new CoordinateImpl(i, j));
            }
        }
        return shape2D;
    }

    public static ShapeFactory getInstance() {
        if (sqFactory == null)
            sqFactory = new ShapeFactory();
        return sqFactory;
    }
}
