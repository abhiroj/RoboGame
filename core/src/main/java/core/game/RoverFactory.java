package core.src.main.java.core.game;

public class RoverFactory {

    public static RoverFactory instance = null;
    private int rover_count = 0;

    private RoverFactory() {

    }

    public static RoverFactory getInstance() {
        if (instance == null) {
            instance = new RoverFactory();
        }
        return instance;
    }

    public Rover request2DRover(int x, int y) {
        Rover rover = new Rover(rover_count++);
        rover.setCoordinates(new Coordinate(x,y));
        return rover;
    }

}
