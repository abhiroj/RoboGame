package core.src.main.java.core.game;

import java.util.Map;

public interface MessageHandler {

    Map<String, Object> collect(Coordinate coordinate);

    boolean shouldMove(Coordinate coordinate);
}
