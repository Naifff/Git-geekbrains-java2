package ru.geekbrains.java2.dz.dz2.ShchukinAnatoli;

public class MyArraySizeException extends RuntimeException {

    private String exceptionDetail;

    MyArraySizeException(String exceptionDetail){
        this.exceptionDetail = exceptionDetail;
    }

    @Override
    public String toString(){

       return "MyArraySizeException: "+ exceptionDetail;

    }

}
