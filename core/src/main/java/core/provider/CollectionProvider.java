
package core.provider;

import core.elements.coordinate.Coordinate;

/**
 * Classes implementing this plays the role of collecting properties from playground present at the coordinates.
 * To be used by a rover to trigger a collection
 */
//TODO:Add copyright
public interface CollectionProvider {

    /**
     * consumer intends to collect at this coordinate.
     *
     * @param coordinate
     */
    void collect(Coordinate coordinate);

}