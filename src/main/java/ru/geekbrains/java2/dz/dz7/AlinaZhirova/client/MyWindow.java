package ru.geekbrains.java2.dz.dz7.AlinaZhirova.client;

import oracle.jrockit.jfr.JFR;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;


public class MyWindow extends JFrame{

    JTextField jtf;
    JTextArea jta;

    final String SERVER_ADDR = "localhost";
    final int SERVER_PORT = 8189;
    Socket curSocket;
    DataInputStream in;
    DataOutputStream out;


    public MyWindow() {
        setBounds(600, 300, 500, 500);
        setTitle("Client");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jta = new JTextArea();
        jta.setEditable(false);
        jta.setLineWrap(true);
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
                connect("/auth\t" + jtfLogin.getText() + "\t" + jtfPass.getText());
                jtfLogin.setText("");
                jtfPass.setText("");
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
                    out.writeUTF("/end");
                    out.flush();
                    out.close();
                    in.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                } finally {
                    try {
                        curSocket.close();
                    } catch (IOException exc) {
                        exc.printStackTrace();
                    }
                }
            }
        });

        setVisible(true);
    }


    public void connect(String cmd) {
        try {
            curSocket = new Socket(SERVER_ADDR,SERVER_PORT);
            in = new DataInputStream(curSocket.getInputStream());
            out = new DataOutputStream(curSocket.getOutputStream());
            //setAuthorized(false);
            Thread curThread = new Thread(() -> {
                try {
                    while(true)
                    {
                        if (cmd.startsWith("/auth")) {
                            out.writeUTF(cmd);
                            //setAuthorized(true);
                            break;
                        }
                    }
                    while(true) {
                        String str = in.readUTF();
                        if (str.equals("/end")) {
                            break;
                        }
                        jta.append(str +"\n");
                    }
                }
                catch(IOException e) {
                    e.printStackTrace();
                }
                finally {
                    try {
                        curSocket.close();
                    }
                    catch(IOException e) {
                        e.printStackTrace();
                    }
                    //setAuthorized(false);
                }});
            curThread.setDaemon(true);
            curThread.start();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }


    public void sendMsg() {
        try {
            String messageToChat = jtf.getText();
            if (!messageToChat.trim().isEmpty()) {
                if (out != null) {
                    out.writeUTF(messageToChat);
                    out.flush();
                }
                jtf.setText("");
            }
        } catch (IOException e) {
            System.out.println("Send msg error");
        }
    }


}
