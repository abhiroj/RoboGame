package core.factory;

import core.elements.shape.Shape;

public abstract class ShapeFactory {

    public abstract Shape[][] request2DShapeAsArray(int x, int y);

}
