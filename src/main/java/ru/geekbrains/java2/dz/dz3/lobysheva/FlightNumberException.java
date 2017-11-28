package ru.geekbrains.java2.dz.dz3.lobysheva;

/*
 * Created by Oxana Lobysheva on 25/11/2017.
 */

public class FlightNumberException extends Exception {

    public FlightNumberException(String message){
        super(message);
    }

    public void printExceptionMessage(){
        System.out.println(getMessage());
    }

}
