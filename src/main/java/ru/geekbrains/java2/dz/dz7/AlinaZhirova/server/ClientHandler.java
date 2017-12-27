package ru.geekbrains.java2.dz.dz7.AlinaZhirova.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {
    private MyServer owner;
    private Socket curSocket;
    private DataInputStream in;
    private DataOutputStream out;
    private String name;


    public String getName() {
        return name;
    }


    public ClientHandler(MyServer owner, final Socket curSocket) {
        try {
            this.owner = owner;
            this.curSocket = curSocket;
            this.in = new DataInputStream(curSocket.getInputStream());
            this.out = new DataOutputStream(curSocket.getOutputStream());
            this.name = "";
            new Thread(() -> {
                try {
                    while (true) { // the authorization cycle
                        String messageFromClient = in.readUTF();
                        if (messageFromClient.startsWith("/auth")) {
                            String[] parts = messageFromClient.split("\\s");
                            String nick = owner.getAuthService().getNickByLoginPass(parts[1], parts[2]);
                            if (nick != null) {
                                if (!owner.isNickBusy(nick)) {
                                    sendMsg("/authok " + nick);
                                    name = nick;
                                    owner.broadcastMsg(name + " came into the chat");
                                    owner.subscribe(this);
                                    break;
                                }
                                else {
                                    sendMsg("Account is already in use!");
                                }
                            }
                            else {
                                sendMsg("Incorrect username/password!");
                            }
                        }
                        Thread.sleep(100);
                    }
                    while (true) { // the cycle of receiving messages
                        String messageFromClient = in.readUTF();
                        System.out.println("from " + name + ": " + messageFromClient);
                        if (messageFromClient.equals("/end")) {
                            break;
                        }
                        else if (messageFromClient.startsWith("/w")) {
                            String[] parts = messageFromClient.split("\\s");
                            System.out.println("parts[1]" + parts[1]);
                            ClientHandler user = getClientByNick(parts[1]);
                            if (user != null) {
                                user.sendMsg(parts[2]);
                            }
                            else {
                                sendMsg("There is not user with such nickname!");
                            }
                        }
                        else {
                            owner.broadcastMsg(name + ": " + messageFromClient);
                        }
                        Thread.sleep(100);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    owner.unsubscribe(this);
                    owner.broadcastMsg(name + " got out of the chat");
                    try {
                        curSocket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        } catch (IOException e) {
            throw new RuntimeException("Problems during client handler creation!");
        }
    }


    public void sendMsg(String msg) {
        try {
            out.writeUTF(msg);
            out.flush();
        } catch (IOException e) {
        }
    }


    public ClientHandler getClientByNick(String nick) {
        for (ClientHandler o: owner.getAllClients()) {
            if (o.name.equals(nick)) {
                return o;
            }
        }
        return null;
    }


}
