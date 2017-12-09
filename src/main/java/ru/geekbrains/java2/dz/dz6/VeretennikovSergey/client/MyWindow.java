package ru.geekbrains.java2.dz.dz6.VeretennikovSergey.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MyWindow {
    final String SERVER_ADDRESS = "localhost";
    final int SERVER_PORT = 8189;
    Socket socket;
    Scanner in, console;
    PrintWriter out;

    public MyWindow() {

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
                            System.out.println("Сервер: " + w);
                        }
                    }
                } catch (Exception e) {
                    System.out.println("До свидания!");
                }
            }
        }).start();

        startMessaging();
    }

    public void startMessaging() {
        String message;
        console = new Scanner(System.in);

        while (true) {
            message = console.next();
            out.println(message);
            out.flush();
            if (message.equalsIgnoreCase("END")) {
                try {
                    console.close();
                    out.close();
                    in.close();
                    socket.close();
                    return;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
