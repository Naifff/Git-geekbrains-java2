package ru.geekbrains.java2.dz.dz6.RoumyantsevPA.cui;


import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MyConsole {


    final String SERVER_ADDR = "localhost";
    final int SERVER_PORT = 8189;
    Socket sock;
    Scanner in;
    Scanner sc = new Scanner(System.in);
    PrintWriter out;
    boolean end = false;

    public MyConsole() {
        try {
            sock = new Socket(SERVER_ADDR, SERVER_PORT);
            in = new Scanner(sock.getInputStream());
            out = new PrintWriter(sock.getOutputStream());
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Сервер не запущен");
            e.printStackTrace();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        if (in.hasNext()) {
                            String w = in.nextLine();
                            if (w.equalsIgnoreCase("end session")) {
                                end = true;
                                System.out.println(w);
                                break;
                            }
                            System.out.println(w);
                        }
                    }
                } catch (Exception e) {
                }

                try {

                    out.close();
                    in.close();
                    sock.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        while (!end) {
            String a = sc.next();
            out.println(a);
            out.flush();
            if (end) {
                break;
            }
        }
    }
}



