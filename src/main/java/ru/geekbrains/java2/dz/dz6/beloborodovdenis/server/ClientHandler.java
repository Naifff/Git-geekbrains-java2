package ru.geekbrains.java2.dz.dz6.beloborodovdenis.server;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler {
    private Socket s;
    private PrintWriter out;
    private Scanner in;

    public ClientHandler(Socket s) {
        try {
            this.s = s;
            out = new PrintWriter(s.getOutputStream());
            in = new Scanner(s.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startClient() {

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                try {
                    while (true) {
                        if (in.hasNext()) {
                            String w = in.nextLine();
                            if (w.equalsIgnoreCase("end session")) break;
                            System.out.println("client: " + w);
                        }
                    }
                } catch (Exception e) {
                }

            }
        };

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                try {
                    while (true) {
                        sendMsg();
                    }
                } catch (Exception e) {
                }

            }
        };
        thread1.start();
        thread2.start();


        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            System.out.println("client disconnected");
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String sendMsg() {
        String str;
        Scanner scanString = new Scanner(System.in);
        str = scanString.nextLine();
        System.out.print("Server to client: ");
        out.println(str);

        out.flush();
        return str;

    }
}
