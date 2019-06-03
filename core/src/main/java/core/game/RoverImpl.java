package core.src.main.java.core.game;

import core.src.main.java.core.exception.AppException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class RoverImpl implements Rover, Runnable {

    private MessageHandler handler;
    private Coordinate coordinate;
    private final int id;
    private final int INTERVAL_IN_MILLIS = 2000;
    private List<Map<String, Object>> repository;

    RoverImpl(int id) {
        this.id = id;
        repository = new ArrayList<>();
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void move() {
        new Thread(this, "Rover " + id).start();
    }

    @Override
    public void stop() {

    }

    @Override
    public void setStartingCoordinate(Coordinate coordinate) {
        if (this.coordinate != null) {
            throw new AppException("can not set coordinates while in operation");
        }
        this.coordinate = coordinate;
    }

    @Override
    public Coordinate getCoordinate() {
        return coordinate;
    }


    @Override
    public void dump() {

    }

    @Override
    public void setMessageHandler(MessageHandler handler) {
        this.handler = handler;
    }

    @Override
    public void run() {
        handler.shouldMove(coordinate);
        System.out.println(Thread.currentThread().getName() + " successfully deployed!");
        while (true) {
            repository.add(handler.collect(coordinate));
            System.out.println("Collection made at " + coordinate.toString());
            try {
                Thread.sleep(INTERVAL_IN_MILLIS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            coordinate = new Coordinate(coordinate.getX() + 1, coordinate.getY());
            handler.shouldMove(coordinate);
        }
    }
}
