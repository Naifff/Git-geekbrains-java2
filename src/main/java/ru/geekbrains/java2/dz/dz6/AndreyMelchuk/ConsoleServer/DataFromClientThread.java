package ru.geekbrains.java2.dz.dz6.AndreyMelchuk.ConsoleServer;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class DataFromClientThread extends Thread {
    private static int CLIENTS_COUNT = 0;
    private Socket s;
    private PrintWriter out;
    private Scanner in;

    private String name;

    public DataFromClientThread(Socket s) {
        try {
            this.s = s;
            out = new PrintWriter(s.getOutputStream());
            in = new Scanner(s.getInputStream());
            CLIENTS_COUNT++;
            name = "Client #" + CLIENTS_COUNT;
        } catch (IOException e) {
        }
    }


    public void close() {
        interrupt();
        run();
    }


    /*
     *    Парсим сообщения от клиента, шлем эхо, и выводим их в консоль
     * */

    @Override
    public void run(){
        while (!isInterrupted()) {
            try {
                if (in.hasNext()) {
                    String w = in.nextLine();
                    System.out.print("\r"+name + ": " + w + "\n>");

                    //Эхо
                    out.print("\rClient: " + w + "\n\r>");
                    out.flush();

                    if (w.equalsIgnoreCase("EXIT") ){
                        break;
                    }

                }

            }catch (Exception ex) {
            }
        }

        try {
            System.out.println("\nDataFromClientThread::Stopped. Client disconnected.");
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}