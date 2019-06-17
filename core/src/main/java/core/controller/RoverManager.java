package core.controller;

import core.elements.coordinate.Coordinate;

public interface RoverManager {

    /**
     * Rovers tell the rover manager it's current coordinates based on which the manager shares next valid coordinate
     * to move.
     * throws runtime exception if not valid coordinate is found.
     *
     * @param coordinate
     * @return
     */
    Coordinate nextMove(Coordinate coordinate);

}

