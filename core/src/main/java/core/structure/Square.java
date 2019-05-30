package core.src.main.java.core.structure;

import java.util.Map;

public interface Square {
    interface Coordinate {
        /**
         * @return Immutable map of coordinates
         */
        Map<Dimensional, Integer> getCoordinates();
    }
}
