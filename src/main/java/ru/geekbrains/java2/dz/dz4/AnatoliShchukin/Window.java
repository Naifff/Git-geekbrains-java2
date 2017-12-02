package ru.geekbrains.java2.dz.dz4.AnatoliShchukin;

import javax.swing.*;
import java.awt.event.*;

public class Window extends JFrame {
    private JPanel mainPanel;
    private JTextArea outputWin;
    private JButton sendButton;
    private JTextField inputWin;
    private String input = " ";
    private String output = " ";
    private String username = "testUser: ";
    public Window() {


        setName("Chat");
        setContentPane(mainPanel);
        setVisible(true);
        setSize(700,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // win.inputWin.setSize(400,50);
        setResizable(false);
        outputWin.setEditable(false);

        inputWin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {



            }
        });


        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input = inputWin.getText();
                output = output + "\n" +username+input;
                outputWin.setText(output);
                inputWin.setText("");

            }
        });


        inputWin.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyChar() == KeyEvent.VK_ENTER){
                    input = inputWin.getText();
                    output = output + "\n" +username+input;
                    outputWin.setText(output);
                    inputWin.setText("");
                }
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
