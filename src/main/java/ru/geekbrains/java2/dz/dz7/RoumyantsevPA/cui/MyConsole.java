package ru.geekbrains.java2.dz.dz7.RoumyantsevPA.cui;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MyConsole {


    final String SERVER_ADDR = "localhost";
    final int SERVER_PORT = 8189;
    Socket sock;
    DataInputStream in;
    Scanner sc = new Scanner(System.in);
    DataOutputStream out;
    boolean end = false;

    public MyConsole() {
        try {
            sock = new Socket(SERVER_ADDR, SERVER_PORT);
            in = new DataInputStream(sock.getInputStream());
            out = new DataOutputStream(sock.getOutputStream());
        } catch (IOException e) {
            System.out.println("Сервер не запущен");
            e.printStackTrace();
        }

        new Thread(() -> {
            Thread outConsole = new Thread(() -> {
                try{
                while (true) {
                    if (sc.hasNext()) {
                        String a = sc.nextLine();
                        out.writeUTF(a);
                        out.flush();
                    }
                }}catch (Exception e){}
            });
            outConsole.setDaemon(true);
            outConsole.start();

            while (true) {
             //   if (in.readUTF()) {
                String w = null;
                try {
                    w = in.readUTF();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (w.equalsIgnoreCase("end session")) {
                        end = true;
                        System.out.println(w);
                        break;
                    }
                    System.out.println(w);
               // }
            }
            //outConsole.stop();
            try {
                out.close();
                in.close();
                sock.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}



