package ru.geekbrains.java2.dz.dz7.lobysheva.server;

/*
 * Created by Oxana Lobysheva on 09/12/2017.
 */

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServer {

    private ArrayList<ClientHandler> clients = new ArrayList<>();

    public ChatServer() {
        ServerSocket server = null;
        Socket socket = null;
        try {
            server = new ServerSocket(8189);
            System.out.println("SYSTEM: server waiting for client...");
            while (true) {
                socket = server.accept();
                System.out.println("SYSTEM: client connected");
                ClientHandler h = new ClientHandler(socket, this);
                clients.add(h);
                new Thread(h).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                server.close();
                System.out.println("SYSTEM: server closed");
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void remove(ClientHandler o) {
        clients.remove(o);
    }

    public void broadcastMsg(String sender, String text, String recipient) {
        for (ClientHandler o : clients) {
            if (o.getName().equalsIgnoreCase(recipient) || recipient.equals("public") || o.getName().equalsIgnoreCase(sender)) {
                o.sendMsg(sender + ": " + text);
                System.out.println("SYSTEM: from " + sender + " to " + o.getName() + " : " + text);
            }
        }
    }

    public boolean isRecipientConnected(String recipient){
        for (ClientHandler o : clients) {
            if (o.getName().equalsIgnoreCase(recipient)) {
                return true;
            }

        } return false;
    }
}
