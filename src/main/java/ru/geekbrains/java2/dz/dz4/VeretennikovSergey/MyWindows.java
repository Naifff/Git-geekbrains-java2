package ru.geekbrains.java2.dz.dz4.VeretennikovSergey;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyWindows extends JFrame{

    public MyWindows() {
        setTitle("Сетевой чат");
        setBounds(800,200,500,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        JTextArea jta = new JTextArea(3,25);
        jta.setEditable(false);
        jta.setWrapStyleWord(true);
        JScrollPane jsp = new JScrollPane(jta);
        add(jsp, BorderLayout.CENTER);

        JPanel bPanel = new JPanel(new BorderLayout());
        add(bPanel, BorderLayout.SOUTH);
        JButton jb = new JButton("Отправить");
        bPanel.add(jb, BorderLayout.EAST);
        JTextField jtf = new JTextField();
        bPanel.add(jtf, BorderLayout.CENTER);

        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jta.append(jtf.getText() + "\n");
                jtf.setText("");
                jtf.grabFocus();
            }
        });

        jtf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               jta.append(jtf.getText() + "\n");
               jtf.setText("");
            }
        });

        setVisible(true);
    }
}
