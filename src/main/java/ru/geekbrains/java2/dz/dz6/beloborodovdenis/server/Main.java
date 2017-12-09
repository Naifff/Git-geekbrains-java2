package ru.geekbrains.java2.dz.dz6.beloborodovdenis.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int SERVER_PORT = 8888;
        Socket s = null;
        try {
            ServerSocket server = new ServerSocket(SERVER_PORT);
            System.out.println("Server start");
            s = server.accept();
            System.out.println("Client connect");
            ClientHandler ch = new ClientHandler(s);
            ch.startClient();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                s.close();
                System.out.println("Server close");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}
