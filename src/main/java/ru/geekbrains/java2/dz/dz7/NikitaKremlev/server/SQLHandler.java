package ru.geekbrains.java2.dz.dz7.NikitaKremlev.server;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class SQLHandler {

    private static final Map<String, String> MAP = new HashMap<>();

    public static String getNickByLoginPassword(String login, String password) {
        MAP.put("Login1", "1");
        MAP.put("Login2", "2");
        MAP.put("Login3", "3");
        String user = null;
        if (MAP.containsKey(login)) {
            String pass = MAP.get(login);
            if (pass.equals(password)) {
                user = "Nickname" + pass;
            }
        }
        return user;
    }
}
