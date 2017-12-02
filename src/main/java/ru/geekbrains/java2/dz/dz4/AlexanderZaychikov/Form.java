package ru.geekbrains.java2.dz.dz4.AlexanderZaychikov;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class Form extends JFrame {

    private JTextField Message;
    private JTextArea TextAreaMessage;

    public Form() {

        setTitle("Типа Аська by MidleZi");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(200, 300, 500, 300);
        setVisible(true);

        TextAreaMessage = new JTextArea();
        TextAreaMessage.setEditable(false);
        TextAreaMessage.setLineWrap(true);
        JScrollPane jsp = new JScrollPane(TextAreaMessage);
        add(jsp, BorderLayout.CENTER);
        JPanel bottomPanel = new JPanel(new BorderLayout());
        add(bottomPanel, BorderLayout.SOUTH);
        JButton SendMessage = new JButton("Отправить");
        bottomPanel.add(SendMessage, BorderLayout.EAST);
        Message = new JTextField("Введите ваше сообщение: ");
        bottomPanel.add(Message, BorderLayout.CENTER);
        Font font = new Font("Comic Sans MS", Font.BOLD, 22);
        TextAreaMessage.setFont(font);


        // при фокусе поле сообщения очищается
        Message.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                Message.setText("");
            }
        });

        Message.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if(key == KeyEvent.VK_ENTER){
                TextAreaMessage.setText(TextAreaMessage.getText() + Message.getText());
                TextAreaMessage.append("\n");
                Message.setText("");
                }
            }
        });

        // обработчик события нажатия кнопки отправки сообщения
        SendMessage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            TextAreaMessage.setText(TextAreaMessage.getText() + Message.getText());
            TextAreaMessage.append("\n");
            }
        });
        setVisible(true);
    }
}