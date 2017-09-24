package org.schhx.simplefactory;

/**
 * Created by schhx on 2017/9/21.
 */
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
