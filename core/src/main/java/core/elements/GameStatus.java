package core.elements;

import core.utilities.CoreUtils;

/**
 * supports different ways to present status of action done on the game
 */
//TODO:Add copyright
public class GameStatus {

    public enum Code {
        OK(200);

        private final int statusCode;

        Code(int i) {
            this.statusCode = i;
        }
    }

    private final Code code;
    private final String message;

    private GameStatus(Code code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * get status of the operation
     *
     * @return
     */
    public Code getCode() {
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
    public static GameStatus createStatus(Code code, String message) {
        CoreUtils.required("Status Code", code);
        CoreUtils.required("Status Message", message);
        return new GameStatus(code, message);
    }

}
