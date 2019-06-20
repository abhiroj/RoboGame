
package core.manager;

import core.elements.coordinate.Coordinate;

/**
 * Classes implementing this plays the role of collecting properties from playground present at the coordinates
 */
public interface CollectionProvider {

    void collect(Coordinate c);

}