package ru.geekbrains.java2.lesson2;

public class MyException extends RuntimeException { // прописали собственный класс unchecked exception

    private String detail;

    public MyException(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "ru.geekbrains.java2.lesson2.MyException: details = " + detail;
    }

}
