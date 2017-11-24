package ru.geekbrains.java2.dz.dz2.BerdnikovRuslan;

public class MyArraySizeException extends RuntimeException {
    private String detail;
    public MyArraySizeException(String detail){
        this.detail = detail;
    }

    @Override
    public String toString() {
        return detail;
    }
}
