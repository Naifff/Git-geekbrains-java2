package ru.geekbrains.java2.dz.dz6.lobysheva;

/*
 * Created by Oxana Lobysheva on 05/12/2017.
 */

import javax.annotation.processing.SupportedSourceVersion;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MainChat {

    public static void main(String[] args) {

        Monitor monitor = new Monitor();
        monitor.setActiveStatus();

        try (ServerSocket server = new ServerSocket(8189)) {

            System.out.println("Server open. Type 'end' to disconnect!");

            try(Socket socket = server.accept()){

                Thread thread_server = new Thread(new Server(socket, monitor));
                thread_server.start();

                Thread thread_client = new Thread(new Client(socket, monitor));
                thread_client.start();

                try {
                    thread_client.join();
                    thread_server.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Server closed");

    }
}
