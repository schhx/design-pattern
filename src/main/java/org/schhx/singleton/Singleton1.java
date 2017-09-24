package org.schhx.singleton;

/**
 * 懒汉模式，线程不安全
 *
 * Created by schhx on 2017/9/24.
 */
public class Singleton1 {

    private static Singleton1 singleton1;

    private Singleton1(){}

    public static Singleton1 getInstance(){
        if(singleton1 == null){
            singleton1 = new Singleton1();
        }
        return singleton1;
    }
}
