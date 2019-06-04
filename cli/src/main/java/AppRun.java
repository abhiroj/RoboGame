import core.src.main.java.core.controller.GameController;

public class AppRun {

    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.create2DGame(20, 20);
        gameController.deploy(5, 5);
    }

}
