package ru.geekbrains.java2.dz.dz2.ShchukinAnatoli;

public class MyArrayDataException extends NumberFormatException {


    private String exceptionDetail;
    private int cell_i;
    private int cell_j;

    MyArrayDataException(String exceptionDetail, int Cell_i, int Cell_j){

        this.exceptionDetail = exceptionDetail;
        this.cell_i=Cell_i;
        this.cell_j= Cell_j;
    }

    @Override
    public String toString(){

        return "MyArrayDataException: "+ exceptionDetail+" в ячейке "+cell_i+" "+cell_j;

    }





}
