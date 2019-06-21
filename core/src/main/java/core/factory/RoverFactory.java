package core.factory;

import core.elements.rover.Rover;
import core.elements.rover.RoverImpl;

public class RoverFactory {

    private static int roverCount = 0;

    private RoverFactory() {

    }

    public static Rover createRover() {
        Rover rover = new RoverImpl(++roverCount);
        return rover;
    }

}
