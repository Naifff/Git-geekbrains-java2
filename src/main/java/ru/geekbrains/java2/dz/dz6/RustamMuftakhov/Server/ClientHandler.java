package ru.geekbrains.java2.dz.dz6.RustamMuftakhov.Server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler {
    private Socket s;
    private PrintWriter out;
    private Scanner in, message;
    private String name;

    public ClientHandler (Socket s) {
        try{
            this.s = s;
            out = new PrintWriter(s.getOutputStream());
            in = new Scanner(s.getInputStream());
            name = "Client #1";
        } catch (IOException e){
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        if (in.hasNext()) {
                            String w = in.nextLine();
                            if (w.equalsIgnoreCase("end session")) break;
                            System.out.println("client:" + w);
                        }
                    }
                } catch (Exception e) {
                }
            }
        }).start();

        Messaging();
    }

    public void Messaging () {
        String text;
        message = new Scanner(System.in);

        while (true){
            text = message.next();
            out.println(text);
            out.flush();
            if (text.equalsIgnoreCase("end session")){
                try{
                    message.close();
                    out.close();
                    in.close();
                    s.close();
                    return;
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        }

    }


}
