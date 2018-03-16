package org.schhx.factorymethod;

/**
 * Created by schhx on 2017/9/21.
 */
public class Client {

    public static void main(String[] args){
        Sender sender = new EmailSenderFactory().getSender();
        sender.send();
        sender = new SmsSenderFactory().getSender();
        sender.send();
    }
}
