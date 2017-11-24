package ru.geekbrains.java2.dz.dz2.VeretennikovSergey;

public class MyArrayDataException extends NumberFormatException {

    public MyArrayDataException(int i, int j){
        super("Ошибка в ячейки массива" +" " + i + " "+ j);
    }
}
