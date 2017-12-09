package ru.geekbrains.java2.dz.dz6.AnatoliShchukin.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler implements Runnable {


        private Socket s;
        private PrintWriter out;
        private Scanner in;
        private String text = " ";

        public ClientHandler(Socket s) {
            try {
                this.s = s;
                out = new PrintWriter(s.getOutputStream());
                in = new Scanner(s.getInputStream());

            } catch (IOException e) {
            }

            while (!text.isEmpty() ){
            System.out.println("Введите текст или оставьте поле пустым для остановки ввода: ");
            Scanner scanner = new Scanner(System.in);
            text = scanner.nextLine();

            out.println(text);
            out.flush();}

        }

        @Override
        public void run() {
            while (true) {
                if(in.hasNext()) {
                    String w = in.nextLine();
                    System.out.println("Клиент: " + w+ "\n");
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
