package org.schhx.strategy;


/**
 * Created by schhx on 2017/9/21.
 */
public class StrategyClient {

    public static void main(String[] args){
        SenderContext context = new SenderContext(new SmsSender());
        context.send();

        context.setSender(new EmailSender());
        context.send();
    }
}
