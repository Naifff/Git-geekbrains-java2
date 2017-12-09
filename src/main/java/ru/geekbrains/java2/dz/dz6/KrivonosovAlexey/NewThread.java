package ru.geekbrains.java2.dz.dz6.KrivonosovAlexey;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class NewThread extends Thread {
    DataInputStream in;
    DataOutputStream out;
    private String name, usname;
    Socket sock;
    private boolean flag = false;

    public NewThread( String name, Socket sock){
       this.name = name;
       this.sock = sock;
        try {
            in = new DataInputStream(sock.getInputStream());
            out = new DataOutputStream(sock.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run(){
        try {
            System.out.println("Listening for new messages start");
            usname = in.readUTF();
            System.out.println("Name of connected user: " + usname);

            while(!flag) {
                    String input = in.readUTF();
                    if (input.equalsIgnoreCase("end")) {
                        System.out.println("end of listening thread of " + name + ", stopped by closing " + usname);
                        out.writeUTF("end");
                        flag = true;
                       break;
                    }
                System.out.println(usname +": "+input);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public boolean isEnd(){
        return flag;
    }

}
