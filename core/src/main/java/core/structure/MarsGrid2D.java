package core.src.main.java.core.structure;

import core.src.main.java.core.action.Walkable;
import core.src.main.java.core.exception.AppException;
import core.src.main.java.core.properties.weather.Weather;
import core.src.main.java.core.repository.Repository;

public class MarsGrid2D implements PlayGround2D {

    Repository repository;

    private final MarsSquare[][] grid;

    public MarsGrid2D(int rows, int cols) {
        this.grid = new MarsSquare[rows][cols];
        init();
    }

    private void init() {
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[i].length; i++) {
                grid[i][j] = new MarsSquare(i, j);
                grid[i][j].setWeather(new Weather("", Weather.CELSIUS));
            }
    }

    public void deploy(Walkable w,int x,int y){
        if(grid[x][y].isVisited()) throw new AppException("Coordinate already visited! Try other coordinates!");

    }

    @Override
    public boolean checkBounds(Walkable w) {
        int[] bounds=w.getCoords();
        if(bounds[0]<0 && bounds[0]>=grid.length && bounds[1]<0 && bounds[1]>=grid[0].length )
            return false;
        return true;
    }
}