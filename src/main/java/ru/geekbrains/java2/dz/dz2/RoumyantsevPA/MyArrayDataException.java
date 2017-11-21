package ru.geekbrains.java2.dz.dz2.RoumyantsevPA;

public class MyArrayDataException extends Exception {

    private String detail;

    public MyArrayDataException(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "ru.geekbrains.java2.dz.dz2.RoumyantsevPA.MyArrayDataException: details = " + detail;
    }

}


