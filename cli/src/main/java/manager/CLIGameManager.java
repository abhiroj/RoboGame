package manager;

import core.elements.GameStatus;
import core.elements.Properties;
import core.elements.coordinate.Coordinate;
import core.elements.playground.Playground;
import core.elements.rover.Rover;
import core.exception.AppException;
import core.exception.NoCoordinateFound;
import core.manager.CollectionProvider;
import core.manager.GameManager;
import core.manager.MovementProvider;
import core.utilities.CoreUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CLIGameManager implements GameManager, MovementProvider, CollectionProvider {

    private Playground playground;
    private List<Rover> rovers;
    private List<Coordinate> allotedCoordinates;
    private Map<Coordinate, Properties> collectedProps;

    public CLIGameManager() {
        rovers = new ArrayList<>();
        allotedCoordinates = new ArrayList<>();
        collectedProps = new HashMap<>();
    }

    @Override
    public GameStatus createGame(Playground playground, int roverCount) {
        return null;
    }

    @Override
    public GameStatus createGame(Playground playground, List<Rover> rovers) {
        setPlayground(playground);
        for (Rover rover : rovers)
            this.rovers.add(rover);
        return GameStatus.status(200, "Create game successful");
    }

    @Override
    public GameStatus addRovers(int roverCount) {
        return null;
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
        return GameStatus.status(200, "Added " + count + "rovers to the game");
    }

    @Override
    public GameStatus removeRovers(int roverCount) {
        return null;
    }

    @Override
    public GameStatus removeRovers(List<Rover> roverList) {
        int count = 0;
        for (Rover rover : roverList) {
            if (rovers.contains(rover)) {
                rovers.remove(rover);
                rover.stop();
                count++;
            }
        }
        return GameStatus.status(200, "Removed " + count + " rovers from the game");
    }

    @Override
    public GameStatus setPlayground(Playground playground) {
        CoreUtils.required("Playground", playground);
        this.playground = playground;
        return GameStatus.status(200, "Game equipped with " + playground.toString());
    }

    @Override
    public GameStatus removePlayground(Playground playground) {
        return null;
    }

    @Override
    public GameStatus startGame() {
        validateRovers();
        for (Rover rover : rovers) {
            rover.setMovementProvider(this);
            rover.setCollectionProvider(this);
            if (rover.getCurrentCoordinate() == null) {
                rover.activate(getFirstNonVisitedCoordinate());
                continue;
            } else {
                if (!isValid(rover.getCurrentCoordinate())) {
                    System.out.println(rover.toString() + " does not have valid set of coordinates. can not be " +
                            "deployed");
                }
                rover.activate();
            }
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return GameStatus.status(200, "All the rovers deployed successfully");
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
                    c.toString() + " visited " + collectedProps.get(c).get() + " \n" :
                    c.toString() +
                            " not " +
                            "visited \n");
        }
        return GameStatus.status(200, builder.toString());
    }

    private Coordinate getFirstNonVisitedCoordinate() {
        for (Coordinate c : playground.getCoordinates()) {
            if (!isAlloted(c)) {
                allotedCoordinates.add(c);
                return c;
            }
        }
        throw new NoCoordinateFound("no coordinates available");
    }

    private boolean isAlloted(Coordinate coordinate) {
        return allotedCoordinates.contains(coordinate);
    }


    private boolean isInBounds(Coordinate coordinate) {
        if (coordinate == null) return false;
        List<Coordinate> groundCoordinates = this.playground.getCoordinates();
        boolean res = groundCoordinates.contains(coordinate);
        return res;
    }

    private boolean isValid(Coordinate c) {
        return isInBounds(c) && !isAlloted(c);
    }

    @Override
    public synchronized Coordinate nextMove(Coordinate coordinate) {
        List<Coordinate> c = coordinate.nextPossibleCoordinates();
        for (Coordinate x : c) {
            if (isValid(x)) {
                allotedCoordinates.add(x);
                return x;
            }
        }
        throw new NoCoordinateFound("Not a valid coordinate for next move " + coordinate.toString());
    }

    @Override
    public synchronized Coordinate nextMove(Coordinate coordinate, List<Coordinate> diffCoordinates) {
        return null;
    }

    @Override
    public void collect(Coordinate c) {
        collectedProps.put(c, this.playground.getShapeAtCoordinate(c).getProperties());
    }

}
