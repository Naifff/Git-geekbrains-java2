package ru.geekbrains.java2.dz.dz6.KrivonosovAlexey;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String... args) {
        ServerSocket serv = null;
        Socket client = null;
        String name = "Server";
        Scanner sc = new Scanner(System.in);
        NewThread listeningThread = null;

        try{
            serv = new ServerSocket(2288);

            System.out.println("Server started. Waiting for client...");
            client = serv.accept();
            System.out.println("Client connected");

            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            listeningThread = new NewThread(name, client );
            listeningThread.start();
            out.writeUTF(name);

            while (!listeningThread.isEnd()){
                String serverText = sc.nextLine();
                if (!listeningThread.isEnd())out.writeUTF(serverText);
                if(serverText.equalsIgnoreCase("end")){
                    System.out.println(name +" send \"end\", server closed");
                    break;
                }
            }
        }
        catch(IOException e){
            System.out.println("Ошибка инициализации сервера!");
            e.printStackTrace();
        }
        finally{
            try{
                serv.close();
                System.out.println("Server closed");
            } catch(IOException e){
                e.printStackTrace();
            }
        }

    }
}
