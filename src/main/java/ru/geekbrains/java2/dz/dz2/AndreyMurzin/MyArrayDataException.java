package ru.geekbrains.java2.dz.dz2.AndreyMurzin;

public class MyArrayDataException extends NumberFormatException {
    private String detail;
    public MyArrayDataException(String s) {
        super(s);
        detail = s;
    }



    @Override
    public String toString() {
       // return super.toString() + "Тут ошибка " + detail;
        return "Ошибка записи в ячеку: " + detail;
    }
}
