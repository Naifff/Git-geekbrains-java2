package ru.geekbrains.java2.dz.dz7.SypchenkoAlexey.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class MyWindow extends JFrame {
    JTextField jtf;
    JTextArea jta;
    private final String SERVER_ADDR = "localhost";
    private final int SERVER_PORT = 8189;
    Socket sock;
    DataInputStream in;
    DataOutputStream out;

    public MyWindow() {
        setTitle("Chat client");
        setSize(400, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);
        jta = new JTextArea();
        jta.setEditable(false);
        jta.setLineWrap(true);
        JScrollPane jsp = new JScrollPane(jta);
        add(jsp, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        JPanel authPanel = new JPanel(new GridLayout());

        JTextField jtfLogin = new JTextField("Your login");
        JTextField jtfPass = new JTextField("Your password");
        JButton jbAuth = new JButton("Auth");
        authPanel.add(jtfLogin);
        authPanel.add(jtfPass);
        authPanel.add(jbAuth);
        add(authPanel, BorderLayout.NORTH);
        jbAuth.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                connect("auth\t" + jtfLogin.getText() + "\t" + jtfPass.getText());
                // убираем кнопку авторизации после факта авторизации
                authPanel.remove(jbAuth);
                authPanel.remove(jtfPass);
                jtfLogin.setEditable(false);
                repaint();
            }
        });
        add(bottomPanel, BorderLayout.SOUTH);
        JButton jbSend = new JButton("Send");
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
            in = new DataInputStream((sock.getInputStream()));
            out = new DataOutputStream(sock.getOutputStream());
            out.writeUTF(cmd); // отправляем на сервер строку авторизации
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        String w = in.readUTF(); // читаем что приходит с сервера
                        if (w != null) {
                            if (w.equalsIgnoreCase("end session")) break;
                            jta.append(w);
                            jta.append("\n");
                            jta.setCaretPosition(jta.getDocument().getLength()); // перемещаем курсор в конец jta
                        }
                        Thread.sleep(500);
                    }
                } catch (Exception e) {

                }
            }
        }).start();
    }

    public void sendMsg() {
        try {
            String a = jtf.getText();
            if (!a.trim().isEmpty()) { // сравнивает по длине строки, поэтому работает быстрее, чем equals
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
