package core.src.main.java.core.structure;

import java.util.Map;

public interface Playground {

    interface Boundary {

        /**
         * Get Dimensional Limits of Playground, originates at 0,0 and expands for +ve values of x&y.
         *
         * @return
         */
        Map<Dimensional, Integer> getBounds();
    }

    void deploy(Rover rover, int x, int y);

    void demobilize(Rover rover);

}
