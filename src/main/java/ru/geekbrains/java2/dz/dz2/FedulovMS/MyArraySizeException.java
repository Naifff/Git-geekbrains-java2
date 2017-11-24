package ru.geekbrains.java2.dz.dz2.FedulovMS;

public class MyArraySizeException extends Exception {
    private String msg;

    public MyArraySizeException() {
        this.msg = "Ошибка размера массива, ожидается массив 4x4.";
    }

    public MyArraySizeException(String message) {
        this.msg = message;
    }

    @Override
    public String toString() {
        return "ru.geekbrains.java2.dz.dz2.FedulovMS.MyArraySizeException: " + msg;
    }
}


