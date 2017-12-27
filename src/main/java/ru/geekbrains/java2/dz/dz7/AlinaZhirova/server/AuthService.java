package ru.geekbrains.java2.dz.dz7.AlinaZhirova.server;

public interface AuthService {
    void start();
    String getNickByLoginPass(String login, String pass);
    void stop();
}
