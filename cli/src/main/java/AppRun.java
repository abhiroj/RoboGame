import controller.CLIGameController;
import core.src.main.java.core.game.*;

public class AppRun {

    public static void main(String[] args) {
        Playground playground = PlaygroundFactory.getInstance().get2DPlayground(SquareFactory.getInstance().request2DShapeAsArray(10, 15));
        CLIGameController cliGameController = new CLIGameController();
        cliGameController.setPlayground(playground);
        cliGameController.deploy(RoverFactory.getInstance().requestRunnableRover(new Coordinate(5,7)));
    }

}
