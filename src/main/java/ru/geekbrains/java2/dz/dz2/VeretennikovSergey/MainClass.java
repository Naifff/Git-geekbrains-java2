package ru.geekbrains.java2.dz.dz2.VeretennikovSergey;

import java.util.Arrays;
import java.util.Scanner;

public class MainClass {
    public static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        int n1, n2;
        System.out.println("Введите размерность двумерного массива");
        System.out.println("n1: ");
        n1 = sc.nextInt();
        System.out.println("n2: ");
        n2 = sc.nextInt();

        String [][] ar = new String[n1][n2];
        System.out.println("Заполните массив данными");
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar.length; j++) {
                ar[i][j] = sc.nextLine();
            }
        }
        Array arr = new Array(ar);
        arr.SumArray();
        arr.infoArray();


    }
}
