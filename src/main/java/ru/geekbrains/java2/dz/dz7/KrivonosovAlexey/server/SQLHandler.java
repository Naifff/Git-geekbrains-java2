package ru.geekbrains.java2.dz.dz7.KrivonosovAlexey.server;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class SQLHandler {
    private static final String dbUrl = "jdbc:postgresql://localhost:5432/postgres";
    private static final String user = "postgres";
    private static final String password = "postgres"; // наверно нехорошо делать пароль публичным, но пока так
    private static final String SQL_SELECT = "SELECT Nickname FROM main WHERE Login = ? AND Password = ?;";
    private static Connection conn;
    private static PreparedStatement stmt;
    private static final Map<String, String> MAP = new HashMap<>();


    public static void connect() {
        try {
           // DriverManager.registerDriver(new org.postgresql.Driver());
            conn = DriverManager.getConnection(dbUrl, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void disconnect() {
        try {
            conn.close();
        } catch (Exception c) {
            System.out.println("Connection Error");
        }
    }

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

//        String w = null;
//        try {
//            stmt = conn.prepareStatement(SQL_SELECT);
//            stmt.setString(1, login);
//            stmt.setString(2, password);
//            ResultSet rs = stmt.executeQuery();
//            if(rs.next())
//                w = rs.getString("Nickname");
//        } catch (SQLException e) {
//            System.out.println("SQL Query Error");
//        }
        return w;
    }
}
