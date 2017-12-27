package ru.geekbrains.java2.dz.dz7.lobysheva.client;

/*
 * Created by Oxana Lobysheva on 09/12/2017.
 */

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ChatRoomFrame extends JFrame {

    SimpleAttributeSet attrBlue = new SimpleAttributeSet();
    SimpleAttributeSet attrBLack = new SimpleAttributeSet();
    SimpleAttributeSet attrRed = new SimpleAttributeSet();

    StyledDocument doc;

    JTextField jtf;
    JTextPane jta;

    final String SERVER_ADDR = "localhost";
    final int SERVER_PORT = 8189;
    Socket sock;
    DataInputStream in;
    DataOutputStream out;

    public ChatRoomFrame() {

        setTitle("CHAT ROOM");
        setSize(400, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jta = new JTextPane();
        jta.setEditable(false);
        doc = jta.getStyledDocument();

        JScrollPane jsp = new JScrollPane(jta);
        add(jsp, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        JPanel authPanel = new JPanel(new GridLayout());

        JTextField jtfLogin = new JTextField("Login");
        JTextField jtfPass = new JTextField("Password");
        JButton jbAuth = new JButton("Auth");
        authPanel.add(jtfLogin);
        authPanel.add(jtfPass);
        authPanel.add(jbAuth);
        jtfLogin.setToolTipText("Login");
        jtfPass.setToolTipText("Password");
        add(authPanel, BorderLayout.NORTH);

        jbAuth.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                connect("auth\t" + jtfLogin.getText() + "\t" + jtfPass.getText());
            }
        });

        add(bottomPanel, BorderLayout.SOUTH);
        JButton jbSend = new JButton("SEND");
        bottomPanel.add(jbSend, BorderLayout.EAST);

        jtf = new JTextField();
        bottomPanel.add(jtf, BorderLayout.CENTER);

        jbSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMsg();
                jtf.grabFocus();
            }
        });

        jtf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMsg();
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                super.windowClosed(e);
                try {
                    out.writeUTF("end session");
                    out.flush();
                    out.close();
                    in.close();
                } catch (IOException exc) {
                } finally {
                    try {
                        sock.close();
                    } catch (IOException ex) {
                    }
                }
            }
        });

        setVisible(true);
    }

    public void connect(String cmd) {
        StyleConstants.setForeground(attrBlue, Color.BLUE);
        StyleConstants.setForeground(attrBLack, Color.BLACK);
        StyleConstants.setForeground(attrRed, Color.RED);

        try {
            sock = new Socket(SERVER_ADDR, SERVER_PORT);
            in = new DataInputStream(sock.getInputStream());
            out = new DataOutputStream(sock.getOutputStream());
            out.writeUTF(cmd);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        String stream = in.readUTF();

                        if (stream != null) {
                            if (stream.equalsIgnoreCase("end session")) break;

                            try {
                                String[] msg = extractParts(stream.trim());
                                String sender = msg[0];
                                String error = msg[1];
                                String text = msg[2];
                                doc.insertString(doc.getLength(), sender + " ", attrBlue);
                                doc.insertString(doc.getLength(), error + " ", attrRed);
                                doc.insertString(doc.getLength(), text + "\n", attrBLack);
                            } catch (BadLocationException e1) {
                                e1.printStackTrace();
                            }

                            jta.setCaretPosition(jta.getDocument().getLength());
                        }
                        Thread.sleep(100);
                    }
                } catch (Exception e) {
                }
            }
        }).start();
    }

    public void sendMsg() {
        try {
            String a = jtf.getText();
            if (!a.trim().isEmpty()) {
                if (out != null) {
                    out.writeUTF(a);
                    out.flush();
                }
                jtf.setText("");
            }
        } catch (IOException e) {
            System.out.println("SYSTEM: send msg error");
        }
    }

    private String[] extractParts(String msg){
        String[] updatedMsg = new String[]{"","",""};

        if (msg.length() == 0) return updatedMsg;

        String[] splitMsg = msg.split(" ");
        updatedMsg[0] = splitMsg[0];

        for (int i = 1; i < splitMsg.length; i++){
            if (splitMsg[i].equals("[error]") || splitMsg[i].equals("[private]")){
                updatedMsg[1] = updatedMsg[1] + " " + splitMsg[i];
            } else {
                updatedMsg[2] = updatedMsg[2] + " " + splitMsg[i];
            }
        }

        return updatedMsg;
    }

}
