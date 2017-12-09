package ru.geekbrains.java2.dz.dz6.AndreyMelchuk.ConsoleClient;

import java.net.Socket;

/*
*        CLIENT
*        Запускаем три процесса,
*        один взаимодействует с сервером,
*        второй осуществляет ввод с клавиатуры
*        третий мониторит первые два и завершает второй, если первый закончил работу.
*
*       Введите "exit" на сервере или клиенте, что бы завершить их работу.
*       РЕШЕН ВОПРОС ПРЕРЫВАНИЯ ПРОЦЕССА ВВОДА ДАННЫХ С КЛАВИАТУРЫ.
***************/


public class ClientMain {

    public static void main(String[] args) {
        final String SERVER_ADDR = "localhost";
        final int SERVER_PORT = 8189;
        Socket sock;

        try {
            sock = new Socket(SERVER_ADDR, SERVER_PORT);

            DataFromServerThread receiver = new DataFromServerThread(sock);
            DataToServerThread sender = new DataToServerThread(sock);
            ClientThreadMonitor monitor = new ClientThreadMonitor(Thread.currentThread(), sender, receiver);

            receiver.setDaemon(true);
            sender.setDaemon(true);
            monitor.setDaemon(true);

            receiver.start();
            sender.start();
            monitor.start();

            receiver.join();
            sender.join();

            sock.close();

        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("ClientMain::Couldn't connect to server or server has not been started.");
            System.exit(1);
        }finally {
        }
    }
}
