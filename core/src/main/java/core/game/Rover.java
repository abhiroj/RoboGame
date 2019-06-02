package core.src.main.java.core.game;

class Rover implements AbstractRover, Runnable {

    private Coordinate coordinate;
    private final int id;
    private final int INTERVAL_IN_MILLIS = 2000;

    Rover(int id) {
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
    public void run() {

    }
}
