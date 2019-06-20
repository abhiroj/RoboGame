package core.elements;

/**
 * supports different ways to present status of action done on the game
 */
public interface GameStatus {

    /**
     * get status of the operation
     * @return
     */
    int getCode();

    /**
     * get message from the operation
     * @return
     */
    Object getMessage();

    static GameStatus status(int code, Object message) {
        return new GameStatus() {
            @Override
            public int getCode() {
                return code;
            }

            @Override
            public Object getMessage() {
                return message;
            }
        };
    }

}
