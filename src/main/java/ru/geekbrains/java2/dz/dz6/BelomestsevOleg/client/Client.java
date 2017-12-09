package ru.geekbrains.java2.dz.dz6.BelomestsevOleg.client;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    Socket socket;
    private Scanner scanner;
    private PrintWriter pw;

    public static void main(String[] args) {
        new Client().connect("localhost",8686 );
    }
    public void connect(String serverAdr,int port) {
        try {
            System.out.println("Help: Type end to exit.");
            socket = new Socket(serverAdr,port);
            System.out.println("Connected to server!");
            scanner = new Scanner(socket.getInputStream());
            pw = new PrintWriter(socket.getOutputStream());
            new Thread(() -> {
                while (true) {
                    if (socket.isClosed()) break;
                    String inLine = scanner.nextLine();
                    if (inLine.equalsIgnoreCase("end")) {
                        pw.println(inLine);
                        pw.flush();
                        break;
                    }
                    System.out.println(inLine);
                }
            }).start();
            while (true) {
                Scanner scanConsole = new Scanner(System.in);
                String s = scanConsole.nextLine();
                if (s.equalsIgnoreCase("end")){
                    pw.println(s);
                    pw.flush();
                    break;
                }
                pw.println(s);
                pw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
