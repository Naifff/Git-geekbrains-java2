package ru.geekbrains.java2.dz.dz2.PospelovaElena;

public class MyArrayDataException extends NumberFormatException {
    private String detail;

    public MyArrayDataException(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "ru.geekbrains.java2.lesson2.MyException: details = " + detail;
    }
}
