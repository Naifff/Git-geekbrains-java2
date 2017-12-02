package ru.geekbrains.java2.dz.dz4.FedulovMS;

/*
 * Примитивная реализация, возвращающая сообщение форме чата вместо отправки на сервер.
 */

import java.util.LinkedList;

public class SimpleChatController extends AbstractChatController {

    public SimpleChatController() {
        this.qMessages = new LinkedList<>();
    }

    @Override
    public void sendMessage(ChatMessage msg){
        qMessages.add(msg);
        if (msg.getText().equals("Привет!")) qMessages.add(new ChatMessage("Somebody", "Сам привет!"));
        if (msg.getText().equals("Кто здесь?")) qMessages.add(new ChatMessage("Somebody", "Никого тут нет..."));
        this.updateFormCallback.run();
    }

}
