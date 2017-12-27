package ru.geekbrains.java2.dz.dz7.BelomestsevOleg.server;

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
                        sendMsg("Welcome "+ name + "!");
                    } else {
                        sendMsg("Auth Error");
                        owner.remove(this);
                        break;
                    }
                    w = null;
                }
                if (w != null) {
                    if (w.length()>5 && w.substring(0, 2).equals("/w")) {
                        String[] n = w.split(" ");
                        if (n.length > 2) {
                            String s1 = w.substring(w.indexOf(n[1]) + n[1].length());
                            if (owner.sendPrivMsg("Wisp from " + name + ": " + s1, n[1]) == 0) {
                                System.out.println("Priv msg from " + name + " to " + n[1] + ": " + s1);
                            } else {
                                sendMsg("Error: No such user connected!");
                            }
                        }

                    } else {
                        owner.broadcastMsg(name + ": " + w);
                        System.out.println(name + ": " + w);
                        if (w.equalsIgnoreCase("END")) {
                            sendMsg("end session");
                            break;
                        }
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
