package ru.geekbrains.java2.lesson4.p2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import static com.sun.glass.ui.Cursor.setVisible;

/**
 * Created by i on 27.11.2017.
 */
public class Form2 extends JFrame{
    private JButton Кнопка;
    private JTable table1;
    private JTabbedPane tabbedPane1;
    private JPanel ttttt;


    public Form2() {
        setSize(800,600);
        setContentPane(ttttt);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        Кнопка.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        new Form2();
    }
}
