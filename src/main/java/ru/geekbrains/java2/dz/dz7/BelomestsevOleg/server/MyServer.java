package ru.geekbrains.java2.dz.dz7.BelomestsevOleg.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

// Можно подключаться под одним именем несколько раз, и отправлять сообщения самому себе!
public class MyServer {

    private ArrayList<ClientHandler> clients = new ArrayList<ClientHandler>();
    public static void main(String[] args) {
        MyServer w = new MyServer();
    }

    public MyServer() {
        ServerSocket server = null;
        Socket socket = null;
        try {
            server = new ServerSocket(8686);
            System.out.println("Server created. Waiting for client...");
            while (true) {
                socket = server.accept();
                System.out.println("Client connected");
                ClientHandler h = new ClientHandler(socket, this);
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
    public int sendPrivMsg(String msg, String toUser){
        int r = -1;
        for (ClientHandler o : clients){
            if (o.getName().equalsIgnoreCase(toUser)){
                o.sendMsg(msg);
                r = 0;
            }
        }
//        clients.stream()
//                .filter(o -> o.getName().equalsIgnoreCase(toUser))
//                .findFirst().get().sendMsg(msg);

        return r;
    }
}
