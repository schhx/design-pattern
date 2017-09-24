## 单例模式

### 介绍

**何时使用**：当你想让某一个类全局只有一个实例的时候


### 实现

- 懒汉模式，线程不安全

```
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

```

这种实现方法在单线程下没有问题，但是多线程下不能保证单例，不常使用

- 懒汉模式，线程安全

```
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
```

这种实现方法保证了单例，但是每一次获取实例时都要加锁，效率不高，这种方式也不经常使用

- 双检锁

```
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

```

这种实现方法避免了每次获取实例都加锁，只有在实例为null时才加锁，提高了效率，但是这种方法比较复杂，可行，但不推荐

- 饿汉模式

```
public class Singleton4 {

    private static Singleton4 singleton4 = new Singleton4();

    private Singleton4(){}

    public static Singleton4 getInstance(){
        return singleton4;
    }
}
```

这种模式一开始就新建一个实例，线程安全，实现简单，唯一的缺点是过早实例化，浪费内存，推荐使用

- 静态内部类

```
public class Singleton5 {

    private static class SingletonHolder {
        private static Singleton5 singleton5= new Singleton5();
    }

    private Singleton5(){}

    public static Singleton5 getInstance(){
        return SingletonHolder.singleton5;
    }
}
```

这种实现方式是对饿汉模式的优化，避免了一开始就实例化，推荐使用

- 枚举

```
public enum Singleton6 {
    INSTANCE;
}

```

这种实现方法最简单，自动支持序列化机制，绝对防止多次实例化，不过，由于JDK1.5之后才加入enum特性，只能在JDK1.5之后使用，推荐使用

### 代码
[示例代码 github](https://github.com/schhx/design-pattern)

