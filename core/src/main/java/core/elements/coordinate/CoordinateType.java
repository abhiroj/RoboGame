package core.elements.coordinate;

/**
 * Coordinate map value to coordinate type.
 */
public enum CoordinateType {
    X("x-coordinate"), Y("y-coordinate"), Z("z-coordinate");

    private String desc;

    CoordinateType(String s) {
        desc = s;
    }
}
