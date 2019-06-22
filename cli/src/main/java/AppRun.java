import core.elements.playground.Playground;
import core.elements.rover.Rover;
import core.factory.PlaygroundFactory;
import core.factory.RoverFactory;
import core.factory.ShapesFactory;
import core.manager.GameManager;
import manager.CLIGameManager;

import java.util.List;

/**
 * Starter class for the CLI Application.
 */
public class AppRun {

    public static final int INTERVAL_SECONDS = 20000;

    public static void main(String[] args) throws InterruptedException {
        GameManager gameManager = new CLIGameManager();
        Playground playground =
                PlaygroundFactory.get2DPlayground(ShapesFactory.getArrayRepresentation(5,
                        4));
        List<Rover> rovers = List.of(RoverFactory.createRover(), RoverFactory.createRover());
        gameManager.createGame(playground, rovers);
        gameManager.startGame();
        //TODO: remove thread.sleep and add an event listener to listen on when game is finished.
        Thread.sleep(INTERVAL_SECONDS);
        System.out.println(gameManager.getStatus().getCode() + "\n" + gameManager.getStatus().getMessage());
    }

}
