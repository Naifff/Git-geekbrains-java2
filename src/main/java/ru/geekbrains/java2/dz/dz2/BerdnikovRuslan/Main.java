package ru.geekbrains.java2.dz.dz2.BerdnikovRuslan;

import java.util.ArrayList;

public class Main {
    public static ArrayList brokenCell = new ArrayList();
    public static void main(String[] args) {
        String[][] arr = {
            {"0", "2", "A", "5"},
            {"-2", "Текст", "3", "4"},
            {"3", "5", "0", "-4"},
            {"0", "Y", "W", "0"}
        };
        array(arr);
        printArray(arr);
    }

    public static void array(String[][] arr){
        int sum = 0;
        if (arr.length != 4 || arr[0].length != 4) throw new MyArraySizeException("Неверный размер двумерного массива");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    brokenCell.add("[" + i + j + "]");
                }
            }
        }
        System.out.println("Сумма чисел массива: " + sum);
        System.out.println("Неверный формат ячеек: " + brokenCell.toString());
    }

    public static void printArray(String[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
