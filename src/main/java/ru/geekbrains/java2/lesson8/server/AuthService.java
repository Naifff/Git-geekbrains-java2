package ru.geekbrains.java2.lesson8.server;

/**
 * Описание того, что должен уметь делать сервис авторизации
 */
public interface AuthService {
    void start(MyServer server);
    String getNickByLoginPass(String login, String pass);
    void stop();
}
