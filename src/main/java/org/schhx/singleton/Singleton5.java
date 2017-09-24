package org.schhx.singleton;

/**
 * 饿汉模式
 *
 * Created by schhx on 2017/9/24.
 */
public class Singleton5 {

    private static class SingletonHolder {
        private static Singleton5 singleton5= new Singleton5();
    }

    private Singleton5(){}

    public static Singleton5 getInstance(){
        return SingletonHolder.singleton5;
    }
}
