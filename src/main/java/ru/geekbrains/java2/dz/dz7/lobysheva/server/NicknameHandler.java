package ru.geekbrains.java2.dz.dz7.lobysheva.server;

/*
 * Created by Oxana Lobysheva on 09/12/2017.
 */

import java.util.HashMap;
import java.util.Map;

public class NicknameHandler {

    private static final Map<String, String> MAP = new HashMap<>();

    public static String getNickByLoginPassword(String login, String password) {

        MAP.put("Login1", "1");
        MAP.put("Login2", "2");
        MAP.put("Login3", "3");

        String w = null;
        if (MAP.containsKey(login)) {
            String pass = MAP.get(login);
            if (pass.equals(password)) {
                w = "Nickname" + pass;
            }
        }
        return w;
    }
}
