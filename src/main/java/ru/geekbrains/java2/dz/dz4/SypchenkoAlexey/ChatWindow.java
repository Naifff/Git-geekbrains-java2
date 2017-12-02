package ru.geekbrains.java2.dz.dz4.SypchenkoAlexey;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatWindow extends JFrame implements ActionListener {
    private final String WINDOW_TITLE = "MyChat";
    private final int WINDOW_WIDTH = 400, WINDOW_HEIGHT = 300;
    final String BUTTON_ENTER = "Enter";
    JTextPane dialogue; // поле со списком сообщений
    JTextField message; // поле ввода сообщения
    JScrollPane jsp; // организуем прокрутку \
    JPanel bottomPanel; // контейнер для поля ввода сообщения и кнопки Enter
    JButton enterButton; // кнопка Enter

    // конструктор окна
    public ChatWindow() {
        setTitle(WINDOW_TITLE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(null); // размещаем окно чата по центру экрана пользователя
        setResizable(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        dialogue = new JTextPane();
        dialogue.setEditable(false);
        dialogue.setContentType("text/html");
        jsp = new JScrollPane(dialogue); // поле с перепиской "завернули" в scroll
        bottomPanel = new JPanel(); // контейнер для поля ввода сообщения и кнопки Enter
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.X_AXIS));
        message = new JTextField();// прослушивателем будет объект ChatWindow
        message.addActionListener(this);
        enterButton = new JButton(BUTTON_ENTER);
        enterButton.addActionListener(this);

        // добавляем в контейнер
        bottomPanel.add(message);
        bottomPanel.add(enterButton);

        add(jsp, BorderLayout.CENTER); // разместили область диалога
        add(bottomPanel, BorderLayout.SOUTH); // добавили поле ввода и кнопку Enter
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (message.getText().trim().length() > 0) {
            try {
                StyledDocument doc = dialogue.getStyledDocument();
                doc.insertString(doc.getLength(), "You: " + message.getText() + "\n",
                        new SimpleAttributeSet());
            } catch (Exception ex) {
                System.out.println("WTF");
            }
        }
        message.setText("");
        message.requestFocusInWindow();
    }
}
