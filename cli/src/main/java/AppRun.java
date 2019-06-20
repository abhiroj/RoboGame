import core.manager.GameManager;
import core.elements.playground.Playground;
import core.elements.rover.Rover;
import core.factory.PlaygroundFactory;
import core.factory.RoverFactory;
import core.factory.ShapeFactory;
import manager.CLIGameManager;

import java.util.List;

public class AppRun {

    public static void main(String[] args) throws InterruptedException {
        GameManager gameManager = new CLIGameManager();
        Playground p = PlaygroundFactory.getInstance().get2DPlayground(ShapeFactory.getInstance().request2DShapeAsArray(5, 5));
        List<Rover> r = List.of(RoverFactory.getInstance().createRover(),RoverFactory.getInstance().createRover());
        gameManager.createGame(p, r);
        gameManager.startGame();
        Thread.sleep(20000);
        System.out.println(gameManager.getStatus().getCode()+"\n"+gameManager.getStatus().getMessage());
    }

}
