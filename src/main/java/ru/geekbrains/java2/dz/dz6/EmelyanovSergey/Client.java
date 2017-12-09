package ru.geekbrains.java2.dz.dz6.EmelyanovSergey;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {

        try {
            Socket socketClient = new Socket("localhost",6120);

            Scanner in = new Scanner(socketClient.getInputStream());
            PrintWriter out = new PrintWriter(socketClient.getOutputStream());

            new Thread(()-> {
                while (true) {
                    if (in.hasNext()) {
                        System.out.println("\nПолученоКлиентом:"+in.nextLine());
                        System.out.print(">>");
                    }
                }
            }).start();

            while (true) {
                System.out.print(">>");
                Scanner scanner = new Scanner(System.in);
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
