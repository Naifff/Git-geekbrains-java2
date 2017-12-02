package ru.geekbrains.java2.dz.dz4.EmelyanovSergey;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;

public class MainWindow extends JFrame {

    private JTextArea historyText = new JTextArea();
    private JTextField newMessField = new JTextField();

    public MainWindow() {
        //Основные параметры
        setTitle("Сетевой чат");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 400, 400);

        setLayout(new BorderLayout());

        //первый слой - панели
        JPanel[] jp = new JPanel[3];
        jp[0] = new JPanel();
        jp[0].setBackground(new Color(255, 255, 255));
        jp[0].setLayout(new BorderLayout());
        add(jp[0], BorderLayout.CENTER);
        jp[1] = new JPanel();
        jp[1].setBackground(new Color(0, 255, 255));
        add(jp[1], BorderLayout.NORTH);
        jp[2] = new JPanel();
        jp[2].setBackground(new Color(255, 255, 255));
        add(jp[2], BorderLayout.SOUTH);

        //второй слой
        JScrollPane historyTextScroll = new JScrollPane(historyText);
        jp[0].add(historyTextScroll);

        JLabel label = new JLabel("Сообщения:");
        jp[1].setLayout(new BorderLayout());
        jp[1].add(label, BorderLayout.CENTER);


        JButton sendButton = new JButton("Отправить");
        jp[2].setLayout(new BorderLayout());
        jp[2].add(sendButton, BorderLayout.LINE_END);
        jp[2].add(newMessField, BorderLayout.CENTER);

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNewMessToTextArea();
            }
        });

        newMessField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNewMessToTextArea();

            }
        });

        setVisible(true);
    }

    private void addNewMessToTextArea() {

        if (newMessField.getText().length() > 0) {
            //historyText.insert(addText, 0);
            historyText.append((new Date()).toString() + ">>\n" +
                    newMessField.getText() +
                    "\n\n");
            newMessField.setText("");
        }

    }
}
