package org.schhx.factorymethod;

/**
 * Created by schhx on 2017/9/21.
 */
public class SmsSenderFactory implements SenderFactory {
    @Override
    public Sender getSender() {
        return new SmsSender();
    }
}
