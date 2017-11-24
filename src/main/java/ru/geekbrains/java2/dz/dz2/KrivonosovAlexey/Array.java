package ru.geekbrains.java2.dz.dz2.KrivonosovAlexey;

import java.util.Random;


public class Array {
    Random rd = new Random();

    public void randomize(String [][] arr){
        for (int i = 0; i < arr.length ; i++) {
            for (int j = 0; j < arr[0].length ; j++) {
                arr[i][j] = Integer.toString(rd.nextInt(100));
            }
        }
    }

    public void print( String [][] arr){
        for (int i = 0; i < arr.length ; i++) {
            for (int j = 0; j < arr[0].length ; j++) {
                System.out.print(arr[i][j]+ " ");
            }
            System.out.println();
        }
    }

    public int summOfElements(String [][] arr) throws MyArraySizeException, MyArrayDataException {
        if (arr.length != 4 || arr [0].length != 4) throw new MyArraySizeException("Размер массива отличается от 4х4");
        int summ = 0;
        for (int i = 0; i < arr.length ; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(!isNumber(arr[i][j])) throw new MyArrayDataException("Данные не являются числом! Номер яйчейки: ", i, j);
                summ += Integer.parseInt(arr[i][j]);
            }
        }
        return summ;
    }

    public boolean isNumber(String a){
        for(char c : a.toCharArray()){
            if (!Character.isDigit(c)) return false;
        }
    return true;
    }

}
