package ru.geekbrains.java2.dz.dz2.RoumyantsevPA;

public class MySizeArrayException extends Exception {

    private String detail;

    public MySizeArrayException(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "ru.geekbrains.java2.dz.dz2.RoumyantsevPA.MySizeArrayException: details = " + detail;
    }

}
