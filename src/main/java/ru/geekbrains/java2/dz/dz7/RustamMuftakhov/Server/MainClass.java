package ru.geekbrains.java2.dz.dz7.RustamMuftakhov.Server;
public class MainClass {
    public static void main(String[] args) {
        SQLHandler.connect();
        MyServer w = new MyServer();
        SQLHandler.disconnect();
    }
}
