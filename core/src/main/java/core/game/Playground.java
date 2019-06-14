package core.src.main.java.core.game;

import java.util.List;

public interface Playground {

    /**
     *
     * @return
     */
    List<Coordinate> getBoundaryCoordinates();

    Type getDimensionType();

    Shape getShapeAtCoordinate(Coordinate c);

}
