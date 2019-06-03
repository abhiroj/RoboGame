package core.src.main.java.core.game;

public interface Rover {

    enum Direction {
        UP(new Coordinate(0, 1)), DOWN(new Coordinate(0, -1)), LEFT(new Coordinate(-1, 0)), RIGHT(new Coordinate(1, 0));

        private Coordinate diff;

        Direction(Coordinate coordinate) {
            this.diff = coordinate;
        }

        public Coordinate getDiff() {
            return this.diff;
        }
    }

    /**
     * Get Rover's ID assigned by factory
     *
     * @return
     */
    int getId();

    /**
     * make rover choose and make next move
     */
    void move();

    /**
     * stop all operations of this rover. This can optionally be used to demobilize the rover.
     */
    void stop();

    /**
     * Set Coordinates of rover to make a move
     *
     * @param coordinates
     */
    void setStartingCoordinate(Coordinate coordinates);

    /**
     * get Current location of Rover
     *
     * @return
     */
    Coordinate getCoordinate();

    /**
     * Dump all the properties that has been collected by rover.
     */
    void dump();

    void setMessageHandler(MessageHandler handler);

    void setPrimaryDirection(Direction direction);

    void setSecondaryDirection(Direction direction);

}
