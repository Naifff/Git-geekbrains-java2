package ru.geekbrains.java2.dz.dz6.FedulovMS;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    private static final String SERVER_ADDR = "localhost";
    private static final int SERVER_PORT = 8189;

    public static void main(String[] args) {
        switch(askUser()){
            case 1:
                runAsServer();
                break;
            case 2:
                runAsClient();
                break;
        }
    }

    public static int askUser(){
        Scanner sc = new Scanner(System.in);
        int res;
        System.out.println("Запустить чат в режиме сервера или в режиме клиента?");
        System.out.println("1. Запустить сервер");
        System.out.println("2. Запустить клиент");
        System.out.print("Введите номер опции: ");
        do{
            res = Integer.parseInt(sc.nextLine());
            if (res < 1 || res > 2) {
                System.out.print("Введите номер опции: ");
            }
        } while (res < 1 || res > 2);

        return res;
    }

    public static void runAsServer(){
        ServerSocket serv = null;
        Socket sock;

        try {
            serv = new ServerSocket(SERVER_PORT);
            System.out.println("Сервер запущен, ожидание подключения...");
            sock = serv.accept();

            (new P2PChatThread(sock)).start();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Этот код выполнится сразу после создания потока-обработчика клиентского подключения
            // и закроет серверный сокет. С одной стороны - баг, но с точки зрения условия задачи об
            // ограничении количества клиентов - фича. Созданный сокет продолжает работать,
            // уже созданные соединения сохраняются после закрытия серверного сокета.
            //
            // Поэтому оставлю так.
            try {
                serv.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void runAsClient(){
        try {
            Socket sock = new Socket(SERVER_ADDR, SERVER_PORT);

            (new P2PChatThread(sock)).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
