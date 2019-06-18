package core.elements;

/**
 * supports different ways to present status of action done on the game
 */
public interface GameStatus {

    /**
     * get status of the operation
     * @return
     */
    int getStatus();

    /**
     * get message from the operation
     * @return
     */
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
