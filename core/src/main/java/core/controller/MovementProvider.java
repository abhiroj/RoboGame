package core.controller;

import core.elements.coordinate.Coordinate;

import java.util.List;

public interface MovementProvider {

    /**
     * Movement Provider tells next valid coordinate to move on, given current coordinate
     * throws runtime exception if not valid coordinate is found.
     *
     * @param coordinate
     * @return
     */
    Coordinate nextMove(Coordinate coordinate);

    /**
     * determines next move using direction strategy.
     * Direction strategy or diffCoordinates provides the directional change consumer provides.
     *
     * @return
     */
    Coordinate nextMove(Coordinate coordinate, List<Coordinate> diffCoordinates);

}

