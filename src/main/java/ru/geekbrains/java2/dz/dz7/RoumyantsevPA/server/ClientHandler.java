package ru.geekbrains.java2.dz.dz7.RoumyantsevPA.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;

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
            out.writeUTF("Здравствуйте, для авторизации наберите:auth login password\nдля помощи help");
            out.flush();
            while (true) {
                String w = in.readUTF();
                if (name.isEmpty()) {
                    String[] n = w.split("\t");
                    if ("auth".equalsIgnoreCase(n[0])) {
                        String t = authLoginPass(n[1], n[2]);
                        if (t != null) {
                            out.writeUTF("Авторизация успешная");
                            out.flush();
                            name = t;
                            owner.setUserId(t,this);
                        } else {
                            sendMsg("Auth Error");
                            owner.remove(this);
                            owner.removeId(name);
                            break;
                        }
                        w = null;
                    }
                }
                if ("list".equalsIgnoreCase(w)) {
                    out.writeUTF(owner.list());
                    out.flush();
                    w = null;
                }

                if (w != null) {
                    if(w.indexOf(" ")==0){
                        String login2="";
                        String msg="";
                        System.arraycopy(w,1,login2,0,w.indexOf(" "));
                        System.arraycopy(w,w.indexOf(" "),msg,0,w.length());
                        owner.sendPM(this.name,login2,msg);
                        w = null;
                    /*
                    System.arraycopy(массив-источник, откуда начинаем брать данные из массива-источника,
массив-назначение, откуда начинаем записывать данные в массив-назначение, сколько ячеек
копируем)
                     */
                        // w.indexOf(" ")

                    }else{

                    owner.broadcastMsg(name + ": " + w);
                    System.out.println(name + ": " + w);
                    if (w.equalsIgnoreCase("END")) break;}
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
            if (!name.equals("")) {
                owner.remove(this);
                owner.removeId(name);
            }
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

    public String authLoginPass(String login, String password) {
        if (owner.isLogin(login)) {
            if (owner.getAuth(login) == password.hashCode()) {
                owner.setUserId(login,this);
                return login;
            } else {
                return null;
            }
        }
        owner.setAuth(login, password);
        owner.setUserId(login,this);
        return login;

    }

}
