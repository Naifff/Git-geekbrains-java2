package ru.geekbrains.java2.dz.dz2.AndreyMurzin;

import java.util.Random;

public class MainClass {
    public static void main(String[] args) {
        //String[][] strArr = new String[5][4];  //Генерация ошибки MyArraySizeException
        String[][] strArr = new String[4][4];
        Random r = new Random();
        //Заполняем массив случайными числами
        for (int i = 0; i < strArr.length; i++) {
            for (int j = 0; j < strArr[0].length; j++) {
                strArr[i][j] = "" + r.nextInt();
            }
        }

        strArr[1][3] = "gh";  //Генерация ошибки MyArrayDataException
        try {
            enter(strArr);
        } catch (MyArraySizeException e) {
            System.out.println("Задан не верный массив");
            e.printStackTrace();
        } catch (MyArrayDataException e){
            System.out.println("Ошибка записи в массив");
            e.printStackTrace();
        }


    }
    public static void enter(String[][] arr) throws MyArraySizeException {
        int sum=0;

        if ((arr.length != 4) || (arr[0].length != 4)) {
            throw new MyArraySizeException();
        }

        for (int i=0; i < arr.length; i++) {
            for (int j=0; j < arr[0].length; j++)  {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                }catch (NumberFormatException e) {
                    throw new MyArrayDataException("[" + i + "]" + "[" + j + "]");
                }
            }
        }
        System.out.println("Сумма заначений массива: " + sum);

    }
}
