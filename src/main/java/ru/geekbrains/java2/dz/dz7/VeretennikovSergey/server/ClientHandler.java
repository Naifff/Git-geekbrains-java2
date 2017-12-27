package ru.geekbrains.java2.dz.dz7.VeretennikovSergey.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;

public class ClientHandler implements Runnable {
    private MyServer owner;
    private Socket s;
    private DataOutputStream out;
    private DataInputStream in;
    private String name;
    private String name2;

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
                String w = in.readUTF();
                if (name.isEmpty()) {
                    String[] n = w.split("\t");
                    String t = SQLHandler.getNickByLoginPassword(n[1], n[2]);
                    if (t != null) {
                        name = t;
                    } else {
                        sendMsg("Auth Error");
                        owner.remove(this);
                        break;
                    }
                    w = null;
                }
                if (w != null) {
                    if(w.contains("/w Nickname1")){
                        System.out.println(name + ": " + w);
                        name2 = "Nickname1";
                        String[] wn = w.split("/w Nickname1");
                        w = toString(wn);
                        owner.broadcastOneMsg(name2, name + ": " + w);
                    } else
                        if(w.contains("/w Nickname2")) {
                            System.out.println(name + ": " + w);
                            name2 = "Nickname2";
                            String[] wn = w.split("/w Nickname2");
                            w = toString(wn);
                            owner.broadcastOneMsg(name2, name + ": " + w);
                        } else
                            if(w.contains("/w Nickname3")) {
                                System.out.println(name + ": " + w);
                                name2 = "Nickname3";
                                String[] wn = w.split("/w Nickname3");
                                w = toString(wn);
                                owner.broadcastOneMsg(name2, name + ": " + w);
                            } else {
                                owner.broadcastMsg(name + ": " + w);
                                System.out.println(name + ": " + w);
                                if (w.equalsIgnoreCase("END")) break;
                            }
                }
                Thread.sleep(100);
            }
        } catch (IOException e) {
            System.out.println("Output Error");
        } catch (InterruptedException e) {
            System.out.println("Thread sleep error");
        }
        try {
            System.out.println("Client disconnected");
            if (!name.equals("")) owner.remove(this);
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String toString(String[] a) {
        if (a == null)
            return "null";

        int iMax = a.length - 1;
        if (iMax == -1)
            return "";

        StringBuilder b = new StringBuilder();
        //b.append('[');
        for (int i = 0; ; i++) {
            b.append(String.valueOf(a[i]));
            if (i == iMax)
                return b.toString();
            //b.append("");
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
