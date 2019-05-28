package core.src.main.java.core.action;

public interface Visitable {

    boolean isVisited();

    /**
     * Some thing that can walk can visit the square
     *
     * @param
     */
    void markVisited();

}
