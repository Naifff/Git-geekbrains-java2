package ru.geekbrains.java2.dz.dz4.FedulovMS;

import java.util.Queue;

public abstract class AbstractChatController implements ChatController{

    protected Queue<ChatMessage> qMessages;
    protected Runnable updateFormCallback;

    @Override
    public abstract void sendMessage(ChatMessage msg);

    @Override
    public ChatMessage getNextMessage(){
        return qMessages.poll();
    }

    @Override
    public void setUpdateFormCallback(Runnable updateFormCallback){
        this.updateFormCallback = updateFormCallback;
    }

}
