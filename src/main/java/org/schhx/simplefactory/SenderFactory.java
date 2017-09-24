package org.schhx.simplefactory;

/**
 * Created by wosai-mac on 2017/9/24.
 */
public enum  SenderFactory {
    ;

    public static Sender getSender(String senderType){
        switch (senderType){
            case "sms":
                return new SmsSender();
            case "email":
                return new EmailSender();
            default:
                return new EmailSender();
        }
    }
}
