package ru.geekbrains.java2.dz.dz6.AndreyMurzin;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void startClient() {
        String adress = "localhost";
        final int PORT = 6666;
        Scanner scaner = new Scanner(System.in);

        try {
            Socket sock = new Socket(adress, PORT);
            Scanner sc = new Scanner(sock.getInputStream());
            PrintWriter pw = new PrintWriter(sock.getOutputStream());
            System.out.println("Подключаемся к " + adress + " и порту: " + PORT);
            System.out.println("Произошло подключение к серверу");

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        while (true){
                            String str = sc.nextLine();
                            System.out.println("server: " + str);
                            if(str.equals("end")) {
                                System.out.println("был написан end");
                                break;
                            }
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }).start();


            String line = null;
            while (true){
                line = scaner.nextLine();
                pw.println(line);
                pw.flush();
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
