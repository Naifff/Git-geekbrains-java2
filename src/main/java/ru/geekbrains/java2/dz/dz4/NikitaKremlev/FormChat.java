package ru.geekbrains.java2.dz.dz4.NikitaKremlev;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FormChat extends JFrame {

    private static final int WINDOW_WIDTH = 507;
    private static final int WINDOW_HEIGHT = 555;
    private static final int WINDOW_POS_X = 650;
    private static final int WINDOW_POS_Y = 250;

    public FormChat() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(WINDOW_POS_X, WINDOW_POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("My Chat");
        setLayout(new BorderLayout());

        // Панель для основного окна чата
        JPanel panelChat = new JPanel(new BorderLayout());
        // Панель для ввода текста и кнопки
        JPanel panelText = new JPanel(new BorderLayout());


        JTextArea chat = new JTextArea();
        chat.setEnabled(false);
        panelChat.add(chat, BorderLayout.CENTER);

        JTextField text = new JTextField();
        text.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (KeyEvent.VK_ENTER == e.getKeyCode()) {
                    sendMessage(chat, text);
                }
            }
        });
        JButton send = new JButton("Отправить");
        send.addActionListener(e -> sendMessage(chat, text));

        panelText.add(text, BorderLayout.CENTER);
        panelText.add(send, BorderLayout.EAST);

        this.add(panelChat, BorderLayout.CENTER);
        this.add(panelText, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void sendMessage(JTextArea textArea, JTextField textField) {
        textArea.append(textField.getText() + "\n");
        textField.setText("");
    }
}
