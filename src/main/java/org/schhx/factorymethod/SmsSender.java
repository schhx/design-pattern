package org.schhx.factorymethod;

/**
 * Created by schhx on 2017/9/21.
 */
public class SmsSender implements Sender {

    @Override
    public void send() {
        System.out.println("send sms");
    }
}
