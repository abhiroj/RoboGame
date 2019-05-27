package core.src.main.java.core.structure;

import core.src.main.java.core.collection.Collectable;
import core.src.main.java.core.repository.Repository;
import core.src.main.java.core.props.weather.Weather;

public class MarsGrid2D {

    Repository repository;

    private final MarsSquare[][] grid;

    public MarsGrid2D(int rows, int cols) {
        this.grid = new MarsSquare[rows][cols];
        init();
    }

    private void init() {
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[i].length; i++) {
                grid[i][j] = new MarsSquare();
                grid[i][j].setWeather(new Weather("", Weather.CELSIUS));
            }
    }

    public void store(Collectable c) {
    repository.store(c);
    }
}