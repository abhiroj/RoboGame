package core.elements;

/**
 * supports different ways to present game status
 */
public interface GameStatus {

    int getStatus();

    Object getMessage();

    static GameStatus createStatus(int status, Object message) {
        return new GameStatus() {
            @Override
            public int getStatus() {
                return status;
            }

            @Override
            public Object getMessage() {
                return message;
            }
        };
    }

}
