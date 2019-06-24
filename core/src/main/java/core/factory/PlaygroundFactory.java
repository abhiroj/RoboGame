package core.factory;

import core.elements.playground.Playground;
import core.elements.playground.Playground2DImpl;
import core.elements.shape.SandboxShape;

//TODO:Add copyright
public class PlaygroundFactory {

    private PlaygroundFactory() {
        //This gets a new instance of a playground for ever call
    }

    public static Playground get2DPlayground(SandboxShape[][] shapes2D) {
        return new Playground2DImpl(shapes2D);
    }


}
