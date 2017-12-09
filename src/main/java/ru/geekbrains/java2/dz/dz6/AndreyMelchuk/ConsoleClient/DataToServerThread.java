package ru.geekbrains.java2.dz.dz6.AndreyMelchuk.ConsoleClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicBoolean;


/*
 *       Ввод и отправка данных на сервер.
 *       РЕШЕН ВОПРОС ПРЕРЫВАНИЯ ПРОЦЕССА ВВОДА ДАННЫХ С КЛАВИАТУРЫ.
 *
 * */

public class DataToServerThread extends Thread {
    private Socket s;
    private PrintWriter out;
    BufferedReader br;
    private final AtomicBoolean stop = new AtomicBoolean();


    public DataToServerThread(Socket s) {
        this.s = s;
        try {
            out = new PrintWriter(s.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    //Чтение с клавиатуры и отправка
    public void run() {
        try {
            sendMsg("Super client started.");
            String input;
            while (!isInterrupted()) {
                try {
                    while (!br.ready() && !stop.get()) {
                        sleep(200);
                    }
                    input = br.readLine();
                    sendMsg(input);
                    System.out.print(input+">");
                    if (input.equalsIgnoreCase("exit")) break;
                }catch (InterruptedException e) {
                    System.out.println("DataToClientThread::Input cancelled.");
                    break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("\nDataToServerThread::Stopped.");
        } catch (Exception e) {
        } finally {
            out.close();
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*
     *   Посылаем сообщение серверу
     * */

    public void sendMsg(String msg) {
        if (!msg.trim().isEmpty())
            if( !s.isClosed() ) {
                out.println(msg);
                out.flush();
            }
            else {
                System.out.println("DataToServerThread::SendMsg::Socket is closed. ");
            }
    }

    public void close(){
        interrupt();
    }

    public void stopme() {
        stop.set(true);
    }
}
