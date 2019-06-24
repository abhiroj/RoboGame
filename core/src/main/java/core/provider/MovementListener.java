package core.provider;

import core.elements.coordinate.Coordinate;

import java.util.List;

/**
 * objects that traverse playground consume MovementListener to get next moveable coordinates
 */
//TODO:Add copyright
public interface MovementListener {

    /**
     * Movement Provider tells next valid coordinate to move on, given current coordinate
     * throws <code>NoCoordinateFoundException</code> if no valid coordinate is found for next move.
     * can be synchronized for multi threaded environments or not if implemented on event-based systems
     * @param coordinate
     * @return
     */
    Coordinate nextMove(Coordinate coordinate);

    /**
     * determines next move using direction strategy.
     * Direction strategy or diffCoordinates provides the directional change consumer provides.
     * throws <code>NoCoordinateFoundException</code> if no valid coordinate is found for next move.
     * Currently, throws not implemented exception.
     * can be synchronized for multi threaded environments or not if implemented on event-based systems
     * @return
     */
    Coordinate nextMove(Coordinate coordinate, List<Coordinate> diffCoordinates);

}

