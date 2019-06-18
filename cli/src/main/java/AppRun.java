import core.controller.GameManager;
import core.factory.PlaygroundFactory;
import core.factory.RoverFactory;
import core.factory.ShapeFactory;
import manager.CLIGameManager;

import java.util.List;

public class AppRun {

    public static void main(String[] args) {
        GameManager gameManager = new CLIGameManager();
        gameManager.createGame(PlaygroundFactory.getInstance().get2DPlayground(ShapeFactory.getInstance().request2DShapeAsArray(5, 5)), List.of(RoverFactory.getInstance().createRover(),RoverFactory.getInstance().createRover()));
        gameManager.startGame();
        System.out.println(gameManager.getGameStatus().getStatus()+"\n"+gameManager.getGameStatus().getMessage());
    }

}
