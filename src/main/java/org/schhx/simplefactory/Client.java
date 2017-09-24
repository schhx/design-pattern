package org.schhx.simplefactory;

/**
 * Created by schhx on 2017/9/21.
 */
public class Client {

    public static void main(String[] args){
        Sender sender = SenderFactory.getSender("email");
        sender.send();
        sender = SenderFactory.getSender("sms");
        sender.send();
    }
}
