package core.src.main.java.core.structure;

import core.src.main.java.core.exception.AppException;

import java.util.HashMap;
import java.util.Map;

public final class RoverFactory {

    private Map<Integer, Rover> roverMap;
    private int FACTORY_LIMIT = 120;
    private int rover_generate_offset = 1;
    private static RoverFactory ROVER_FACTORY = null;
    private Game game;

    private RoverFactory(Game game) {
        roverMap = new HashMap<>();
        this.game = game;
    }

    public void make(int generationCount) {
        int i = rover_generate_offset;
        for (; i < generationCount + rover_generate_offset; i++) {
            int id = i;
            Rover rover = new MarsRover(id, Rover.Directional.UP, Rover.Directional.RIGHT, game);
            roverMap.put(id, rover);
            if (roverMap.size() > FACTORY_LIMIT) {
                throw new AppException("Factory Limit Reached!");
            }
        }
        rover_generate_offset = i;
    }

    public Rover getRover(int id) {
        if (id >= roverMap.size()) {
            throw new AppException("Robo with this id does not exist");
        }
        return roverMap.get(id);
    }

    public static RoverFactory getInstance(Game game) {
        if (ROVER_FACTORY == null) {
            ROVER_FACTORY = new RoverFactory(game);
        }
        return ROVER_FACTORY;
    }

}
