package ru.geekbrains.java2.dz.dz7.TerehovAlexey.server;

import ru.geekbrains.java2.dz.dz6.BelomestsevOleg.client.Client;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class MyServer {

    private ArrayList<ClientHandler> clients = new ArrayList<ClientHandler>();

    public MyServer() {
        ServerSocket server = null;
        Socket socket = null;
        try {
            server = new ServerSocket(8189);
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

    //отсылка приватного сообщения и возврат себе результата
    public void privateMsg(String msg, String addresee, ClientHandler owner){
        for (ClientHandler o : clients) {
            if (addresee.equals(o.getName())){
                o.sendMsg(msg);
            }
            if (owner.getName().equals(o.getName())){
                o.sendMsg("[В приват "+addresee+"] "+msg);
            }
        }
    }
}
