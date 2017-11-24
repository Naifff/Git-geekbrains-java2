package ru.geekbrains.java2.dz.dz2.KrivonosovAlexey;

public class MyArrayDataException extends NumberFormatException {

   public MyArrayDataException(String message,int i, int j){
        super(message + "[i] " + "[j]");
   }
}
