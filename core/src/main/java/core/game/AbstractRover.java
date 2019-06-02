package core.src.main.java.core.game;

public interface AbstractRover {

    int getId();

    void move();

    void stop();

    void setCoordinates(Coordinate coordinates);

}
