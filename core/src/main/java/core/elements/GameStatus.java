package core.elements;

import core.utilities.CoreUtils;

/**
 * supports different ways to present status of action done on the game
 */
public class GameStatus {

    private final int code;
    private final String message;

    private GameStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * get status of the operation
     *
     * @return
     */
    public int getCode() {
        return code;
    }

    /**
     * get message from the operation
     *
     * @return
     */
    public String getMessage() {
        return message;
    }

    /**
     * static factory to provide a game status.
     *
     * @param code
     * @param message
     * @return
     */
    public static GameStatus createStatus(int code, String message) {
        CoreUtils.required("Status Code", code);
        CoreUtils.required("Status Message", message);

        return new GameStatus(code, message);
    }

}
