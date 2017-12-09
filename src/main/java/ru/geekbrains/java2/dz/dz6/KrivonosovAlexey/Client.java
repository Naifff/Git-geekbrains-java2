package ru.geekbrains.java2.dz.dz6.KrivonosovAlexey;


import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String... args) {
        Socket server = null;
        Scanner sc = new Scanner(System.in);
        String name = "Client";
        NewThread listeningThread = null;

        try {
            server = new Socket("localhost", 2288);
            DataOutputStream out = new DataOutputStream(server.getOutputStream());
            listeningThread = new NewThread(name, server);
            listeningThread.start();
            out.writeUTF(name);

            while(!listeningThread.isEnd()){
               String clientText = sc.nextLine();
                if (!listeningThread.isEnd()) out.writeUTF(clientText);
               if(clientText.equalsIgnoreCase("end")) {
                   System.out.println(name +" send \"end\"");
                   break;
               }
            }
        }
        catch(IOException e){
            e.printStackTrace();
        } finally{
            System.out.println("Client programm close");
        }
    }

}
