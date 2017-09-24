package org.schhx.singleton;

/**
 * 懒汉模式，线程安全
 *
 * Created by schhx on 2017/9/24.
 */
public class Singleton2 {

    private static Singleton2 singleton2;

    private Singleton2(){}

    public static synchronized Singleton2 getInstance(){
        if(singleton2 == null){
            singleton2 = new Singleton2();
        }
        return singleton2;
    }
}
