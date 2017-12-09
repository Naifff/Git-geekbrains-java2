package ru.geekbrains.java2.dz.dz6.beloborodovdenis.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientChat {
    Socket sock;
    Scanner in;
    PrintWriter out;
    final String SERVER_ADDRESS = "localhost";
    final int SERVER_PORT = 8888;

    void startClient() {
        try {
            sock = new Socket(SERVER_ADDRESS, SERVER_PORT);
            in = new Scanner(sock.getInputStream());
            out = new PrintWriter(sock.getOutputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                try {
                    while (true) {
                        if (in.hasNext()) {
                            String w = in.nextLine();
                            if (w.equalsIgnoreCase("end session")) break;
                            System.out.println("Server: " + w);
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

      /*  while(true) {
            if(sendMsg().equalsIgnoreCase("end")) break;
        }
     */
    }

    public String sendMsg() {
        String str;
        Scanner scanString = new Scanner(System.in);
        str = scanString.nextLine();
        System.out.println("Client to server: ");
        out.println(str);

        out.flush();
        return str;

    }
}
