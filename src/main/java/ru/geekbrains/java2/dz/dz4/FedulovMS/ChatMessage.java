package ru.geekbrains.java2.dz.dz4.FedulovMS;

public class ChatMessage {

    private String sender;
    private String text;

    public ChatMessage(String sender, String text) {
        this.sender = sender;
        this.text = text;
    }

    public String getSender() {
        return sender;
    }

    public String getText() {
        return text;
    }
}
