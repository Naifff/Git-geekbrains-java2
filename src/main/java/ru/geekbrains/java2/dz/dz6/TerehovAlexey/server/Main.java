package ru.geekbrains.java2.dz.dz6.TerehovAlexey.server;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Socket socket = null;
        PrintWriter out = null;

        try (ServerSocket server = new ServerSocket(8189)) {
            System.out.println("Сервер запущен. Ожидается подключение.");
            socket = server.accept();
            System.out.println("Клиент подключен с адреса " + socket.getRemoteSocketAddress());
            out = new PrintWriter(socket.getOutputStream());
            new Thread(new ClientHandler(socket)).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String msg = scanner.nextLine();
            out.println(msg);
            out.flush();
        }
    }
}
