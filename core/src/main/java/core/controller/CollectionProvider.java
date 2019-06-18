
package core.controller;

import core.elements.coordinate.Coordinate;

/**
 * Classes implementing this plays the role of collection property from playground present at the coordinate
 */
public interface CollectionProvider {

    void collect(Coordinate c);

}