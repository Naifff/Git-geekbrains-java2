package ru.geekbrains.java2.dz.dz6.BelomestsevOleg.server;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServer extends ServerSocket{
    private Socket socket;
    private Scanner scanner;
    private PrintWriter pw;
    private Scanner scanConsole;
    public static void main(String[] args) {
        try {
            ChatServer server = new ChatServer(8686);
            server.start();
        } catch (IOException e) { e.printStackTrace(); }
    }
    public ChatServer(int portNumber) throws IOException {
        super(portNumber);
    }
    public void start (){
        try {
            System.out.println("Waiting for client...");
            socket = accept();
            System.out.println("Help: Type end to exit.");
            System.out.println("OK! Session started.");
            scanner = new Scanner(socket.getInputStream());
            pw = new PrintWriter(socket.getOutputStream());
            Thread thread = new Thread(() -> {
                    while (true) {
                        String inLine = scanner.nextLine();
                        if (inLine.equalsIgnoreCase("end")) {
                            System.out.println("Info: Client is disconnected!");
                            if (scanConsole != null) System.out.println("Info: Type End to exit");
                            pw.println("end");
                            pw.flush();
                            break;
                        }
                        System.out.println("Client: "+inLine);
                    }
            });
//            thread.setDaemon(true);
            thread.start();
            while (true) {
                scanConsole = new Scanner(System.in);
                String s = scanConsole.nextLine();
                if (s.equalsIgnoreCase("end")){
                    pw.println("Info: Server is shutting down...");
                    pw.println("Info: Type end to exit");
                    pw.println("end");
                    pw.flush();
                    scanConsole = null;
                    break;
                }
                pw.println("Server: "+s);
                pw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                close();
                System.out.println("Server is offline!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}