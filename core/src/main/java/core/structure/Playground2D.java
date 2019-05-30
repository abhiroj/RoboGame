package core.src.main.java.core.structure;

import java.util.Map;

public class Playground2D implements Playground {

    static class Boundary implements Playground.Boundary {

        private final int limitX;
        private final int limitY;

        Boundary(int limitX, int limitY) {
            this.limitX = limitX;
            this.limitY = limitY;
        }

        @Override
        public Map<Dimensional, Integer> getBounds() {
            return Map.of(Dimensional.X, limitX, Dimensional.Y, limitY);
        }
    }

    private final Boundary boundary;

    public Playground2D(int spreadX, int spreadY) {
        this.boundary = new Boundary(spreadX, spreadY);
    }


    @Override
    public void deploy(Rover rover) {

    }

    @Override
    public void demobilize(Rover rover) {

    }

}