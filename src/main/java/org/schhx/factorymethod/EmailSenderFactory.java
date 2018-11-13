package org.schhx.factorymethod;

/**
 * Created by schhx on 2017/9/21.
 */
public class EmailSenderFactory implements SenderFactory {

    @Override
    public Sender getSender() {
        return new EmailSender();
    }
}
