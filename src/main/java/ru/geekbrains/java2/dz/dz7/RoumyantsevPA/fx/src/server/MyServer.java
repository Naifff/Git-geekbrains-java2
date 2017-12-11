package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;


public class MyServer {

    private Vector<ClientHandler> clients = new Vector<>();
    private HashMap<String, Integer> auth = new HashMap<>();
    private HashMap<String, ClientHandler> userId = new HashMap<>();

    public MyServer() {
        auth.put("root", -1195288997);
        ServerSocket server = null;
        Socket socket = null;
        try {
            server = new ServerSocket(8189);
            System.out.println("Server created. Waiting for client...");
            while (true) {
                socket = server.accept();
                System.out.println("Client connected");
                ClientHandler h = new ClientHandler(socket, this);
                //  clients.add(h);
                new Thread(h).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                server.close();
                System.out.println("Server closed");
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void addClient(ClientHandler c) {
        clients.add(c);
    }

    public void remove(ClientHandler o) {
        clients.remove(o);
    }

    public void removeId(String s) {

        this.userId.remove(s);
    }

    public void broadcastMsg(String msg) {
        for (ClientHandler o : clients) {
            o.sendMsg(msg);
        }
    }

    public void setAuth(String login, String password) {
        this.auth.put(login, password.hashCode());
    }

    public void setUserId(String login, ClientHandler c) {
        this.userId.put(login, c);
    }

    public Integer getAuth(String login) {
        return this.auth.get(login);
    }

    public String list() {
        return this.userId.keySet().toString();
    }

    public boolean isLogin(String login) {

        return this.auth.containsKey(login);
    }

    public ClientHandler getUserId(String login) {
        return this.userId.get(login);
    }

    public void sendPM(String login1, String login2, String str) {
        if (userId.get(login2) != null) {
            userId.get(login1).sendMsg("to " + login2 + ": " + str);
            userId.get(login2).sendMsg("@" + login1 + ": " + str);
        } else {
            userId.get(login1).sendMsg("пользователь: " + login2 + " не найден");
        }


    }

    public String listRoot() {
        String out = "";
        for (String s : auth.keySet()) {
            out += s + ":" + auth.get(s) + "|";
        }
        return out;

    }

    public String help() {
        return "list - список онлайн пользователей" + System.lineSeparator() + "@user - отправка личного сообщения" + System.lineSeparator() + "end - заверщение работы";
    }
}
