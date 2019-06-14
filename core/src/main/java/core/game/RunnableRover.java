package core.src.main.java.core.game;

import core.src.main.java.core.controller.GameController;
import core.src.main.java.core.exception.AppException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class RunnableRover implements Rover, Runnable {

    private Coordinate coordinate;
    private final int id;
    private List<Map<String, Object>> repository;
    private boolean shouldRun = false;
    private GameController controller;
    private boolean activate = false;

    RunnableRover(int id) {
        this.id = id;
        repository = new ArrayList<>();
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void activate() {
        if (activate) {
            throw new AppException(this.toString() + " can not be activated again");
        }
        activate = true;
        shouldRun = true;
        System.out.println("everybody, buckle up please!" + this.toString() + " on the move.");
        new Thread(this, this.toString()).start();
    }

    @Override
    public void move() {
        System.out.println("Visited " + coordinate.toString() +"by "+this.toString());
        coordinate = controller.nextMove(coordinate);
    }

    @Override
    public void stop() {
        if(!activate){
            System.out.println("can not stop a rover which is not activated!");
            return;
        }
        System.out.println("Pulling Aside!");
        shouldRun = false;
    }

    @Override
    public Coordinate getCurrentCoordinate() {
        return coordinate;
    }


    @Override
    public void dump() {

    }

    @Override
    public void setGameController(GameController handler) {
        this.controller = handler;
    }

    @Override
    public void setCoordinate(Coordinate coordinate) {
        if(this.coordinate==null){
            this.coordinate=coordinate;
        }else{
            throw new AppException("Coordinate already present");
        }
    }


    @Override
    public void run() {
        while (shouldRun) {
            move();
        }
    }

    @Override
    public String toString() {
        return "Rover " + this.getId();
    }
}
