package core.src.main.java.core.structure;

public class MarsRover implements Rover, Runnable {

    private final int id;
    private final int INTERVAL_IN_MILLIS = 1000;
    int x, y;
    private Game gameContext;
    private EventListener eventListener;

    private final Directional primary;
    private final Directional secondary;

    public MarsRover(int id, Directional primary, Directional secondary, Game game) {
        this.id = id;
        this.primary = primary;
        this.secondary = secondary;
        gameContext = game;
    }

    @Override
    public void start() {
        run();
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setInitialCoordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void stop() {
        Thread.currentThread().stop();
    }

    @Override
    public void registerEventListener(EventListener eventListener) {
        if (this.eventListener != null) {
            unregisterEventListener();
        }
        this.eventListener = eventListener;
    }

    @Override
    public void unregisterEventListener() {
        this.eventListener = null;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(INTERVAL_IN_MILLIS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
