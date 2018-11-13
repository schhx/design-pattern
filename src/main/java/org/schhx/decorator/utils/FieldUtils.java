package org.schhx.decorator.utils;

import java.lang.reflect.Field;

/**
 * @author shanchao
 * @date 2018-11-13
 */
public class FieldUtils {

    public static Object getValue(Object o, String fieldName) {
        try {
            Field field = o.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(o);
        } catch (NoSuchFieldException e) {
            return null;
        } catch (IllegalAccessException e) {
            return null;
        } catch (SecurityException e) {
            return null;
        }
    }

    public static void setValue(Object o, String fieldName, String value) {
        try {
            Field field = o.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(o, value);
        } catch (NoSuchFieldException e) {
        } catch (IllegalAccessException e) {
        }
    }
}
