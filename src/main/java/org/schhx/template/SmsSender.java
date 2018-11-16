package org.schhx.template;

/**
 * @author shanchao
 * @date 2018-11-16
 */
public abstract class SmsSender {

    public void sendSms(String cellphone) {
        String context = getContext();
        System.out.println("给" + cellphone + "发短信：" + context);
    }

    /**
     * 获取短信内容
     *
     * @return
     */
    protected abstract String getContext();
}
