package ru.geekbrains.java2.dz.dz2.AndreyMelchuk;

public class MyArrayDataException extends Exception {
    Integer [] crash_index;
    MyArrayDataException(Integer... crash_index){
        this.crash_index = crash_index;
    }
}
