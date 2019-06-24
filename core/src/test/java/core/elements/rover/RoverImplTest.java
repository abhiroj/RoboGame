package core.elements.rover;

import core.elements.coordinate.AxisType;
import core.elements.coordinate.Coordinate;
import core.elements.coordinate.CoordinateImpl;
import core.exception.AppException;
import core.exception.NoCoordinateFoundException;
import core.provider.CollectionListener;
import core.provider.MovementListener;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Map;
import java.util.TreeMap;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.spy;

@RunWith(MockitoJUnitRunner.class)
public class RoverImplTest {

    private final int TEST_ROVER_ID = 12;

    @Mock
    private CollectionListener collectionProvider;

    @Mock
    private MovementListener movementProvider;

    private Coordinate coordinate;

    @InjectMocks
    private RoverImpl rover = new RoverImpl(TEST_ROVER_ID);

    @Before
    public void init() {
        Map<AxisType, Integer> axisTypeIntegerMap = new TreeMap<>();
        axisTypeIntegerMap.put(AxisType.X, 0);
        axisTypeIntegerMap.put(AxisType.Y, 0);
        coordinate = new CoordinateImpl(axisTypeIntegerMap);
    }

    @Test(expected = AppException.class)
    public void activate_CoordinateNull_ThrowAppException() {
        Rover rover = new RoverImpl(TEST_ROVER_ID);
        rover.activate(null);
    }

    @Test
    public void activate_CoordinateOk_getTrueActiveStatus() {
        rover.activate(coordinate);
        assertTrue(rover.isActive());
    }


    @Test
    public void move_MovementProviderGetValidCoordinate_NoException() {
        Mockito.doNothing().when(collectionProvider).collect(any());
        Mockito.when(movementProvider.nextMove(any())).thenReturn(coordinate);
        rover.setCoordinate(coordinate);
        rover.move();
    }

    @Test
    public void move_MovementProviderThrowNoCoordinateFoundException_HandleGracefully() {
        Mockito.doNothing().when(collectionProvider).collect(any());
        Mockito.when(movementProvider.nextMove(any())).thenThrow(NoCoordinateFoundException.class);
        rover.setCoordinate(coordinate);
        rover.move();
    }

    @Test
    public void stop_FirstTime_NoException() {
        rover.activate(coordinate);
        rover.stop();
    }

    @Test
    public void run_ThrowsInterruptedException_LogException() {
        RoverImpl rover = spy(new RoverImpl(TEST_ROVER_ID));
        rover.run();
    }

    @Test
    public void accessibilityFunctions_NoExceptions() {
        rover.setCoordinate(coordinate);
        assertEquals(rover.getCoordinate(), coordinate);
        rover.setCollectionProvider(collectionProvider);
        rover.setMovementProvider(movementProvider);
    }

}