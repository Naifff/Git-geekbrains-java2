package ru.geekbrains.java2.dz.dz6.AndreyMelchuk.ConsoleServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicBoolean;

/*
*       Ввод и отправка данных клиенту.
*       РЕШЕН ВОПРОС ПРЕРЫВАНИЯ ПРОЦЕССА ВВОДА ДАННЫХ С КЛАВИАТУРЫ.
*
* */

public class DataToClientThread extends Thread{
    private Socket s;
    private PrintWriter out;
    BufferedReader br;
    private final AtomicBoolean stop = new AtomicBoolean();

    public DataToClientThread(Socket s) {
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
            String input;
            while (!isInterrupted()) {
                try {
                    while (!br.ready() && !stop.get()) {
                        sleep(200);
                    }
                    input = br.readLine();
                    System.out.print("\rServer:" + input + "\n>");
                    SendToClient(s,"\rServer:"+input+"\n\r>");
                    if (input.equalsIgnoreCase("exit")) break;
                } catch (InterruptedException e) {
                    System.out.println("DataToClientThread::Input cancelled.");
                    break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("DataToClientThread::Stopped. No more input from keyboard.");
        }finally {
            out.close();
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /*
     *   Посылаем сообщение клиенту
     * */

    public void SendToClient(Socket sock, String msg){
        if(!sock.isClosed()){
                out.println(msg);
                out.flush();
        }else {
            System.out.println("DataToClientThread::SendToClient::Socket is closed.");
        }

    }

    public void close() {
        interrupt();
    }

    public void stopme() {
        stop.set(true);
    }

}