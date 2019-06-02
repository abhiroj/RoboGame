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

    public RoverImpl request2DRover(int x, int y) {
        RoverImpl rover = new RoverImpl(rover_count++);
        rover.setStartingCoordinate(new Coordinate(x,y));
        return rover;
    }

}
