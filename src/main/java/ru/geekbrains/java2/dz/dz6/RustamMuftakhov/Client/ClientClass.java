package ru.geekbrains.java2.dz.dz6.RustamMuftakhov.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientClass {

    final String SERVER_ADDRESS = "localhost";
    final int SERVER_PORT = 8189;
    Socket socket;
    Scanner in, message;
    PrintWriter out;

    public ClientClass() {

        try {
            socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            in = new Scanner(socket.getInputStream());
            out = new PrintWriter(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        if (in.hasNext()) {
                            String w = in.nextLine();
                            if (w.equalsIgnoreCase("end session")) break;
                            System.out.println("server:" + w);
                        }
                    }
                } catch (Exception e) {
                    System.out.println("End of session");
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
                    socket.close();
                    return;
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        }

    }
}
