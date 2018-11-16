package org.schhx.template;

/**
 * @author shanchao
 * @date 2018-11-16
 */
public class ResetPasswordSmsSender extends SmsSender {
    @Override
    protected String getContext() {
        return "您的密码被重置为：xxxxxx";
    }
}
