package manager;

import core.elements.GameStatus;
import core.elements.coordinate.Coordinate;
import core.elements.coordinate.CoordinateUtils;
import core.elements.playground.Playground;
import core.elements.rover.Rover;
import core.exception.AppException;
import core.exception.NoCoordinateFoundException;
import core.factory.RoverFactory;
import core.manager.GameManager;
import core.provider.CollectionProvider;
import core.provider.MovementProvider;
import core.utilities.CoreUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * CLIGameManager provides functionality to write the application for the CLI App.
 */
public class CLIGameManager implements GameManager, MovementProvider, CollectionProvider {

    private static final Logger LOGGER = LoggerFactory.getLogger(CLIGameManager.class);

    private Playground playground;
    private final List<Rover> rovers;
    private final List<Coordinate> allotedCoordinates;
    private final Map<Coordinate, Properties> collectedProps;

    public CLIGameManager() {
        rovers = new ArrayList<>();
        allotedCoordinates = new ArrayList<>();
        collectedProps = new HashMap<>();
    }

    @Override
    public GameStatus createGame(Playground playground, int roverCount) {
        try {
            throw new UnsupportedOperationException("createGame to Random Rovers upto roverCount is not " +
                    "implemented.");
        } catch (UnsupportedOperationException e) {
            LOGGER.warn(e.getMessage(), e);
            throw new AppException(e);
        }
    }

    @Override
    public GameStatus createGame(Playground playground, List<Rover> rovers) {
        setPlayground(playground);
        for (Rover rover : rovers)
            this.rovers.add(rover);
        return GameStatus.createStatus(GameStatus.Code.OK, "Create game successful");
    }

    @Override
    public GameStatus addRovers(int roverCount) {
        List<Rover> rovers = new ArrayList<>();
        while (roverCount-- > 0) {
            rovers.add(RoverFactory.createRover());
        }
        return addRovers(rovers);
    }

    @Override
    public GameStatus addRovers(List<Rover> roverList) {
        int count = 0;
        for (Rover rover : roverList) {
            if (!rovers.contains(rover)) {
                rovers.add(rover);
                count++;
            }
        }
        return GameStatus.createStatus(GameStatus.Code.OK, "Added " + count + "rovers to the game");
    }

    @Override
    public GameStatus addRoversOnCoordinates(List<Coordinate> coordinates) {
        try {
            throw new UnsupportedOperationException("addRoversOnCoordinates is not implemented.");
        } catch (UnsupportedOperationException e) {
            LOGGER.warn(e.getStackTrace().toString(), e);
            throw new AppException(e);
        }
    }

    @Override
    public GameStatus removeRovers(int roverCount) {
        try {
            throw new UnsupportedOperationException("removeRovers not implemented");
        } catch (UnsupportedOperationException e) {
            LOGGER.warn(e.getLocalizedMessage(), e);
            throw new AppException(e);
        }
    }


    @Override
    public GameStatus removeRovers(List<Rover> roverList) {
        int count = 0;
        List<Rover> roversToBeRemoved = new ArrayList<>();
        for (Rover rover : roverList) {
            if (rovers.contains(rover)) {
                rover.stop();
                roversToBeRemoved.add(rover);
                count++;
            }
        }
        roverList.removeAll(roversToBeRemoved);
        return GameStatus.createStatus(GameStatus.Code.OK, "Removed " + count + " rovers from the game");
    }

    @Override
    public GameStatus removeRoversFromCoordinates(List<Coordinate> coordinates) {
        try {
            throw new UnsupportedOperationException("removeRoversFromCoordinates is not implemented.");
        } catch (UnsupportedOperationException e) {
            LOGGER.warn(e.getMessage(), e);
            throw new AppException(e);
        }
    }

    @Override
    public GameStatus setPlayground(Playground playground) {
        CoreUtils.required("Playground", playground);
        this.playground = playground;
        return GameStatus.createStatus(GameStatus.Code.OK, "Game equipped with " + playground.toString());
    }

    @Override
    public GameStatus removePlayground() {
        this.playground = null;
        return GameStatus.createStatus(GameStatus.Code.OK, "Playground removed from game");
    }

    @Override
    public GameStatus startGame() {
        validatePlayground();
        validateRovers();
        for (Rover rover : rovers) {
            rover.setMovementProvider(this);
            rover.setCollectionProvider(this);
            if (!isValid(rover.getCoordinate())) {
                rover.activate(getFirstNonVisitedCoordinate());
                continue;
            } else {
                rover.activate(rover.getCoordinate());
            }
        }
        return GameStatus.createStatus(GameStatus.Code.OK, "All the rovers deployed successfully");
    }

    private void validatePlayground() {
        CoreUtils.required("Playground", this.playground);
    }

    private void validateRovers() {
        if (rovers.size() == 0) {
            throw new AppException("No rovers to tread. Please add rovers in the game");
        }
    }

    @Override
    public GameStatus finishGame() {
        removeRovers(rovers);
        return getStatus();
    }

    @Override
    public GameStatus getStatus() {
        List<Coordinate> coordinates = this.playground.getCoordinates();
        StringBuilder builder = new StringBuilder();
        for (Coordinate c : coordinates) {
            builder.append(collectedProps.containsKey(c) ?
                    c.toString() + " visited " + collectedProps.get(c).toString() + " \n" :
                    c.toString() +
                            " not " +
                            "visited \n");
        }
        return GameStatus.createStatus(GameStatus.Code.OK, builder.toString());
    }

    private Coordinate getFirstNonVisitedCoordinate() {
        for (Coordinate c : playground.getCoordinates()) {
            if (!isAlloted(c)) {
                allotedCoordinates.add(c);
                return c;
            }
        }
        throw new NoCoordinateFoundException("no coordinates available");
    }

    private boolean isAlloted(Coordinate coordinate) {
        return allotedCoordinates.contains(coordinate);
    }


    private boolean isInBounds(Coordinate coordinate) {
        List<Coordinate> groundCoordinates = this.playground.getCoordinates();
        boolean res = groundCoordinates.contains(coordinate);
        return res;
    }

    private boolean isValid(Coordinate c) {
        return !Objects.isNull(c) && isInBounds(c) && !isAlloted(c);
    }

    @Override
    public synchronized Coordinate nextMove(Coordinate coordinate) {
        List<Coordinate> c = CoordinateUtils.nextPossibleCoordinates(coordinate, 1);
        for (Coordinate x : c) {
            if (isValid(x)) {
                allotedCoordinates.add(x);
                return x;
            }
        }
        throw new NoCoordinateFoundException("Not a valid coordinate for next move " + coordinate.toString());
    }

    @Override
    public synchronized Coordinate nextMove(Coordinate coordinate, List<Coordinate> diffCoordinates) {
        try {
            throw new UnsupportedOperationException("nextMove is not implemented.");
        } catch (UnsupportedOperationException e) {
            LOGGER.warn(e.getMessage(), e);
            throw new AppException(e);
        }
    }

    @Override
    public synchronized void collect(Coordinate c) {
        collectedProps.put(c, this.playground.getShapeAtCoordinate(c).getProperties());
    }

}
