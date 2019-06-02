package core.src.main.java.core.game;

public class Rover2D implements Rover, Runnable {

    private int x;
    private int y;
    private final int id;
    private final int INTERVAL_IN_MILLIS = 2000;

    Rover2D(int id) {
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

    public void setCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void run() {

    }
}
