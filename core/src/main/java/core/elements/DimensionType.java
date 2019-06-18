package core.elements;

/**
 * components having dimension should use this class to provide it's dimension type
 */
public enum DimensionType {
    ONED("One-Dimensional "), TWOD("Two-Dimensional "), THREED("Three-Dimensional ");

    private String s;

    DimensionType(String s) {
        this.s = s;
    }

    public String valueOf() {
        return s;
    }

}
