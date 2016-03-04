package fr.mmyumu.troncgame.model.exception;

/**
 * Threw if an element cannot be found in the model
 * Created by mmyumu on 04/03/2016.
 */
public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
