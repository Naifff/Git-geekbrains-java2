package ru.geekbrains.java2.dz.dz6.AndreyMelchuk.ConsoleClient;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/*
    Получение сообщений с сервера
* */

public class DataFromServerThread extends Thread{
    private Socket  s;
    private Scanner in;

    public DataFromServerThread(Socket socket) {
        this.s = socket;

        try {
            in = new Scanner(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                if (in.hasNext()) {
                    String w = in.nextLine();
                    System.out.print("\n"+w);
                    if (w.contains("Server:exit")) break;
                }
            }
            System.out.println("\nDataFromServerThread::Stopped.");

        } catch (Exception e) {
        } finally {
            in.close();
        }
    }

    public void close(){
        interrupt();
        //run();
    }

}
