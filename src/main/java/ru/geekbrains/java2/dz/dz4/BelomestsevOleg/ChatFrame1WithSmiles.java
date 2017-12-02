package ru.geekbrains.java2.dz.dz4.BelomestsevOleg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChatFrame1WithSmiles extends JFrame {     // Версия со смайликами :). jpg файлы со смайлами находятса в папке Slimes
    private JTextArea textArea;
    private JTextField textField;
    public static void main(String[] arg){
        ChatFrame1WithSmiles chatFrame = new ChatFrame1WithSmiles();
    }
    public ChatFrame1WithSmiles(){
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

        textField = new JTextField();
        JPanel southPanel2 = new JPanel(new BorderLayout());
        southPanel2.add(textField);
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendText();
            }
        });

        JPanel southPanel1 = new JPanel();
        southPanel1.setLayout(new BoxLayout(southPanel1, BoxLayout.X_AXIS));

        JPanel panel0 = new JPanel(new BorderLayout());
        add(BorderLayout.SOUTH, panel0);
        panel0.add(BorderLayout.WEST,southPanel1);
        panel0.add(BorderLayout.SOUTH,southPanel2);

        JButton buttonSend = new JButton("Отправить");
        southPanel2.add(BorderLayout.EAST,buttonSend);
        buttonSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendText();
            }
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

        setVisible(true);
    }
    private void sendText(){
        if (!textField.getText().equals("")) {
            if (!textArea.getText().equals("")) textArea.append("\n");
            textArea.append(textField.getText());
            textField.setText("");
        }
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
