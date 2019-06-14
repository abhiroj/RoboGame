import controller.CLIGameController;
import core.src.main.java.core.game.*;

public class AppRun {

    public static void main(String[] args) {
        Playground playground = PlaygroundFactory.getInstance().get2DPlayground(SquareFactory.getInstance().request2DShapeAsArray(100, 100));
        CLIGameController cliGameController = new CLIGameController();
        cliGameController.setPlayground(playground);
        Rover rover=RoverFactory.getInstance().requestRunnableRover();
        rover.setCoordinate(new Coordinate(0,0));
        rover.setGameController(cliGameController);
        cliGameController.deploy(rover);
        Rover rover1=RoverFactory.getInstance().requestRunnableRover();
        rover1.setCoordinate(new Coordinate(50,50));
        rover1.setGameController(cliGameController);
        cliGameController.deploy(rover1);

    }

}
