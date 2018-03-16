package org.schhx.strategy;

/**
 * Created by schhx on 2017/9/21.
 */
public class SmsSender implements Sender {

    public void send() {
        System.out.println("send sms");
    }
}
