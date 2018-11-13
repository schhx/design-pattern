package org.schhx.decorator;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * @author shanchao
 * @date 2018-11-13
 */
public class Client {

    public static void main(String[] args) {
        // 基本操作
        System.out.println("基本操作");
        Dao<User> baseDao = new BaseDao<>();
        String id = baseDao.save(generateUser());
        User result = baseDao.getById(id);
        System.out.println("query data result: " + result.toString());


        // 加装饰
        System.out.println("\n\n加装饰：指定字段加解密");
        Set<String> encryptFields = new HashSet<String>() {{
            add("cellphone");
        }};
        Dao<User> encryptDao = new EncryptDao<>(baseDao, encryptFields);

        id = encryptDao.save(generateUser());
        result = encryptDao.getById(id);
        System.out.println("query data result: " + result.toString());



        // 加装饰
        System.out.println("\n\n加装饰：过滤敏感词");
        Set<String> sensitiveFields = new HashSet<String>() {{
            add("name");
        }};
        Dao<User> sensitiveDao = new SensitiveWordDao<>(baseDao, sensitiveFields);

        id = sensitiveDao.save(generateUser());
        result = sensitiveDao.getById(id);
        System.out.println("query data result: " + result.toString());


        // 组合装饰
        System.out.println("\n\n加装饰：组合装饰");
        sensitiveDao = new SensitiveWordDao<>(encryptDao, sensitiveFields);

        id = sensitiveDao.save(generateUser());
        result = sensitiveDao.getById(id);
        System.out.println("query data result: " + result.toString());
    }

    private static User generateUser() {
        return new User()
                .setId(UUID.randomUUID().toString())
                .setCellphone("18888888888")
                .setName("张三");
    }
}
