package ru.geekbrains.java2.dz.dz7.lobysheva.server;

/*
 * Created by Oxana Lobysheva on 09/12/2017.
 */

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler implements Runnable {

    private ChatServer owner;
    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;
    private String name;
    private String receipient;

    public ClientHandler(Socket socket, ChatServer owner) {
        try {
            this.socket = socket;
            this.owner = owner;
            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(socket.getInputStream());
            name = "";
        } catch (IOException e) {
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                String stream = in.readUTF().trim();

                if (name.isEmpty()) {
                    String[] n = stream.split("\t");
                    String nickname = NicknameHandler.getNickByLoginPassword(n[1], n[2]);
                    if (nickname != null) {
                        name = nickname;
                        owner.broadcastMsg(name, "[connected]", "public");
                    } else {
                        sendMsg(n[1] + ": [error] invalid login or password");
                        owner.remove(this);
                        break;
                    }
                    stream = null;
                }

                if (stream != null) {
                    receipient = "";
                    String text = stream;

                    String[] streamMsg = stream.split(" ");

                    if (streamMsg[0].equalsIgnoreCase("/w") && streamMsg.length > 1 ){
                        if (owner.isRecipientConnected(streamMsg[1])) {
                            receipient = streamMsg[1];
                            text = stream.replace(streamMsg[0], "[private]");
                        } else {
                            text = "[error] " + streamMsg[1] + " is not connected";
                            receipient = name;
                        }
                    } else {
                        receipient = "public";
                        if (stream.equalsIgnoreCase("end session")) {
                            text = "[disconnected]";
                        }
                    }

                    owner.broadcastMsg(name, text, receipient);
                    if (stream.equalsIgnoreCase("end session")) break;
                }
                Thread.sleep(100);
            }
        } catch (IOException e) {
            System.out.println("SYSTEM: output Error");
        } catch (InterruptedException e) {
            System.out.println("SYSTEM: thread sleep error");
        }

        try {
            System.out.println("SYSTEM: " + name + " disconnected");
            if (!name.isEmpty()) {
                owner.remove(this);
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void sendMsg(String msg) {
        try {
            out.writeUTF(msg);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getName(){
        return name;
    }
}
