package ru.geekbrains.java2.dz.dz2.RustamMuftakhov;

import java.util.Random;

public class main {

    public static void main(String[] args) {

        String[][] testMassive = new String[4][4]; // задание массива неустановленного размера

        Random rnd = new Random();
        for (int i = 0; i < testMassive.length; i++) { // заполнение массива случайными числами строкового типа
            for (int j = 0; j < testMassive[i].length; j++) {
                testMassive[i][j] = "" + rnd.nextInt(100);
            }
        }

        //testMassive[1][2] = "Проверка исключения"; // задание элемента массива неподходящего типа

        try{

            exceptionMethod(testMassive);

        } catch (MyArraySizeException a){

            System.out.println("Incorrect massive size");

        } catch (MyArrayDataException c){

            System.out.println("Incorrect String Input");

        }

    }


    public static void exceptionMethod (String[][] exceptionMassive) throws MyArraySizeException, MyArrayDataException{

        int result = 0;

        if (exceptionMassive.length != 4) throw new MyArraySizeException(); // Проверка правильности размера массива

        for (int i = 0; i < exceptionMassive.length; i++) {
            if (exceptionMassive[i].length != 4) throw new MyArraySizeException();
        }


        for (int i = 0; i < exceptionMassive.length; i++) { // Проходимся по массиву и проверяем правильность элементов
            for (int j = 0; j < exceptionMassive.length; j++) {
                try {

                    result = Integer.parseInt(exceptionMassive[i][j]); // Складываем элементы массива

                } catch (NumberFormatException b){

                    System.out.println("Incorrect element has coordinates - " + i + ", " + j); // Выводим адрес ошибочного элемента в массиве
                    throw new MyArrayDataException();

                }
            }
        }

        System.out.println("Sum of numbers equals - " + result);

    }

}






