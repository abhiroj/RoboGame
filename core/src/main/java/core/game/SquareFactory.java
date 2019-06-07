package core.src.main.java.core.game;

public class SquareFactory extends ShapeFactory {

    private static SquareFactory sqFactory = null;

    @Override
    public Shape[][] request2DShapeAsArray(int x, int y) {
        Shape[][] shape2D = new Square[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                shape2D[i][j] = new Square(new Coordinate(i, j));
            }
        }
        return shape2D;
    }

    @Override
    public Shape[][][] request3DShapeAsArray(int x, int y, int z) {
        return new Shape[0][][];
    }

    public static ShapeFactory getInstance() {
        if (sqFactory == null)
            sqFactory = new SquareFactory();
        return sqFactory;
    }
}
