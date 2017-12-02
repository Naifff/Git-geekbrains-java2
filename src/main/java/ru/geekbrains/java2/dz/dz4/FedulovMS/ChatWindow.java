package ru.geekbrains.java2.dz.dz4.FedulovMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatWindow extends JFrame {

    private ChatController chatCtrl;

    private JTextArea tpText;
    private JScrollPane scrollPane;
    private JTextField tfMessage;
    private JButton bSend;

    public ChatWindow(){
        super();

        this.chatCtrl = new SimpleChatController();
        chatCtrl.setUpdateFormCallback(this::processMessages);

        this.tpText = new JTextArea();
        this.tpText.setEditable(false);
        this.tpText.setLineWrap(true);

        this.scrollPane = new JScrollPane(this.tpText);
        this.scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        this.scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        this.tfMessage = new JTextField();
        this.tfMessage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage("Я", tfMessage.getText());
            }
        });

        this.bSend = new JButton("Отправить");
        this.bSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage("Я", tfMessage.getText());
            }
        });

        JPanel jpBottom = new JPanel(new BorderLayout());
        jpBottom.add(this.tfMessage, BorderLayout.CENTER);
        jpBottom.add(this.bSend, BorderLayout.EAST);

        this.setLayout(new BorderLayout());
        this.add(this.scrollPane, BorderLayout.CENTER);
        this.add(jpBottom, BorderLayout.SOUTH);

        this.setTitle("Chat");
        this.setSize(450, 600);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.setVisible(true);
    }

    private void sendMessage(String sender, String text){
        if (!text.isEmpty()) {
            this.chatCtrl.sendMessage(new ChatMessage(sender, text));
            this.tfMessage.setText("");
        }
        this.tfMessage.requestFocusInWindow();
    }

    private void showMessage(ChatMessage msg){
        this.tpText.append(msg.getSender()+": "+msg.getText()+"\n");
    }

    private void processMessages(){
        ChatMessage msg;
        msg = this.chatCtrl.getNextMessage();
        while (msg != null){
            this.showMessage(msg);
            msg = this.chatCtrl.getNextMessage();
        }
    }
}
