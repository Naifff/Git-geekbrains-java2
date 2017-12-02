package ru.geekbrains.java2.dz.dz4.KrivonosovAlexey;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.*;

public class Win extends JFrame{
    private JTextField typeField;
    private JButton sendButton;
    private JPanel rootPanel;
    private JTabbedPane tabbedPane1;
    private JPanel Chat;
    private JPanel Settings;
    private JTextField setNameField;
    private JButton setNameButton;
    private JButton redButton;
    private JButton greenButton;
    private JButton blueButton;
    private JButton blackButton;
    private JTextPane textPane1;
    private String name = "UserName";
    private Color color = Color.BLACK;

    public Win(){
        setContentPane(rootPanel);
        setTitle("ChatWindow");
        setBounds(200,200,500,500);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                appendToPane(textPane1,name + ": " +typeField.getText() + "\n",color);
                typeField.setText("");
                typeField.isFocusOwner();
            }
        });
        typeField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                typeField.requestFocus();
            }
        });
        typeField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    appendToPane(textPane1,name + ": " +typeField.getText() + "\n", color);
                    typeField.setText("");
                    typeField.isFocusOwner();
                }
            }
        });
        setNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                name = setNameField.getText();
                setNameField.setText("");
            }
        });

        redButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                color = Color.RED;
                typeField.setForeground(color);
            }
        });

        blueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                color = Color.BLUE;
                typeField.setForeground(color);
            }
        });

        greenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                color = Color.GREEN;
                typeField.setForeground(color);
            }
        });

        blackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                color = Color.RED;
                typeField.setForeground(color);
            }
        });
    }
    private void appendToPane(JTextPane tp, String msg, Color c)
    {
        StyleContext sc = StyleContext.getDefaultStyleContext();
        AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, c);

        aset = sc.addAttribute(aset, StyleConstants.FontFamily, "Lucida Console");
        aset = sc.addAttribute(aset, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);

        int len = tp.getDocument().getLength();
        tp.setCaretPosition(len);
        tp.setCharacterAttributes(aset, false);
        tp.replaceSelection(msg);
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
