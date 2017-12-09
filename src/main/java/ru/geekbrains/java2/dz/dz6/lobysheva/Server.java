package ru.geekbrains.java2.dz.dz6.lobysheva;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Server implements Runnable {

    private Socket socket;
    private PrintWriter writer;
    private Scanner scanner;
    private Monitor monitor;

    private final String name = "Server";

    public Server(Socket socket, Monitor monitor) {
        try {
            this.socket = socket;
            this.monitor = monitor;
            writer = new PrintWriter(socket.getOutputStream());
            scanner = new Scanner(System.in);
        } catch (IOException e) {
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
                writer.println(name + ": " + inputText);
                writer.flush();
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
