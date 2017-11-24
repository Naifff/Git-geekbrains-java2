package ru.geekbrains.java2.dz.dz2.SypchenkoAlexey;

public class MyArrayDataException extends Exception {
    private String reason;

    MyArrayDataException(String r) {
        this.reason = r;
    }

    @Override
    public String getMessage() {
        return reason;
    }
}
