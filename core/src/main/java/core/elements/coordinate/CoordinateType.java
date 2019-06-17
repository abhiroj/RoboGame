package core.elements.coordinate;

public enum CoordinateType {
    X("x-coordinate"), Y("y-coordinate"), Z("z-coordinate");

    private String desc;

    CoordinateType(String s) {
        desc = s;
    }
}
