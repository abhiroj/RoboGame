package core.src.main.java.core.game;

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

    public Rover requestRunnableRover(Coordinate coordinate) {
        Rover rover = new RunnableRover(++rover_count);
        rover.setStartingCoordinate(coordinate);
        return rover;
    }

}
