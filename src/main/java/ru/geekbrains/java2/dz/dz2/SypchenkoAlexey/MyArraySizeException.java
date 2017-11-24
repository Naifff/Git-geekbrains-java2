package ru.geekbrains.java2.dz.dz2.SypchenkoAlexey;

public class MyArraySizeException extends Exception {
    private String reason;

    MyArraySizeException(String r) {
        this.reason = r;
    }

    @Override
    public String getMessage() {
        return reason;
    }
}
