package org.schhx.simplefactory;

/**
 * Created by schhx on 2017/9/21.
 */
public enum SenderFactory2 {
    ;

    public static Sender getSender(SenderType senderType){

        switch (senderType){
            case SMS:
                return new SmsSender();
            case EMAIL:
                return new EmailSender();
            default:
                return new EmailSender();
        }
    }
}
