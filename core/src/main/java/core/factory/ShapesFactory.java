package core.factory;

import core.elements.coordinate.AxisType;
import core.elements.coordinate.CoordinateImpl;
import core.elements.shape.Shape;
import core.elements.shape.ShapeImpl;

import java.util.Map;
import java.util.TreeMap;

//TODO:Add copyright
public class ShapeFactory {

    private ShapeFactory() {
        //This class serves as a static factory for creation of shapes.
    }

    public static Shape[][] getArrayRepresentation(int x, int y) {
        Shape[][] shape2D = new ShapeImpl[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                Map<AxisType, Integer> treeMap = new TreeMap<>();
                treeMap.put(AxisType.X, i);
                treeMap.put(AxisType.Y, j);
                shape2D[i][j] = new ShapeImpl(new CoordinateImpl(treeMap));
            }
        }
        return shape2D;
    }

}
