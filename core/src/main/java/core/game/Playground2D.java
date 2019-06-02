package core.src.main.java.core.game;

class Playground2D implements Playground {

    private final int dimen_x;
    private final int dimen_y;
    private final Square2D[][] square2D;

    Playground2D(int dimen_x, int dimen_y) {
        this.dimen_x = dimen_x;
        this.dimen_y = dimen_y;
        square2D = new Square2D[this.dimen_x][this.dimen_y];
    }

    @Override
    public void deploy(Rover rover) {

    }

    @Override
    public void demobilize(Rover rover) {

    }
}
