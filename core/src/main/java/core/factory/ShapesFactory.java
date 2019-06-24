package core.factory;

import core.elements.coordinate.AxisType;
import core.elements.coordinate.CoordinateImpl;
import core.elements.shape.SandboxShape;
import core.elements.shape.ShapeImpl;

import java.util.Map;
import java.util.TreeMap;

//TODO:Add copyright
public class ShapesFactory {

    private ShapesFactory() {
        //This class serves as a static factory for creation of shapes.
    }

    /**
     * gets a two dimensional array representation of shapes
     *
     * @param rows
     * @param columns
     * @return
     */
    public static SandboxShape[][] getArrayRepresentation(int rows, int columns) {
        SandboxShape[][] shape2D = new ShapeImpl[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                Map<AxisType, Integer> treeMap = new TreeMap<>();
                treeMap.put(AxisType.X, i);
                treeMap.put(AxisType.Y, j);
                shape2D[i][j] = new ShapeImpl(new CoordinateImpl(treeMap));
            }
        }
        return shape2D;
    }

}
