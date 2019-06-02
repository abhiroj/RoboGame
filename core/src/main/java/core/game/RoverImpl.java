package core.src.main.java.core.game;

import core.src.main.java.core.exception.AppException;

class RoverImpl implements Rover, Runnable {

    private Mediator mediator;
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
    public void setStartingCoordinate(Coordinate coordinate) {
        if (this.coordinate == null) {
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
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void run() {

    }
}
