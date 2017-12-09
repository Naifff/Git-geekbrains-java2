package ru.geekbrains.java2.dz.dz6.TerehovAlexey.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        final String SERVER_ADDR = "localhost";
        final int SERVER_PORT = 8189;
        Socket sock = null;
        PrintWriter out = null;
        try {
            sock = new Socket(SERVER_ADDR, SERVER_PORT);
            Scanner in = new Scanner(sock.getInputStream());
            out = new PrintWriter(sock.getOutputStream());
            System.out.println("Соединение с сервером установлено!");
            System.out.println("Для завершения наберите END");
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            if (in.hasNext()) {
                                String msg = in.nextLine();
                                System.out.println("Сообщение от сервера: " + msg);
                            }
                        }
                    } catch (Exception e) {
                    }
                }
            }).start();
        } catch (IOException e) {
            System.out.println("Соединение с сервером не установлено!");
            System.exit(0);
        }
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String msg = scanner.nextLine();
            out.println(msg);
            out.flush();
            if (msg.equalsIgnoreCase("END")) {
                try {
                    sock.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    System.exit(0);
                }
            }
        }
    }
}

