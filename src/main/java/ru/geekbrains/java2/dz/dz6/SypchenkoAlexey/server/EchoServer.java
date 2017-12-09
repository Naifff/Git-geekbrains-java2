package ru.geekbrains.java2.dz.dz6.SypchenkoAlexey.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {
    private static int PORT = 8189;

    public static void main(String[] args) {
        ServerSocket serv = null;
        Socket s = null;
        try {
            serv = new ServerSocket(PORT);
            System.out.println("Server started, waiting connection...");
            while (true) {
                s= serv.accept();
                System.out.println("Client connected");
                new Thread (new ClientHandler(s)).start();
            }
        } catch (IOException e) {

            System.out.println("Error inicialisation server");
        } finally {
            try {
                serv.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
