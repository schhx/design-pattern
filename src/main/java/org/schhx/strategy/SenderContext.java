package org.schhx.strategy;

/**
 * Created by schhx on 2017/9/28.
 */
public class SenderContext {

    private Sender sender;

    public SenderContext(Sender sender){
        this.sender = sender;
    }

    public void send(){
        sender.send();
    }

    public Sender getSender() {
        return sender;
    }

    public void setSender(Sender sender) {
        this.sender = sender;
    }
}
