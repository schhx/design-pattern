package org.schhx.decorator;

import lombok.AllArgsConstructor;
import org.schhx.decorator.utils.FieldUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 对指定字段检查敏感字
 *
 * @author shanchao
 * @date 2018-11-13
 */
@AllArgsConstructor
public class SensitiveWordDao<T> implements Dao<T> {

    private Dao<T> delegate;

    private Set<String> fields;

    private static final List<String> sensitiveWords = Arrays.asList("三");

    @Override
    public String save(T t) {
        return delegate.save(t);
    }

    @Override
    public T getById(String id) {
        T t = delegate.getById(id);
        checkSensitiveWord(t);
        return t;
    }

    private void checkSensitiveWord(T t) {
        if(!fields.isEmpty()) {
            fields.stream().forEach(field -> doCheckSensitiveWord(t, field));
        }
    }

    private void doCheckSensitiveWord(T t, String field) {
        String value = (String) FieldUtils.getValue(t, field);
        if(value != null) {
            for(String word : sensitiveWords) {
                if(value.contains(word)) {
                    value = value.replace(word, "*");
                }
            }
            FieldUtils.setValue(t, field, value);
        }
    }


}
