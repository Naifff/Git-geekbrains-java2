package ru.geekbrains.java2.dz.dz4.YagudinAlexey;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Chat extends JFrame implements ActionListener {
    JTextArea jta;
    JTextField field;

    public Chat(){
        setTitle("Чатовка by Yagudza");
        setSize(1024,768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);


        JButton but = new JButton("Send");
        add(but);
        but.setBounds(860,630,100,20);
        but.setCursor(new Cursor(Cursor.HAND_CURSOR));
        but.addActionListener(this);


        jta = new JTextArea();
        JScrollPane jsp = new JScrollPane(jta);
        add(jsp);
        jsp.setBounds(50,20,750,600);

        field = new JTextField();
        add(field);
        field.setBounds(50,630,750,20);
        field.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        jta.append("Я: " + field.getText() + "\n");
        field.setText("");
    }
}

