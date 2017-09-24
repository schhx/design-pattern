package org.schhx.singleton;

/**
 * 双检锁
 *
 * Created by schhx on 2017/9/24.
 */
public class Singleton3 {

    private static Singleton3 singleton3;

    private Singleton3(){}

    public static Singleton3 getInstance(){
        if(singleton3 == null){
            synchronized (Singleton3.class){
                if(singleton3 == null) {
                    singleton3 = new Singleton3();
                }
            }
        }
        return singleton3;
    }
}
