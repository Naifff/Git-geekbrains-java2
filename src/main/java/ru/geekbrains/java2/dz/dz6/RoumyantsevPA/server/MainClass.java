package ru.geekbrains.java2.dz.dz6.RoumyantsevPA.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MainClass {
    public static void main(String[] args) {
        Socket s = null;
        try (ServerSocket server = new ServerSocket(8189)) {
//            server.getInetAddress();
            System.out.println("Server created. Waiting for client...");
            s = server.accept();
            System.out.println("Client connected");
            new Thread(new ClientHandler(s)).run();

        } catch (IOException e) {
            e.printStackTrace();
        }
//        finally {
//            try {
//                s.close();
//                System.out.println("Server closed");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }
}
