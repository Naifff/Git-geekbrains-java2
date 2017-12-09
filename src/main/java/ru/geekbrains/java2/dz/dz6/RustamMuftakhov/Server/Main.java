package ru.geekbrains.java2.dz.dz6.RustamMuftakhov.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
        Socket s = null;
        try (ServerSocket serverSocket = new ServerSocket(8189)) {
            System.out.println("Создание сервера, ожидание клиента");
            while (true){
                s = serverSocket.accept();
                System.out.println("Клиент подсоединен, набирайте свое сообщение. Чтобы закончить сессию, напишите end session");
                ClientHandler handler = new ClientHandler(s);
            }
        }catch (IOException e) {
            e.printStackTrace();
        } finally {
            try{
                s.close();
                System.out.println("Сервер закрыт");
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
