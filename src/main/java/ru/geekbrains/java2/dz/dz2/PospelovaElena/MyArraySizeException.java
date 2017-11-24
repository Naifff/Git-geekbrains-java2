package ru.geekbrains.java2.dz.dz2.PospelovaElena;

public class MyArraySizeException extends RuntimeException {
    public MyArraySizeException(){

        System.out.println("Вы ввели плохой массив");
    }
    private String detail;

    public MyArraySizeException(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
    return "ru.geekbrains.java2.dz.dz2: details = " + detail;
   }
}
