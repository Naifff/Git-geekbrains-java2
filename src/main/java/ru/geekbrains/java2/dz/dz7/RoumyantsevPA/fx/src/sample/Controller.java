package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    SimpleDateFormat formatForDateNow = new SimpleDateFormat("(k:mm:ss dd/MM/yyyy)");

    public int id;
    public Socket socket;
    public DataInputStream in;
    public DataOutputStream out;
    public String nick="";

    @FXML
    TextField textField;
    @FXML
    TextArea chatWindow;

    public void sendMsg() {
        try {
            out.writeUTF(textField.getText());
            out.flush();
            textField.clear();
            textField.requestFocus();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        chatWindow.setWrapText(true);
        chatWindow.appendText("Здравствуйте, для Помощи наберите: help");
        chatWindow.appendText("\n");
//        chatWindow.appendText("$ " + nick + " присоединился к каналу");
//        chatWindow.appendText("\n");
        Thread t = new Thread(new Runnable() {
            public void run() {
                try {
                    while (true) {
                        String str = in.readUTF();
                       if("end session".equals(str)){
                           chatWindow.appendText(str);
                           break;
                       }
                        chatWindow.appendText(str);
                        chatWindow.appendText("\n");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        t.setDaemon(true);
        t.start();
          }
}


