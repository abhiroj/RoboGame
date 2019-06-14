package core.src.main.java.core.game;

public enum Type {
    TWOD("Two-Dimensional "), THREED("Three-Dimensional ");

    private String s;

    Type(String s) {
        this.s = s;
    }

    public String valueOf() {
        return s;
    }

}
