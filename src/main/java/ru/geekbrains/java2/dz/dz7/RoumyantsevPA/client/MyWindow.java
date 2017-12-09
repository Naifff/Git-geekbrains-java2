package ru.geekbrains.java2.dz.dz7.RoumyantsevPA.client;

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

import static java.awt.Color.black;
import static java.awt.Color.green;

public class MyWindow extends JFrame {

    JTextField jtf;
    JTextArea jta;

    final String SERVER_ADDR = "localhost";
    final int SERVER_PORT = 8189;
    Socket sock;
    DataInputStream in;
    DataOutputStream out;

    public MyWindow() {

        Image img = Toolkit.getDefaultToolkit().getImage(".\\src\\main\\java\\ru\\geekbrains\\java2\\dz\\dz7\\RoumyantsevPA\\java.png");
        setIconImage(img);
        setSize(800, 600);
        setTitle("M a t r i x   has   U. . .");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jta = new JTextArea();
        jta.setEditable(false);
        jta.setLineWrap(true);
        jta.setBackground(black);
        jta.setForeground(green);

        JScrollPane jsp = new JScrollPane(jta);
        jsp.setBackground(black);
        add(jsp, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBackground(black);
        add(bottomPanel, BorderLayout.SOUTH);
        JButton jbSend = new JButton("SEND");
        bottomPanel.add(jbSend, BorderLayout.EAST);
        jtf = new JTextField();
        jtf.setBackground(black);
        jtf.setForeground(green);
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

        try {
            sock = new Socket(SERVER_ADDR, SERVER_PORT);
            in = new DataInputStream(sock.getInputStream());
            out = new DataOutputStream(sock.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        String w = in.readUTF();
                        if (w != null) {
                            if (w.equalsIgnoreCase("end session")) {
                                jta.append("end session");
                                break;
                            }
                            jta.append(w);
                            jta.append("\n");
                            jta.setCaretPosition(jta.getDocument().getLength());
                        }
                        Thread.sleep(100);
                    }
                } catch (Exception e) {
                } finally {
                    {
                        try {
                            sock.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            in.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            out.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        });
        //   t.setDaemon(true);
        t.start();

        setVisible(true);
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
