package fr.mmyumu.troncgame.map;

/**
 * Map exception
 * Created by mmyumu on 18/08/2016.
 */
public class MapException extends RuntimeException {
    public MapException() {
    }

    public MapException(String message) {
        super(message);
    }

    public MapException(String message, Throwable cause) {
        super(message, cause);
    }

    public MapException(Throwable cause) {
        super(cause);
    }

    public MapException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
