/**
 * @author Sypchenko Aleksey
 * @version 1.0 21.11.2017
 * @task 2
 * @mark 1 Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4, при
 * подаче массива другого размера необходимо бросить исключение MyArraySizeException.
 * 2 Далее метод должен пройтись по всем элементам массива, преобразовать в int, и
 * просуммировать. Если в каком-то элементе массива преобразование не удалось (например, в
 * ячейке лежит символ или текст вместо числа), должно быть брошено исключение
 * MyArrayDataException, с детализацией в какой именно ячейке лежат неверные данные.
 * 3 В методе main() вызвать полученный метод, обработать возможные исключения
 * MySizeArrayException и MyArrayDataException, и вывести результат расчета.
 */

package ru.geekbrains.java2.dz.dz2.SypchenkoAlexey;

public class MainDZ_2 {
    public final int SIZE = 4;

    public static void main(String[] args) {
//        String array[][] = {
//                {"1", "1", "1", "1"},
//                {"1", "1", "1", "1"},
//                {"1", "1", "1", "1"},
//                {"1", "1", "1", "1", "одын"}
//        };
        String array[][] = {
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "два"}
        };
//        String array[][] = { // правильный массив
//                {"1", "1", "1", "1"},
//                {"1", "1", "1", "1"},
//                {"1", "1", "1", "1"},
//                {"1", "1", "1", "1"}
//        };
//        String array[][] = {
//                {"1", "1", "1", "1"},
//                {"1", "1", "1", "1"},
//                {"1", "1", "1", "1"}
//        };

        MainDZ_2 m = new MainDZ_2();
        try {
            m.verifyArray(array);
        } catch (MyArraySizeException | MyArrayDataException ex) {
            System.out.println(ex.getMessage());

        }
    }

    public void verifyArray(String[][] arr) throws MyArrayDataException, MyArraySizeException {
        // отрабатываем самописное исключение MyArraySizeException
        for (int i = 0; i < SIZE; i++) {
            if (arr.length != SIZE || arr[i].length != SIZE)
                throw new MyArraySizeException("Размер массива не 4х4 !!!");
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                // отрабатываем самописное исключение MyArrayDataException
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (Exception ex) {
                    throw new MyArrayDataException("В ячейке [" + i + "][" + j + "] лежит не число !!!");
                }
            }
        }
        System.out.println("Сумма массива = " + sum);
    }
}