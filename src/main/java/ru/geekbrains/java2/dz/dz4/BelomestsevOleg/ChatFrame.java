package ru.geekbrains.java2.dz.dz4.BelomestsevOleg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatFrame extends JFrame {
    private JTextArea textArea;
    private JTextField textField;
    public static void main(String[] arg){
        ChatFrame chatFrame = new ChatFrame();
    }
    public ChatFrame (){
        super("Simple Chat");
        setSize(600,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(textArea);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        add(BorderLayout.CENTER, scroll);

        textField = new JTextField();
        JPanel southPanel = new JPanel(new BorderLayout());
        southPanel.add(textField);
        add(BorderLayout.SOUTH, southPanel);
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendText();
            }
        });

        JButton buttonSend = new JButton("Отправить");
        southPanel.add(BorderLayout.EAST,buttonSend);
        buttonSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendText();
            }
        });

        setVisible(true);
    }
    private void sendText(){
        if (!textField.getText().equals("")) {
            if (!textArea.getText().equals("")) textArea.append("\n");
            textArea.append(textField.getText());
            textField.setText("");
        }
    }
}
