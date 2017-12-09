package ru.geekbrains.java2.dz.dz6.FedulovMS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class P2PChatThread extends Thread{
    private Socket sock;
    private BufferedReader netIn;
    private BufferedReader userIn;
    private PrintWriter netOut;
    private PrintWriter userOut;

    private String marker = "> ";

    public P2PChatThread(Socket sock) throws IOException {
        super();
        this.sock = sock;

        netIn = new BufferedReader(new InputStreamReader(sock.getInputStream()));
        netOut = new PrintWriter(sock.getOutputStream());

        userIn = new BufferedReader(new InputStreamReader(System.in));
        userOut = new PrintWriter(System.out);
    }

    @Override
    public void run() {
        String w = "";
        userOut.println("Соединение установлено.");
        userOut.flush();
        while(true){
            try {
                if (netIn.ready()) {
                    w = netIn.readLine();
                    userOut.printf("%s%s\n", marker, w);
                    userOut.flush();
                    if (w.equalsIgnoreCase("END")) break;
                }
                if (userIn.ready()) {
                    w = userIn.readLine();
                    netOut.println(w);
                    netOut.flush();
                    if (w.equalsIgnoreCase("END")) break;
                }
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
            if(w.equalsIgnoreCase("END")) break;
            try {// В отсутствие ввода цикл без задержки на 100% грузит ядро процессора.
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            userOut.println("Соединение разорвано.");
            userOut.flush();
            userOut.close();
            netOut.close();
            userIn.close();
            netIn.close();
            sock.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
