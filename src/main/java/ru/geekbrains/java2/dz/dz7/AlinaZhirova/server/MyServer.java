package ru.geekbrains.java2.dz.dz7.AlinaZhirova.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MyServer {

    private ServerSocket curServer = null;
    private Socket curSocket = null;
    private ArrayList<ClientHandler> clients;
    private AuthService curAuthService;
    private final int PORT = 8189;


    public AuthService getAuthService() {
        return curAuthService;
    }

    public ArrayList<ClientHandler> getAllClients() {
        return clients;
    }


    public MyServer() {
        try {
            curServer = new ServerSocket(PORT);
            System.out.println("Server is created. Waiting for clients...");
            curAuthService = new BaseAuthService();
            curAuthService.start();
            clients = new ArrayList<ClientHandler>();
            while (true) {
                curSocket = curServer.accept();
                new ClientHandler(this, curSocket);
                Thread.sleep(100);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                curServer.close();
                System.out.println("Server is closed!");
                curSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            curAuthService.stop();
        }
    }


    public synchronized boolean isNickBusy(String nick) {
        for (ClientHandler o : clients) {
            if (o.getName().equals(nick)) {
                return true;
            }
        }
        return false;
    }


    public synchronized void broadcastMsg(String msg) {
        for (ClientHandler o : clients) {
            o.sendMsg(msg);
        }
    }


    public synchronized void subscribe(ClientHandler curClient) {
        clients.add(curClient);
    }

    public synchronized void unsubscribe(ClientHandler curClient) {
        clients.remove(curClient);
    }


}
