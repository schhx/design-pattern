package org.schhx.template;

/**
 * @author shanchao
 * @date 2018-11-16
 */
public class AuthCodeSmsSender extends SmsSender {
    @Override
    protected String getContext() {
        return "您的验证码为：123456";
    }
}
