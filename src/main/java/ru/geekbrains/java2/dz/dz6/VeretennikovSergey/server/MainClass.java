package ru.geekbrains.java2.dz.dz6.VeretennikovSergey.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MainClass {
    public static void main(String[] args) {
        Socket s = null;
        try (ServerSocket server = new ServerSocket(8189)) {
//            server.getInetAddress();
            System.out.println("Server created. Waiting for client...");
            while(true) {
                s = server.accept();
                System.out.println("Client connected");
                new Thread(new ClientHandler(s)).start();
                ClientHandler st = new ClientHandler(s);
                st.startMessaging();

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                s.close();
                System.out.println("Server closed");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
