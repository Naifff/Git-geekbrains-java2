package ru.geekbrains.java2.dz.dz6.NikitaKremlev;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class FormClient extends JFrame {

    private static final int WINDOW_X_POS = 400;
    private static final int WINDOW_Y_POS = 100;
    private static final int WINDOW_WIDTH = 300;
    private static final int WINDOW_HEIGHT = 600;

    private static final String SERVER_ADDR = "localhost";
    private static final int SERVER_PORT = 8189;

    private Socket socket;
    private Scanner in;
    private PrintWriter out;

    private JTextArea jtaChatText;
    private JTextField jtfSendText;
    private JButton jbSend;

    public FormClient() {
        setTitle("Клиент");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(WINDOW_X_POS, WINDOW_Y_POS, WINDOW_WIDTH, WINDOW_HEIGHT);
        setResizable(false);

        JPanel chatPanel = new JPanel(new BorderLayout());
        JPanel sendPanel = new JPanel(new BorderLayout());

        // Компоненты для основного окна чата
        jtaChatText = new JTextArea();
        jtaChatText.setEnabled(false);
        jtaChatText.setLineWrap(true);
        JScrollPane spChatText = new JScrollPane(jtaChatText);

        chatPanel.add(spChatText, BorderLayout.CENTER);

        // Компоненты для панели отправки сообщений
        jtfSendText = new JTextField();
        jtfSendText.setEnabled(false);
        jbSend = new JButton("Отправить");

        jbSend.addActionListener(e -> {
            sendMessage();
            jtfSendText.grabFocus();
        });

        sendPanel.add(jtfSendText, BorderLayout.CENTER);
        sendPanel.add(jbSend, BorderLayout.EAST);

        add(chatPanel, BorderLayout.CENTER);
        add(sendPanel, BorderLayout.SOUTH);

        setVisible(true);

        try {
            socket = new Socket(SERVER_ADDR, SERVER_PORT);
            jtfSendText.setEnabled(true);
            in = new Scanner(socket.getInputStream());
            out = new PrintWriter(socket.getOutputStream());
            while (!socket.isClosed()) {
                getMessage();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        in.close();
        out.close();
    }

    private void sendMessage() {
        if (!jtfSendText.getText().trim().isEmpty()) {
            String param = jtfSendText.getText();
            out.println(param);
            out.flush();
            jtfSendText.setText("");
        }
    }

    private void getMessage() {
        String entry = in.nextLine();
        jtaChatText.append("Server: " + entry + "\n");
    }

    public static void main(String[] args) {
        new FormClient();
    }
}
