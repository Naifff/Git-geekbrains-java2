package ru.geekbrains.java2.dz.dz7.SypchenkoAlexey.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private MyServer owner;
    private Socket s;
    private DataOutputStream out;
    private DataInputStream in;
    private String name;
    private String[] n;
    private String privateNick;

    public ClientHandler(Socket s, MyServer owner) {
        try {
            this.s = s;
            this.owner = owner;
            out = new DataOutputStream(s.getOutputStream());
            in = new DataInputStream(s.getInputStream());
            name = "";
        } catch (IOException e) {

        }
    }


    @Override
    public void run() {
        try {
            while (true) {
                String w = in.readUTF(); // читаем данные, приходящие на сервер
                if (name.isEmpty()) { // если клиент неавторизован = имя пустое
                    n = w.split("\t");
                    //String t = SQLHandler.getNickByLoginPassword(n[1], n[2]);
                    String t = n[1];
                    if (t != null) name = t;
                    else {
                        sendMsg("Auth error");
                        owner.remove(this);
                        break;
                    }
                    w = null;
                }
                if (w != null) {
                    n = w.split(" ");
                    if ("/w".equals(n[0])) {
                        int l=0;
                        privateNick = n[1];
                        System.out.println(name + ": " + w);
                        w = "Private message from " + name + ": " + w.substring(n[0].length()+n[1].length()+2);
                        owner.privateMsg(w, this, privateNick);
                    } else {
                        owner.broadcastMsg(name + ": " + w);
                        System.out.println(name + ": " + w);
                        if (w.equalsIgnoreCase("END")) break;
                    }
                }
                Thread.sleep(500);
            }
        } catch (IOException e) {
            System.out.println("Output Error");
        } catch (InterruptedException e) {
            System.out.println("Thread sleep error");
        }
        try {
            System.out.println("Client disconnected");
            owner.broadcastMsg("Client " + name + " disconnected");
            if (!name.equals("")) owner.remove(this);
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMsg(String msg) {
        try {
            out.writeUTF(msg);
            out.flush();
        } catch (IOException e) {

        }
    }

    public String getName() {
        return name;
    }
}
