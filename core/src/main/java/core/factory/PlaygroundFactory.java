package core.factory;

import core.elements.playground.Playground;
import core.elements.playground.Playground2DImpl;
import core.elements.shape.Shape;

/**
 * \
 */
public class PlaygroundFactory {

    private PlaygroundFactory() {
        //This gets a new instance of a playground for ever call
    }

    public static Playground get2DPlayground(Shape[][] shape2D) {
        return new Playground2DImpl(shape2D);
    }


}
