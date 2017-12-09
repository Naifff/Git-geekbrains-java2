package ru.geekbrains.java2.dz.dz6.YagudinAlexey.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServ {
    public static void main(String[] args) {
        Socket s;
        ServerSocket server;

        try{
            server = new ServerSocket(8189);
            System.out.println("Server created, waiting for client");
            s = server.accept();
            System.out.println("Client connected");
            new Thread(new RemoteTyping(s, "Client"), "Client").start();
            new Thread(new OwnTyping(s, "Server")).start();

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
