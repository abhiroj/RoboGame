package core.src.main.java.core.game;

public interface Rover {

    int getId();

    void move();

    void stop();

    void setStartingCoordinate(Coordinate coordinates);

    Coordinate getCurrentCoordinate();

    void dump();

    void setEventHandler(EventHandler handler);

}
