package ru.geekbrains.java2.dz.dz6.TerehovAlexey.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler implements Runnable {
    private Socket socket;
    private PrintWriter out;
    private Scanner in;

    public ClientHandler(Socket socket) {
        try {
            this.socket = socket;
            out = new PrintWriter(socket.getOutputStream());
            in = new Scanner(socket.getInputStream());
        } catch (IOException e) {
        }
    }

    @Override
    public void run() {
        while (true) {
            if (in.hasNext()) {
                String w = in.nextLine();
                System.out.println("Сообщение от клиента: " + w);
                if (w.equalsIgnoreCase("END")) break;
            }
        }
        try {
            System.out.println("Клиент отключился");
            socket.close();
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
