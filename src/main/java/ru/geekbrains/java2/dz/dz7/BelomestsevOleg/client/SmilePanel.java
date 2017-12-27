package ru.geekbrains.java2.dz.dz7.BelomestsevOleg.client;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SmilePanel extends JPanel {
    public static final int SMILE_HAPPY = 1;        // :)
    public static final int SMILE_HAPPY2 = 2;       //:D
    public static final int SMILE_SAD = 3;          //:(
    public static final int SMILE_CRY = 4;          //:'(
    public static final int SMILE_WINK = 5;         //;-)
    public static final int SMILE_FRUSTRATED = 6;   //O.o
    private BufferedImage image;
    private String path;

    public SmilePanel(int emotion) {
        setPreferredSize(new Dimension(33, 33));
        path = ".\\src\\main\\java\\ru\\geekbrains\\java2\\dz\\dz7\\BelomestsevOleg\\Smiles\\";
        switch (emotion){
            case 1: path = path + "Happy1.jpg";
                break;
            case 2: path = path + "Happy2.jpg";
                break;
            case 3: path = path + "Sad3.jpg";
                break;
            case 4: path = path + "Cry4.jpg";
                break;
            case 5: path = path + "Wink5.jpg";
                break;
            case 6: path = path + "Frustrated6.jpg";
                break;
        }
            try {
                image = ImageIO.read(new File(path));
            } catch (IOException ex) {
                ex.getStackTrace();
            }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
}
