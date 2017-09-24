package org.schhx.singleton;

/**
 * 饿汉模式
 *
 * Created by schhx on 2017/9/24.
 */
public class Singleton4 {

    private static Singleton4 singleton4 = new Singleton4();

    private Singleton4(){}

    public static Singleton4 getInstance(){
        return singleton4;
    }
}
