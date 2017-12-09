package ru.geekbrains.java2.dz.dz6.AnatoliShchukin.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MainClient {
    static Socket socket;
    static final String SERVER_ADDR = "localhost";
    static final int SERVER_PORT = 8122;
    static Scanner in;
    static PrintWriter out;
    static String text = " ";

    public static void main(String[] args) {



        try {


            socket = new Socket(SERVER_ADDR,SERVER_PORT);
            in = new Scanner(socket.getInputStream());
            out = new PrintWriter(socket.getOutputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }


        while (!text.isEmpty() ) {
        System.out.println("Введите текст или оставьте поле пустым для остановки ввода:  ");
        Scanner scanner = new Scanner(System.in);
        text = scanner.nextLine();

        out.println(text);
        out.flush(); }

      //  System.out.println(in.nextLine());

       new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        if (in.hasNext()) {
                            String w = in.nextLine();
                            if (w.equalsIgnoreCase("end session")) break;
                            text = (w + "\n");
                            System.out.println("Сервер: " + text);
                        }
                    }
                } catch (Exception e) {
                }
            }
        }).start();
    }
}
