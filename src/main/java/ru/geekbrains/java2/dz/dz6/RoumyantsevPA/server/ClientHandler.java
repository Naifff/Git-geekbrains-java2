package ru.geekbrains.java2.dz.dz6.RoumyantsevPA.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler implements Runnable {
    private Socket s;
    private PrintWriter out;
    private Scanner in;
    private Scanner sc = new Scanner(System.in);
    private static int CLIENTS_COUNT = 0;
    private String name;

    public ClientHandler(Socket s) {
        try {
            this.s = s;
            out = new PrintWriter(s.getOutputStream());
            in = new Scanner(s.getInputStream());
            CLIENTS_COUNT++;
            name = "Client #" + CLIENTS_COUNT;
            out.println("Добро пажаловать в секретный хакерский чат\nПожалуйста авторизируйтесь:\nlogin:password");
            out.flush();
        } catch (IOException e) {
        }
    }

    @Override
    public void run() {
        new Thread(() -> {
            Thread outConsole = new Thread(() -> {
                while (true) {
                    if (sc.hasNext()) {
                        String a = sc.nextLine();
                        out.println(a);
                        out.flush();
                    }
                }
            });
            outConsole.start();

            String[] name2 = new String[2];
            String hName = "";
            boolean auth = false;
            while (true) {
                if (in.hasNext()) {
                    String w = in.nextLine();
                    System.out.println(name + ": " + w);
                    if (!auth) {
                        name2 = w.split(":");
                        auth = true;
                        hName = name2[0];
                        out.println("Здравствуйте " + hName);
                        out.flush();
                    } else {
                        if (w.equalsIgnoreCase("END")) {
                            out.println("end session");
                            out.flush();
                            break;
                        }
                        out.println(hName + ">echo: " + w);
                        out.flush();
                    }
                }
            }
            outConsole.stop();
            try {
                System.out.println("Client disconnected");
                s.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
