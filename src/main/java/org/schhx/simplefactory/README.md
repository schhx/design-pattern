## 简单工厂

### 介绍

**何时使用**：当有几个行为一致的类，且每次根据情况选择使用其中一个时

### 实现

有时候我们需要对自己的服务加一些监控的代码，当发生某些情况时，发出一些报警，通常的报警方式有发邮件报警、发短信报警等等，这时我们就可以采用简单工厂。

#### 第一版

1. 我们先有一个发出报警信息的接口

```
public interface Sender {

    void send();
}
```

2. 实现具体的发邮件报警和发短信报警

```
public class EmailSender implements Sender {

    public void send() {
        System.out.println("send email");
    }
}
```

```
public class SmsSender implements Sender {

    public void send() {
        System.out.println("send sms");
    }
}
```

3. 实现工厂类

```
public enum  SenderFactory {
    ;

    public static Sender getSender(String senderType){
        switch (senderType){
            case "sms":
                return new SmsSender();
            case "email":
                return new EmailSender();
            default:
                return new EmailSender();
        }
    }
}
```

4. 客户端

```
public class Client {

    public static void main(String[] args){
        Sender sender = SenderFactory.getSender("email");
        sender.send();
        sender = SenderFactory.getSender("sms");
        sender.send();
    }
}
```

这种实现方法基本实现了简单工厂，但是也存在问题，客户端在使用工厂的时候，传入的是字符串，很容易输错

#### 第二版

第二版我们要解决第一版容易把参数传错的问题，方法就是使用枚举

1. 我们先新建一个枚举类

```
public enum SenderType {
    SMS, EMAIL;
}
```

2. 工厂类接收的参数改为枚举值

```
public enum SenderFactory2 {
    ;

    public static Sender getSender(SenderType senderType){

        switch (senderType){
            case SMS:
                return new SmsSender();
            case EMAIL:
                return new EmailSender();
            default:
                return new EmailSender();
        }
    }
}
```

这样就不可能把参数传错了

第二版还存在一些问题，当我们新增一种报警方法时就要修改工厂类

#### 第三版

第三版我们通过反射来解决第二版新增报警方法要修改工厂类的问题

```
public enum SenderFactory3 {
    ;

    private static String msg = "创建Sender失败";

    public static Sender getSender(Class<? extends Sender> clazz){
        try {
            return (Sender) Class.forName(clazz.getName()).newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(msg);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(msg);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(msg);
        }
    }
}
```

客户端使用

```
public class Client3 {

    public static void main(String[] args){
        Sender sender = SenderFactory3.getSender(EmailSender.class);
        sender.send();
    }
}
```

这样在新增一种报警方法时，就不需要改工厂类了






### 代码
[示例代码 github](https://github.com/schhx/design-pattern)

