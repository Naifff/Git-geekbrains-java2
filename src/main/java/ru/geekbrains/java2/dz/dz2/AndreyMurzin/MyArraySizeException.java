package ru.geekbrains.java2.dz.dz2.AndreyMurzin;

public class MyArraySizeException extends Exception{
    @Override
    public String toString() {
        return super.toString() + " Массив неподходящего размера, нужно 4х4";
    }
}
