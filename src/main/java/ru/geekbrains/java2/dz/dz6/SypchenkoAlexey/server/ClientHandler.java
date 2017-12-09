package ru.geekbrains.java2.dz.dz6.SypchenkoAlexey.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler implements Runnable {
    private Socket s;
    private PrintWriter out;
    private Scanner in;
    private static int CLIENTS_COUNT = 0;
    private String name;

    public ClientHandler(Socket s) {
        try {
            this.s = s;
            out = new PrintWriter(s.getOutputStream());
            in = new Scanner(s.getInputStream());
            Scanner serverConsole = new Scanner(System.in);

            Thread serverConsoleHandler = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            if (serverConsole.hasNext()) {
                                String w = serverConsole.nextLine();
                                //System.out.println("Server:" + w);
                                out.println("Server: " + w);
                                out.flush();
                            }
                            //System.out.println(Thread.currentThread().getName());
                        }
                    } catch (Exception e) {
                        System.out.println("WTF");
                    }
                }
            });
            serverConsoleHandler.setDaemon(true); // чтобы этот поток завершился после завершения main-потока
            serverConsoleHandler.start();

            CLIENTS_COUNT++;
            name = "Client #" + CLIENTS_COUNT;
            System.out.println("CLIENTS_COUNT = "+ CLIENTS_COUNT);
        } catch (IOException e) {
        }
    }

    @Override
    public void run() {
        while (true) {
            if(in.hasNext()) {
                String w = in.nextLine();
                System.out.println(name + ": " + w);
                out.println("echo: " + w);
                out.flush();
                if(w.equalsIgnoreCase("END")) break;
            }


        }
        try {
            System.out.println("Client disconnected");
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
