package fr.mmyumu.troncgame;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

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
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new TestReflectionException("Error while retrieving the value of the member " + memberName + " in class " + object.getClass().getName() + "[object=" + object + "]", e);
        }
    }

    public static <T extends Object> T runConstructor(Class<T> clazz) {
        try {
            Constructor<T> constructor = clazz.getDeclaredConstructor(new Class[0]);
            constructor.setAccessible(true);
            return constructor.newInstance(new Object[0]);
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new TestReflectionException("Error while running constructor of class " + clazz.getName(), e);
        }
    }

    public static <I extends Object> I runInnerClassConstructor(Class<I> innerClass) {
        try {
            Constructor<?> outerClassConstructor = innerClass.getDeclaringClass().getDeclaredConstructor(new Class[0]);
            outerClassConstructor.setAccessible(true);
            Object o = outerClassConstructor.newInstance(new Object[0]);
            Constructor<I> innerClassConstructor = innerClass.getDeclaredConstructor(innerClass.getDeclaringClass());
            innerClassConstructor.setAccessible(true);
            return innerClassConstructor.newInstance(o);
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new TestReflectionException("Error while running constructor of class " + innerClass.getName(), e);
        }
    }
}
