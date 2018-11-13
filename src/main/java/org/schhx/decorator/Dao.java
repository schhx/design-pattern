package org.schhx.decorator;

/**
 * @author shanchao
 * @date 2018-11-13
 */
public interface Dao<T> {

    String save(T t);

    T getById(String id);
}
