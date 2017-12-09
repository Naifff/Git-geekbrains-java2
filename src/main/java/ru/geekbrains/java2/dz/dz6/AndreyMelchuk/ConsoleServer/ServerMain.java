package ru.geekbrains.java2.dz.dz6.AndreyMelchuk.ConsoleServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
*       SERVER
*       Запускаем три процесса,
*       один взаимодействует с клиентом,
*       второй осуществляет ввод с клавиатуры
*       третий мониторит первые два и завершает второй, если первый закончил работу.
*
*       Введите "exit" на сервере или клиенте, что бы завершить их работу.
*       РЕШЕН ВОПРОС ПРЕРЫВАНИЯ ПРОЦЕССА ВВОДА ДАННЫХ С КЛАВИАТУРЫ.
***************/


public class ServerMain {

    public static void main(String[] args) {
        Socket s = null;

        try (ServerSocket server = new ServerSocket(8189)) {
            //server.getInetAddress();
            System.out.println("ServerMain::Waiting for client...");
            s = server.accept();

            //для консольного ввода на сервере
            DataToClientThread input = new DataToClientThread(s);

            //для приема сообщений от клиента
            DataFromClientThread client = new DataFromClientThread(s);

            //Мониторинг процессов
            ServerThreadMonitor monitor = new ServerThreadMonitor(Thread.currentThread(),input,client );

            input.setDaemon(true);
            client.setDaemon(true);
            monitor.setDaemon(true);

            input.start();
            client.start();
            monitor.start();

            System.out.println("ServerMain::Client connected...");
            input.SendToClient(s, "Connected to My Super Server.\n\r" + "Type \"exit\" command to exit...\r");

            input.join();
            client.join();

            System.out.println("Server stopped.");
        } catch (Exception e) {
            //e.printStackTrace();
        } finally {
            try {
                s.close();
                System.out.println("Server socket closed.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}