package core.src.main.java.core.structure;

public class Game {

    Playground playground;

    private void instantiateRoverFactory() {
        RoverFactory.getInstance(this).make(12);
    }

    public void create2D(int x, int y) {
        playground = new Playground2D(new Playground2D.Boundary(x, y));
    }

    public void play() {
        playground.deploy(RoverFactory.getInstance(this).getRover(5), 0, 0);

    }

    public static void main(String[] args) {
        Game game = new Game();
        game.instantiateRoverFactory();
        game.create2D(24, 22);
        game.play();
    }
}
