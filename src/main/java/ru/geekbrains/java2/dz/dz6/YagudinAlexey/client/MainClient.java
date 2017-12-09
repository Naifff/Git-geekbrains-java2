package ru.geekbrains.java2.dz.dz6.YagudinAlexey.client;

import ru.geekbrains.java2.dz.dz6.YagudinAlexey.server.RemoteTyping;
import ru.geekbrains.java2.dz.dz6.YagudinAlexey.server.OwnTyping;

import java.io.IOException;
import java.net.Socket;

public class MainClient {

    private final String SERVER_ADDR = "localhost";
    private final int SERVER_PORT = 8189;
    private Socket sock;


    public static void main(String[] args) {
        new MainClient();
    }

    public MainClient(){
        try{
           sock =  new Socket(SERVER_ADDR, SERVER_PORT);
           Thread tr = new Thread(new RemoteTyping(sock, "server"));
           Thread to = new Thread(new OwnTyping(sock, "client"));
           tr.start();
           to.start();
           tr.join();
           to.join();
        }catch (IOException | InterruptedException e){
            e.printStackTrace();
        }


        try {
            sock.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
