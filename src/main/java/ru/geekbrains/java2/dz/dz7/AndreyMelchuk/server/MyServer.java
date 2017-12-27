package ru.geekbrains.java2.dz.dz7.AndreyMelchuk.server;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;


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
        String exploded[] = msg.split(" ", 4);
        if (exploded[1].equals("/w")) {
            //System.out.println(Arrays.toString(exploded));
            for (ClientHandler o : clients){
                if (exploded[0].equals(o.getName()+":"))
                    o.sendMsg(msg); // Echo to sender
                else if (o.getName().equals(exploded[2]))
                        o.sendMsg(exploded[0] + " " + exploded[3]);// And To Recipient
            }
        }
        else
            for (ClientHandler o : clients) o.sendMsg(msg);
    }
}
