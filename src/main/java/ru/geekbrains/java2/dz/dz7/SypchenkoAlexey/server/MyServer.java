package ru.geekbrains.java2.dz.dz7.SypchenkoAlexey.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MyServer {
    private final static int PORT = 8189;
    private ArrayList<ClientHandler> clients = new ArrayList<ClientHandler>(); // список клиентов

    public MyServer() {
        ServerSocket server = null;
        Socket socket = null;
        try {
            server = new ServerSocket(PORT);
            System.out.println("Server created. Waiting for client...");
            while (true) {
                socket = server.accept();
                System.out.println("Client connected");
                ClientHandler h = new ClientHandler(socket, this); //передаем ссылку на объект MyServer
                clients.add(h);
                new Thread(h).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                server.close();
                System.out.println("Server closed");
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void remove(ClientHandler o) {
        clients.remove(o);
    }

    public void broadcastMsg(String msg) {
        for (ClientHandler o : clients) {
            o.sendMsg(msg);
        }
    }

    public void privateMsg(String msg, ClientHandler o, String privateNick) {
        for (ClientHandler b : clients) {
            if (b.getName().equals(privateNick)) {
                b.sendMsg(msg);
                break;
            }
        }
    }
}