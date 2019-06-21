package core.elements.coordinate;

/**
 * CoordinateImpl map key - coordinate type.
 * currently supports three dimensions.
 * <p>
 * TODO: to be later created at initialization from configuration file.
 */
public enum AxisType {
    X("x-coordinate"), Y("y-coordinate"), Z("z-coordinate");

    private final String description;

    AxisType(String s) {
        description = s;
    }
}
