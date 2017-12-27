package ru.geekbrains.java2.dz.dz7.BelomestsevOleg.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ChatClient extends JFrame {     // Версия со смайликами :). jpg файлы со смайлами находятса в папке Smiles
    private JTextArea textArea;
    private JTextField textField;

    final String SERVER_ADDR = "localhost";
    final int SERVER_PORT = 8686;
    Socket sock;
    DataInputStream in;
    DataOutputStream out;

    public static void main(String[] arg){
        ChatClient chatFrame = new ChatClient();
    }
    public ChatClient(){
        super("Chat 2.0 - with smiles");
        setSize(600,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(textArea);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        add(BorderLayout.CENTER, scroll);

        JPanel authPanel = new JPanel(new BorderLayout());
        JTextField jtfLogin = new JTextField("Login");
        JTextField jtfPass = new JTextField("Password");
        JButton jbAuth = new JButton("Подключиться");
        JPanel authPanelFields = new JPanel(new GridLayout());
        authPanelFields.add(jtfLogin);
        authPanelFields.add(jtfPass);
        authPanel.add(authPanelFields);
        authPanel.add(jbAuth, BorderLayout.EAST);
        jtfLogin.setToolTipText("Login");
        jtfPass.setToolTipText("Password");
        add(authPanel, BorderLayout.NORTH);

        jbAuth.addActionListener(e -> connect("auth\t" + jtfLogin.getText() + "\t" + jtfPass.getText()));

        textField = new JTextField();
        JPanel southPanel2 = new JPanel(new BorderLayout());
        southPanel2.add(textField);
        textField.addActionListener(e -> sendText());

        JPanel southPanel1 = new JPanel();
        southPanel1.setLayout(new BoxLayout(southPanel1, BoxLayout.X_AXIS));

        JPanel panel0 = new JPanel(new BorderLayout());
        add(BorderLayout.SOUTH, panel0);
        panel0.add(BorderLayout.WEST,southPanel1);
        panel0.add(BorderLayout.SOUTH,southPanel2);

        JButton buttonSend = new JButton("Отправить");
        southPanel2.add(BorderLayout.EAST,buttonSend);
        buttonSend.addActionListener(e -> {
            sendText();
            textField.grabFocus();
        });
        SmilePanel[] smile = new SmilePanel[6];
        for (int i = 0; i<6; i++){
            smile[i] = new SmilePanel(i+1);
            southPanel1.add(smile[i]);
            int finalI = i;
            smile[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseReleased(MouseEvent e) {
                    sendSmile(finalI +1);
                }
            });
        }
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
    private void sendText() {
        try {
            String s = textField.getText();
            if (!s.trim().equals("")) {
                if (out != null) {
                    out.writeUTF(s);
                    out.flush();
                }
                textField.setText("");
            }
        } catch (IOException e) {
            System.out.println("Send msg error");
            textArea.append("Send msg error\n");
        }
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
            textArea.append("Connection Error!\n");
        }

        new Thread(()-> {
            try {
                while (true) {
                    String w = in.readUTF();
                    if (w != null) {
                        textArea.append(w);
                        textArea.append("\n");
                        textArea.setCaretPosition(textArea.getDocument().getLength());
                        if (w.equalsIgnoreCase("end session")) break;
                    }
                    Thread.sleep(100);
                }
            } catch (Exception e) {
            }

        }).start();
    }
    private void sendSmile(int emotion){
        switch (emotion) {
            case SmilePanel.SMILE_HAPPY:
                textField.setText(textField.getText()+" :) ");
                break;
            case SmilePanel.SMILE_HAPPY2:
                textField.setText(textField.getText()+" :D ");
                break;
            case SmilePanel.SMILE_SAD:
                textField.setText(textField.getText()+" :( ");
                break;
            case SmilePanel.SMILE_CRY:
                textField.setText(textField.getText()+" :'( ");
                break;
            case SmilePanel.SMILE_WINK:
                textField.setText(textField.getText()+" ;-) ");
                break;
            case SmilePanel.SMILE_FRUSTRATED:
                textField.setText(textField.getText()+" O.o ");
                break;
        }
    }
}
