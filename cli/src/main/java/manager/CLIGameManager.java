package manager;

import core.controller.CollectionProvider;
import core.controller.GameManager;
import core.controller.MovementProvider;
import core.elements.DimensionType;
import core.elements.GameStatus;
import core.elements.Properties;
import core.elements.coordinate.Coordinate;
import core.elements.coordinate.CoordinateImpl;
import core.elements.playground.Playground;
import core.elements.rover.Rover;
import core.exception.AppException;
import core.exception.NoCoordinateFound;

import java.util.*;

public class CLIGameManager implements GameManager, MovementProvider, CollectionProvider {

    private Playground playground;
    private List<Rover> rovers;
    private List<Coordinate> visitedCoordinates;
    private Map<Coordinate, Properties> collectedProps;

    public CLIGameManager() {
        rovers = new ArrayList<>();
        visitedCoordinates = new ArrayList<>();
        collectedProps = new HashMap<>();
    }

    @Override
    public GameStatus createGame(Playground playground, int roverCount) {
        return null;
    }

    @Override
    public GameStatus createGame(Playground playground, List<Rover> rovers) {
        this.playground = playground;
        for (Rover rover : rovers)
            this.rovers.add(rover);
        return GameStatus.createStatus(200, "Create game successful");
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
        return GameStatus.createStatus(200, "Added " + count + "rovers to the game");
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
                count++;
            }
        }
        return GameStatus.createStatus(200, "Removed " + count + " rovers from the game");
    }

    @Override
    public GameStatus setPlayground(Playground playground) {
        return null;
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
                rover.activate(getFirstValidCoordinate());
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
        return GameStatus.createStatus(200, "All the rovers deployed successfully");
    }

    private void validateRovers() {
        if (rovers.size() == 0) {
            throw new AppException("No rovers to tread. Please add rovers in the game");
        }
    }

    @Override
    public GameStatus finishGame() {
        removeRovers(rovers);
        return getGameStatus();
    }

    @Override
    public GameStatus getGameStatus() {
        List<Coordinate> coordinates = this.playground.getBoundaryCoordinates();
        Coordinate start = coordinates.get(0);
        Coordinate end = coordinates.get(coordinates.size() - 1);
        Stack<Coordinate> dfs = new Stack<>();
        dfs.push(start);
        StringBuilder builder = new StringBuilder();
        List<Coordinate> memo = new ArrayList<>();
        while (!dfs.empty()) {
            Coordinate c = dfs.pop();
            if (c.lessThan(start) || c.greaterThan(end) || memo.contains(c)) {
                continue;
            }
            builder.append(c.toString() + " " + ((visitedCoordinates.contains(c)) ?
                    "visited " + collectedProps.get(c).get() + "\n" :
                    "not visited \n"));
            memo.add(c);
            for (Coordinate push : c.getForwardCoordinates()) {
                dfs.push(push);
            }
            for (Coordinate push : c.getBackwardCoordinates()) {
                dfs.push(push);
            }
        }
        return GameStatus.createStatus(200, builder.toString());
    }

    private Coordinate getFirstValidCoordinate() {
        Coordinate c1 = null;
        List<Coordinate> list = playground.getBoundaryCoordinates();
        Coordinate min = new CoordinateImpl(Integer.MAX_VALUE, Integer.MAX_VALUE);
        for (Coordinate c : list) {
            if (c.lessThan(min)) {
                min = c;
            }
        }
        c1 = nextPossibleCoordinate(min);
        return c1;
    }

    private Coordinate nextPossibleCoordinate(Coordinate c) {
        Queue<Coordinate> counter = new LinkedList<>();
        if (c.getDimensionType() == DimensionType.TWOD) {
            counter.offer(new CoordinateImpl(c.getX() + 1, c.getY()));
            counter.offer(new CoordinateImpl(c.getX() - 1, c.getY()));
            counter.offer(new CoordinateImpl(c.getX(), c.getY() + 1));
            counter.offer(new CoordinateImpl(c.getX(), c.getY() - 1));
        }
        do {
            c = counter.poll();
            if (!inBounds(c)) {
                continue;
            }
            if (!visited(c)) {
                return c;
            }
        } while (!counter.isEmpty());
        throw new NoCoordinateFound("No coordinates available");
    }

    private boolean visited(Coordinate coordinate) {
        if (coordinate == null || visitedCoordinates.contains(coordinate)) {
            return true;
        }
        return false;
    }


    private boolean inBounds(Coordinate coordinate) {
        List<Coordinate> list = playground.getBoundaryCoordinates();
        Coordinate max = new CoordinateImpl(-1, -1);
        Coordinate min = new CoordinateImpl(Integer.MAX_VALUE, Integer.MAX_VALUE);
        for (Coordinate c : list) {
            if (c.lessThan(min)) {
                min = c;
            }
            if (c.greaterThan(max)) {
                max = c;
            }
        }
        boolean lessThan = coordinate.lessThan(min);
        boolean greaterThan = coordinate.greaterThan(max);
        if (lessThan || greaterThan)
            return false;
        return true;
    }

    private boolean isValid(Coordinate c) {
        return !(visited(c) || !inBounds(c));
    }

    @Override
    public synchronized Coordinate nextMove(Coordinate coordinate) {
        visitedCoordinates.add(coordinate);
        Coordinate c = nextPossibleCoordinate(coordinate);
        if (isValid(c))
            return c;
        throw new NoCoordinateFound("Not a valid coordinate for next move " + c.toString());
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
