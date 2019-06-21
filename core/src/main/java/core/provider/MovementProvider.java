package core.provider;

import core.elements.coordinate.Coordinate;

import java.util.List;

/**
 * objects that traverse playground consume MovementProvider to get next moveable coordinates
 */
//TODO:Add copyright
public interface MovementProvider {

    /**
     * Movement Provider tells next valid coordinate to move on, given current coordinate
     * throws <code>NoCoordinateFoundException</code> if no valid coordinate is found for next move.
     *
     * @param coordinate
     * @return
     */
    Coordinate nextMove(Coordinate coordinate);

    /**
     * determines next move using direction strategy.
     * Direction strategy or diffCoordinates provides the directional change consumer provides.
     * throws <code>NoCoordinateFoundException</code> if no valid coordinate is found for next move.
     * Currently, throws not implemented exception.
     *
     * @return
     */
    Coordinate nextMove(Coordinate coordinate, List<Coordinate> diffCoordinates);

}

