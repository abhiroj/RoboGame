package core.src.main.java.core.game;

/**
 * Singleton Playground Factory
 */
public class PlaygroundFactory {

    private static PlaygroundFactory playgroundFactory = null;

    private PlaygroundFactory() {

    }

    public Playground get2DPlayground(int x, int y) {
        return new Playground2D(x, y);
    }

    public static PlaygroundFactory getInstance() {
        if (playgroundFactory == null) {
            playgroundFactory = new PlaygroundFactory();
        }
        return playgroundFactory;
    }

}
