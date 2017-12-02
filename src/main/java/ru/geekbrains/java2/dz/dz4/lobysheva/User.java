package ru.geekbrains.java2.dz.dz4.lobysheva;

/*
 * Created by Oxana Lobysheva on 28/11/2017.
 */

public class User {

    private String user;

    public String getUser(){
        if (user.isEmpty()) return "unknown";
        return user;
    }

    public void setUser(String userName){
        user = userName;
    }
}
