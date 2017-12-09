package ru.geekbrains.java2.dz.dz6.YagudinAlexey.server;

import java.io.IOException;
import java.net.Socket;

public class OwnTyping extends Typing implements Runnable {

    public OwnTyping(Socket s, String name){
        super(s, name);
    }

    @Override
    public void run() {
        while (true) {
            if(sc.hasNext()) {
                String w = sc.nextLine();
                System.out.println(name + ": " + w);
                pw.println(w);
                pw.flush();
                if(w.equalsIgnoreCase("END"))
                    break;
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
