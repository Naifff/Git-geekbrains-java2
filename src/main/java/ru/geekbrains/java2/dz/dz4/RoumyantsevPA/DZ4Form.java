package ru.geekbrains.java2.dz.dz4.RoumyantsevPA;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DZ4Form extends JFrame {
    private JPanel panelka;
    private JTextField textField1;
    private JButton button1;
    private JEditorPane editorPane1;
    private JPanel panelka2;
    private JScrollPane scrol1;
    private JList list1;

    public DZ4Form() {
        Image img = Toolkit.getDefaultToolkit().getImage(".\\src\\main\\java\\ru\\geekbrains\\java2\\dz\\dz4\\RoumyantsevPA\\java.png");
        setIconImage(img);
        setSize(800, 600);
        setTitle("M a t r i x   has   U. . .");
        setContentPane(panelka);
        setVisible(true);
        textField1.setBorder(null);
        button1.setBorder(null);
        scrol1.setHorizontalScrollBarPolicy(31);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        String text1 = "Wake up, Neo. . .                     ";
        String text2 = "The Matrix has you. . .               ";
        String text3 = "Follow the white rabbit.              ";
        String text4 = "Knock, Knock, Neo.                    ";
        String text = text1 + text2 + text3 + text4;
        //        SimpleDateFormat formatForDateNow = new SimpleDateFormat("E yyyy.MM.dd 'и время' hh:mm:ss a zzz");
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("(k:mm:ss dd/MM/yyyy)");
        String runText = "unknown " + formatForDateNow.format(new Date()) + "\n";
        for (int i = 0; i < text.length(); i++) {
            if (i == text1.length() ||
                    i == text2.length() + text1.length() ||
                    i == text3.length() + text2.length() + text1.length() ||
                    i == text4.length() + text3.length() + text2.length() + text1.length()) {
                runText += "\nunknown " + formatForDateNow.format(new Date()) + "\n";
            }
            runText += text.charAt(i);
            editorPane1.setText(runText);
            try {
                Thread.sleep(130);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //editorPane1.setText("");


        button1.addActionListener(
                e -> {
                    editorPane1.setText(editorPane1.getText() + "\nYou " + formatForDateNow.format(new Date()) + "\n" + textField1.getText());
                    textField1.setText("");
                });

        textField1.addActionListener(
                e -> {
                    editorPane1.setText(editorPane1.getText() + "\nYou " + formatForDateNow.format(new Date()) + "\n" + textField1.getText());
                    textField1.setText("");
                }
        );
    }

    public static void main(String[] args) {
        new DZ4Form();
    }
}

