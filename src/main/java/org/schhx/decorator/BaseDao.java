package org.schhx.decorator;

import java.lang.reflect.Field;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author shanchao
 * @date 2018-11-13
 */
public class BaseDao<T> implements Dao<T> {

    private ConcurrentHashMap<String, T> map = new ConcurrentHashMap<>();

    @Override
    public String save(T t) {
        String id;
        try {
            Field field = t.getClass().getField("id");
            id = (String) field.get(t);
        } catch (Exception e) {
            id = UUID.randomUUID().toString();
        }
        map.put(id, t);
        System.out.println("save data: " + t.toString());
        return id;
    }

    @Override
    public T getById(String id) {
        return map.get(id);
    }
}
