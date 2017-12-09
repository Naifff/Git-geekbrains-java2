package ru.geekbrains.java2.dz.dz6.AndreyMurzin;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void StartServer(){
        final int PORT = 6666;
        ServerSocket serv = null;
        Socket sock = null;

        try {
            serv = new ServerSocket(PORT);
            System.out.println("Сервер запущен, ожидание клиента...");
            sock = serv.accept();
            System.out.println("Клиент подключен...");

            Scanner sc = new Scanner(sock.getInputStream());
            PrintWriter pw = new PrintWriter(sock.getOutputStream());

            System.out.println("Чат запущен, можно начать общение.");
            pw.println("Чат запущен, можно начать общение.");
            pw.flush();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        while (true){
                            Scanner scan = new Scanner(System.in);
                            String w = scan.nextLine();
                            pw.println(w);
                            pw.flush();
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }).start();


            while(true){
                String str = sc.nextLine();
                System.out.println("client: " + str);
                if(str.equals("end")) {
                    System.out.println("был написан end");
                    break;
                }
            }

        } catch (IOException e) {
            System.out.println("Ошибка инициализации сервера.");
        }finally {
            try {
                serv.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
