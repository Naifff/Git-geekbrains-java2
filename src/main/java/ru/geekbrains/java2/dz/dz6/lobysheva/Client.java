package ru.geekbrains.java2.dz.dz6.lobysheva;

/*
 * Created by Oxana Lobysheva on 06/12/2017.
 */


import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client implements Runnable {
    private Socket socket;
    private Scanner scanner;
    private final String name = "Client #1";
    private Monitor monitor;

    public Client(Socket socket, Monitor monitor) {
        try {
            this.socket = socket;
            this.monitor = monitor;
            scanner = new Scanner(socket.getInputStream());
        }catch (IOException e) {
        }
    }

    @Override
    public void run() {
        while (monitor.getApplicationStatus().equals("Active")) {
            if(scanner.hasNext()) {
                String inputText = scanner.nextLine();
                if(inputText.equalsIgnoreCase("END")) {
                    monitor.setClosedStatus();
                }
                System.out.println(name + ": " + inputText);
            }
        }
        try {
            socket.close();
            System.out.println(name + " disconnected");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

