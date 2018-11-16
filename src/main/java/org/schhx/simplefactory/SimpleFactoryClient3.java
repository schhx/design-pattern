package org.schhx.simplefactory;

/**
 * Created by schhx on 2017/9/21.
 */
public class SimpleFactoryClient3 {

    public static void main(String[] args){
        Sender sender = SenderFactory3.getSender(EmailSender.class);
        sender.send();
    }
}
