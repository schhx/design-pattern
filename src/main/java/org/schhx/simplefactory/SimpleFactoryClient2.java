package org.schhx.simplefactory;

/**
 * Created by schhx on 2017/9/21.
 */
public class SimpleFactoryClient2 {

    public static void main(String[] args){
        Sender sender = SenderFactory2.getSender(SenderType.EMAIL);
        sender.send();
        sender = SenderFactory2.getSender(SenderType.SMS);
        sender.send();
    }
}
