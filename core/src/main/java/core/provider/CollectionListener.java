
package core.provider;

import core.elements.coordinate.Coordinate;

/**
 * Classes implementing this plays the role of collecting properties from playground present at the coordinates.
 * To be used by a rover to trigger a collection
 */
//TODO:Add copyright
public interface CollectionListener {

    /**
     * consumer intends to collect at this coordinate.
     * can be synchronized for multi threaded environments or not if implemented on event-based systems
     * @param coordinate
     */
    void collect(Coordinate coordinate);

}