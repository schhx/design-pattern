package org.schhx.decorator;

import lombok.AllArgsConstructor;
import org.schhx.decorator.utils.FieldUtils;

import java.util.Set;

/**
 * 对指定字段加密
 *
 * @author shanchao
 * @date 2018-11-13
 */
@AllArgsConstructor
public class EncryptDao<T> implements Dao<T>{
    private Dao<T> delegate;

    private Set<String> fields;

    @Override
    public String save(T t) {
        encrypt(t);
        return delegate.save(t);
    }

    @Override
    public T getById(String id) {
        T t = delegate.getById(id);
        decrypt(t);
        return t;
    }

    private void encrypt(T t){
        if(!fields.isEmpty()) {
            fields.stream().forEach(field -> encryptField(t, field));
        }
    }

    private void encryptField(T t, String field) {
        String value = (String) FieldUtils.getValue(t, field);
        if(value != null) {
            FieldUtils.setValue(t, field, "encrypt:" + value);
        }
    }

    private void decrypt(T t) {
        if(!fields.isEmpty()) {
            fields.stream().forEach(field -> decryptField(t, field));
        }
    }

    private void decryptField(T t, String field) {
        String value = (String) FieldUtils.getValue(t, field);
        if(value != null) {
            FieldUtils.setValue(t, field, value.replace("encrypt:", ""));
        }
    }
}
