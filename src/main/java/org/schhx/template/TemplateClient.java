package org.schhx.template;

/**
 * @author shanchao
 * @date 2018-11-16
 */
public class TemplateClient {
    public static void main(String[] args) {
        String cellphone = "88888888888";
        SmsSender smsSender = new AuthCodeSmsSender();
        smsSender.sendSms(cellphone);
        smsSender = new ResetPasswordSmsSender();
        smsSender.sendSms(cellphone);
    }
}
