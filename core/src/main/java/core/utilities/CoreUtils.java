package core.src.main.java.core.utilities;

import java.text.MessageFormat;

public final class CoreUtils {

    private CoreUtils() {

    }

    public static String format(String format, Object... args) {
        return MessageFormat.format(format, args);
    }

}
