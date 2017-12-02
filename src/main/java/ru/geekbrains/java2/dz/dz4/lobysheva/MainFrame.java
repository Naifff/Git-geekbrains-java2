package ru.geekbrains.java2.dz.dz4.lobysheva;

/*
 * Created by Oxana Lobysheva on 27/11/2017.
 */

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainFrame extends JFrame {

    SimpleAttributeSet attrBlue = new SimpleAttributeSet();
    SimpleAttributeSet attrBLack = new SimpleAttributeSet();


    public MainFrame(User user){

        setTitle("CHAT ROOM");
        setSize(300, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(1,2));

        final JTextField userName = new JTextField();
        northPanel.add(new JLabel("User name: ", SwingConstants.CENTER));
        northPanel.add(userName);

        add(northPanel, BorderLayout.NORTH);

        final JTextPane textArea = new JTextPane();
        textArea.setEditable(false);
        final StyledDocument doc = textArea.getStyledDocument();
        JScrollPane centralPanel = new JScrollPane(textArea);

        add(centralPanel, BorderLayout.CENTER);

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(1,2));

        JButton buttonSend = new JButton("Send");
        buttonSend.setFont(new Font("Calibri", Font.BOLD, 15));
        buttonSend.setForeground(Color.BLUE);
        JTextField textInput = new JTextField();

        southPanel.add(textInput);
        southPanel.add(buttonSend);

        buttonSend.addMouseListener(new MouseAdapter()
                {
                    @Override
                    public void mouseClicked(MouseEvent e)
                    {
                        user.setUser(userName.getText());
                        sendMessage(doc, textInput.getText(), user);
                        textInput.setText("");
                    }
                }
        );

        textInput.addKeyListener(new KeyAdapter()
                {
                    @Override
                    public void keyPressed(KeyEvent e)
                    {
                        if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                            user.setUser(userName.getText());
                            sendMessage(doc, textInput.getText(), user);
                            textInput.setText("");
                        }
                    }
                }
        );

        add(southPanel, BorderLayout.SOUTH);
        setVisible(true);

    }



    private void sendMessage(StyledDocument doc, String message, User user){
        StyleConstants.setForeground(attrBlue, Color.BLUE);
        StyleConstants.setForeground(attrBLack, Color.BLACK);
        try {
            doc.insertString(doc.getLength(),"\n" + user.getUser() + ": ", attrBlue);
            doc.insertString(doc.getLength(), message, attrBLack);
        } catch (BadLocationException e1) {
            e1.printStackTrace();
        }
    }

}
