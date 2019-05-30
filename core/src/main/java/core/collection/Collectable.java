package core.src.main.java.core.collection;

import java.util.Map;

public interface Collectable {

    /**
     * Determines whether the collectable can be collected or not
     * @return
     */
    boolean isCollectable();

    /**
     * map of properties to be collected if the object is collectable
     * @return
     */
    Map<String,Object> provide();

}
