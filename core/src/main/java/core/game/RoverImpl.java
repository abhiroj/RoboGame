package core.src.main.java.core.game;

class RoverImpl implements Rover, Runnable {

    private Coordinate coordinate;
    private final int id;
    private final int INTERVAL_IN_MILLIS = 2000;

    RoverImpl(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void move() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void setCoordinates(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    @Override
    public Coordinate getCoordinate() {
        return coordinate;
    }

    @Override
    public void run() {

    }
}
