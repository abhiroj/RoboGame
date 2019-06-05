package core.src.main.java.core.game;

import core.src.main.java.core.exception.AppException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class RunnableRover implements Rover, Runnable {

    private EventHandler handler;
    private Coordinate coordinate;
    private final int id;
    private final int INTERVAL_IN_MILLIS = 2000;
    private final long NEXT_MOVE_THRESHOLD_TIME = 5000;
    private List<Map<String, Object>> repository;
    private final int FAILURE_COUNTER = 4;
    private boolean shouldRun = false;

    RunnableRover(int id) {
        this.id = id;
        repository = new ArrayList<>();
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void move() {
        shouldRun = true;
        System.out.println("EVERYBODY BUCKLE UP, PLEASE!".toLowerCase());
        new Thread(this, "Rover " + id).start();
    }

    @Override
    public void stop() {
        System.out.println("Pulling Aside!");
        shouldRun = false;
    }

    @Override
    public void setStartingCoordinate(Coordinate coordinate) {
        if (this.coordinate != null) {
            throw new AppException("can not set coordinates while in operation");
        }
        this.coordinate = coordinate;
    }

    @Override
    public Coordinate getCurrentCoordinate() {
        return coordinate;
    }


    @Override
    public void dump() {

    }

    @Override
    public void setEventHandler(EventHandler handler) {
        this.handler = handler;
    }

    @Override
    public void run() {
        handler.shouldMove(coordinate);
        System.out.println(Thread.currentThread().getName() + " successfully deployed!");
        while (shouldRun) {
            repository.add(handler.collect(coordinate));
            System.out.println("Collection made at " + coordinate.toString());
            try {
                Thread.sleep(INTERVAL_IN_MILLIS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
