package ru.geekbrains.java2.dz.dz2.lobysheva;

/*
 * Created by Oxana Lobysheva on 21/11/2017.
 */

public class MyExceptions extends Exception {

    public MyExceptions(String message){
        super(message);
    }

    public void printMyMessage(){
        System.out.println(getMessage());
    }
}
