package org.schhx.simplefactory;

/**
 * Created by schhx on 2017/9/21.
 */
public class EmailSender implements Sender {

    public void send() {
        System.out.println("send email");
    }
}
