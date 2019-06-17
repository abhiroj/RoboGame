package core.factory;

import core.elements.rover.Rover;
import core.elements.rover.RoverImpl;

public class RoverFactory {

    private static RoverFactory instance = null;
    private int rover_count = 0;

    private RoverFactory() {

    }

    public static RoverFactory getInstance() {
        if (instance == null) {
            instance = new RoverFactory();
        }
        return instance;
    }

    public Rover createRover() {
        Rover rover = new RoverImpl(++rover_count);
        return rover;
    }

}
