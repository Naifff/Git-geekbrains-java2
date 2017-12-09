package ru.geekbrains.java2.dz.dz6.AnatoliShchukin.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {

    public static void main(String[] args) {
        Socket s = null;
        try {
            ServerSocket server = new ServerSocket(8122);
            System.out.println("Сервер запущен...");
            s = server.accept();
            System.out.println("Клиент присоединился... ");
            new Thread(new ClientHandler(s)).start();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
