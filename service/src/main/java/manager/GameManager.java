package manager;

import core.src.main.java.core.controller.PlaygroundManager;
import core.src.main.java.core.controller.RoverManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GameManager {

    @Autowired
    private RoverManager roverManager;

    @Autowired
    private PlaygroundManager playgroundManager;

}
