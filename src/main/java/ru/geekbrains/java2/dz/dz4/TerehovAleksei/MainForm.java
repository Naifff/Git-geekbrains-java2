package ru.geekbrains.java2.dz.dz4.TerehovAleksei;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainForm extends JFrame {
    private JPanel rootPanel;
    private JTextArea textAreaHistory;
    private JPanel bottomPanel;
    private JTextField textFieldInput;
    private JButton btnSend;
    private JLabel label1;
    private JLabel label2;

    public MainForm() {
        setContentPane(rootPanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Geekbrains ЧАТ");

        setBounds(200, 200, 600, 450);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu menuFile = new JMenu("Файл");
        JMenu menuInfo = new JMenu("О программе");
        JMenuItem menuSave = new JMenuItem("Сохранить как...");
        JMenuItem menuExit = new JMenuItem("Выход");
        menuExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        menuBar.add(menuFile);
        menuBar.add(menuInfo);
        menuFile.add(menuSave);
        menuFile.addSeparator();
        menuFile.add(menuExit);

        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addMessage();
            }
        });
        textFieldInput.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    addMessage();
                }
            }
        });
        setVisible(true);
    }

    private void addMessage() {
        if (!textFieldInput.getText().trim().isEmpty()) {
            String message = textAreaHistory.getText();
            if (!message.trim().isEmpty()){
                message+="\n";
            }
            message+=textFieldInput.getText();
            textAreaHistory.setText(message);
            textFieldInput.setText("");
        }
    }

    public static void main(String[] args) {
        new MainForm();
    }
}
