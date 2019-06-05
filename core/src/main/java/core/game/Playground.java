package core.src.main.java.core.game;

import java.util.List;

public interface Playground {

    List<Coordinate> getDimensions();

    Coordinate.Type getDimensionType();

    Shape getShapeAtCoordinate(Coordinate c);

}
