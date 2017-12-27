package ru.geekbrains.java2.dz.dz7.beloborodovdenis.client;

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

public class MyWindow extends JFrame {

    JTextField jtf;
    JTextArea jta;

    final String SERVER_ADDR = "localhost";
    final int SERVER_PORT = 8189;
    Socket sock;
    DataInputStream in;
    DataOutputStream out;

    String loginWindow ="";


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
                loginWindow = jtfLogin.getText();
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
                System.out.println(loginWindow);
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
                    out.writeUTF("end");
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
                        String w = in.readUTF();
                        String[] ws = w.split(" ");
                        if (w != null) {
                            if (w.equalsIgnoreCase("end session")) break;
                            if ((ws[1]).compareToIgnoreCase("/w") == 0) {
                                System.out.println("ws2(1) = "+ws[2]);
                                System.out.println("log = "+loginWindow);
                               if (loginWindow.equals(ws[2])) {
                                   System.out.println("Ура!");

                               } else {
                                   w="";
                               }
                            }
                            System.out.println(w);
                            jta.append(w);
                            jta.append("\n");
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
            System.out.println("Send msg error");
        }
    }
}
