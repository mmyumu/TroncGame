package fr.mmyumu.troncgame;

/**
 * Thrown when there is an exception during the reflection in the tests
 * Created by mmyumu on 22/11/2015.
 */
public class TestReflectionException extends RuntimeException {
    public TestReflectionException(String message, Throwable cause) {
        super(message, cause);
    }
}
