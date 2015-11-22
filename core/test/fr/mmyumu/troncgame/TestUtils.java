package fr.mmyumu.troncgame;

import java.lang.reflect.Field;

/**
 * Provide some utility methods for Tests
 * Created by mmyumu on 22/11/2015.
 */
public class TestUtils {
    public static Object retrieveValueFromObject(Object object, String memberName) {
        try {
            Field field = object.getClass().getDeclaredField(memberName);
            field.setAccessible(true);
            return field.get(object);
        } catch (NoSuchFieldException e) {
            throw new TestReflectionException("Error while retrieving the value of the member " + memberName + " in class " + object.getClass().getName() + "[object=" + object + "]", e);
        } catch (IllegalAccessException e) {
            throw new TestReflectionException("Error while retrieving the value of the member " + memberName + " in class " + object.getClass().getName() + "[object=" + object + "]", e);
        }
    }
}
