package core.utilities;

import core.exception.AppException;

import java.text.MessageFormat;
import java.util.Objects;

public final class CoreUtils {

    private CoreUtils() {
        //this class provides support methods for the module
    }

    public static String format(String format, Object... args) {
        return MessageFormat.format(format, args);
    }

    public static void required(String key, Object param) {
        if (Objects.isNull(param)) {
            throw new AppException("Required " + key);
        }
    }

}
