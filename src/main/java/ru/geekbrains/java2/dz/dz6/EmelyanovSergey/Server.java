package ru.geekbrains.java2.dz.dz6.EmelyanovSergey;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(6120);

            Socket socket = server.accept();

            Scanner in = new Scanner(socket.getInputStream());
            PrintWriter out = new PrintWriter(socket.getOutputStream());

            new Thread(() -> {
                while (true) {
                    if (in.hasNext()) {
                        System.out.println("\nПолученоСервером:" + in.nextLine());
                        System.out.print(">>");
                    }
                }
            }).start();

            while (true) {
                Scanner scanner = new Scanner(System.in);
                System.out.print(">>");
                if (scanner.hasNext()) {
                    out.println(scanner.nextLine());
                    out.flush();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
