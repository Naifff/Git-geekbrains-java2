package ru.geekbrains.java2.dz.dz4.AndreyMelchuk;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Timestamp;
import java.util.Calendar;

public class ChatWin {
    private JTextArea textArea1;
    private JTextField textField1;
    private JButton sendbutton;
    private JPanel panel1;
    private JList list1;
    private DefaultListModel nicknames;

    public ChatWin(){
        nicknames = (DefaultListModel)list1.getModel();
        System.out.println(nicknames.get(0));
        System.out.println(nicknames.get(1));
        System.out.println(nicknames.get(2));
        //System.out.println(nicks.get(3));
        addNick("Test1");
        addNick("Test2");

        sendbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Send();
            }
        });

        textField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (KeyEvent.VK_ENTER == e.getKeyCode())
                    Send();
            }
        });


    }

    public void addNick(String nick){
        nicknames.addElement(nick);
    }

    public String getMyNick(){
        return (String)nicknames.get(0);
    }


    private void Send(){
        if(!textField1.getText().isEmpty()){
            //JOptionPane.showMessageDialog(null,textField1.getText());
            Timestamp currentTimestamp = new Timestamp(Calendar.getInstance().getTime().getTime());
            textArea1.append("[" + currentTimestamp + "] "+ getMyNick() + " : " + textField1.getText()+"\n");
            //System.out.println((char)27 + "[33;40m"+ currentTimestamp + ": "+textField1.getText()+'\n');
            textField1.setText("");

        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Chat Window");
        frame.setContentPane(new ChatWin().panel1);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setBounds(500, 200, 800, 600);

        frame.setVisible(true);
        Container c = frame.getContentPane();

    }



}
