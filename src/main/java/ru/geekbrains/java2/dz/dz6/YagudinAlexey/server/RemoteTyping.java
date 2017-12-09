package ru.geekbrains.java2.dz.dz6.YagudinAlexey.server;

import java.io.IOException;
import java.net.Socket;

public class RemoteTyping extends Typing implements Runnable {

    public RemoteTyping(Socket s, String name){
        super(s, name);
    }

    @Override
    public void run() {

        while (true) {
            if(in.hasNext()) {
                String w = in.nextLine();
                System.out.println(name + ": " + w);
                if(w.equalsIgnoreCase("END")){
                    break;
                }
            }
        }
        try {
            System.out.println("Client disconnected");
            pw.close();
            in.close();
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

