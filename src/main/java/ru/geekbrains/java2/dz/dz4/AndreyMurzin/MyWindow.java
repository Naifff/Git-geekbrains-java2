package ru.geekbrains.java2.dz4.AndreyMurzin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyWindow extends JFrame {
    public MyWindow(){
        setTitle("Сетевой чат...");
        setDefaultCloseOperation(3);
        setSize(500,500);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        final JTextArea txtChat = new JTextArea();
        txtChat.setEditable(false);
        txtChat.setFont(new Font("Dialog", Font.PLAIN, 16));
        txtChat.setBackground(new Color(250,250,150));
        JScrollPane scroll = new JScrollPane(txtChat);
        add(scroll);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        add(panel,BorderLayout.SOUTH);

        final JTextField txtEnter = new JTextField();
        txtEnter.setFont(new Font("Dialog", Font.PLAIN, 16));
        panel.add(txtEnter,BorderLayout.CENTER);
        txtEnter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtChat.setText(txtChat.getText() + "Я: "  + txtEnter.getText() + "\n");
                txtEnter.setText("");
            }
        });

        JButton butEnter = new JButton("Отправить");
        panel.add(butEnter,BorderLayout.EAST);
        butEnter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtChat.setText(txtChat.getText() + "Я: "  + txtEnter.getText() + "\n");
                txtEnter.setText("");
            }
        });

        setVisible(true);
    }
}
