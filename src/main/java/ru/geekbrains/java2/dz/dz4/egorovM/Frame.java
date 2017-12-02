import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame{
    public Frame(){
        setTitle("First Chat");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(500,500,400,300);
        setResizable(false);
        setSize(500,300);
        GridLayout grl=new GridLayout(1,2);


        JFormattedTextField jftf=new JFormattedTextField();
        jftf.setSize(400,300);


        JLabel jlb=new JLabel("Your message:");
        jlb.setLayout(grl);

        JTextField jtf=new JTextField(100);
        jtf.setBounds(10,40,400,50);
        jtf.setLayout(grl);

        JButton sentOperation=new JButton();
        sentOperation.setText("Sent message");
        sentOperation.setSize(150,30 );
        sentOperation.setLayout(grl);
        sentOperation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String mess=jtf.getText();
                jftf.setText("Your message:"+mess);
            }
        });

        add(jlb);
        add(jtf);
        add(sentOperation);
        add(jftf);
        setVisible(true);
//Окно приложения


    }
}