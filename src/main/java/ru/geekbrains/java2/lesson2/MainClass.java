package ru.geekbrains.java2.lesson2;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {
        p13();
//        p5(10, 0);
//        p12(10, 10);
//
//        try {
//            p10();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        p8sqrt(-6);
    }


    public static void p1() { // пример исключения
        int a = 10;
        int b = 0;

        int c = a / b; // ArithmeticException

    }

    public static void p2() { // пример обработки исключения
        int a = 10;
        int b = 0;
        try {
            int c = a / b;
            System.out.println("a / b");
        } catch (ArithmeticException e) {
//            System.out.println(e);
//            e.printStackTrace();
            System.out.println("Error");
        }
        System.out.println("Exit");
    }

    public static void p3() { // пример того как мы неправильно ловим исключение, вылетает АЕ, а мы пытаемся поймать NPE
        int a = 10;
        int b = 0;

        try {
            int c = a / b;
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("Error");
        }
    }

    public static void p4() { // примеры исключений
        int a = 10;
        int b = 0;
        int c = a / b; // ArithmeticException

        Cat cat = null;
        cat.info(); // NullPointerException

        int[] w = new int[5];
        w[10] = 10; // ArrayIndexOoutOfBoundsException

        int q = new Scanner(System.in).nextInt(); // InputMismatchEexception, если ввести не число, а слово
    }

    public static void p5(int a, int b) { // отлов нескольких исключений +порядок отлова
        try {
            int c = a / b; // ArithmeticException
//            int g = a % b;

            int[] w = new int[5];
            w[10] = 10; // ArrayIndexOutOfBoundsException
        } catch (ArithmeticException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally");
            //    код всегда выполнится
        }
    }

    public static void p6() { // так делать нельзя
        /*
        try {

            int a = 10;
            int b = 0;
            int c = a / b; // ArithmeticException
        } catch (Exception e) {
            e.printStackTrace();
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }*/
    }

    public static void p7() {
        try {
            throw new RuntimeException(); // сами бросаем исключение
//            int i = 10;
        } catch (RuntimeException e) {
            e.printStackTrace();
//            Integer.parseInt("");
            throw e;
        }
    }

    public static float p8sqrt(float a) {
        // мы то знаем что нельзя получить корень из отрицательного числа
        // а метод заставляет нас что-то но вернуть
        // чтобы обойти эту проблему может бросить эксепшн
        if (a < 0) throw new ArithmeticException("Нельзя получть корень из отрицательного числа");
        return a / 2.0f; // считаем что вычисление корня делается через деление на 2
    }

    public static void p9() { // отлавливаем checked exception
        PrintWriter pw = null;
//        pw.append()


        try {
            pw = new PrintWriter("p://2.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        if (pw != null) {
            pw.close();
        }
    }

    public static void p10() throws FileNotFoundException, ClassNotFoundException { // пробрасываем исключение
        PrintWriter pw = new PrintWriter("p://1.txt");
        pw.close();
        throw new ClassNotFoundException();
    }



    public static void p11() {

        throw new MyException("Test throw");
    }

    public static void p12(int a, int b) { // отлов нескольких исключений +порядок отлова
        try {
            int c = a / b; // ArithmeticException
//            int g = a % b;

            int[] w = new int[5];
            w[10] = 10; // ArrayIndexOoutOfBoundsException
        } catch (ArithmeticException|ArrayIndexOutOfBoundsException|NullPointerException e) {
            e.printStackTrace();
        }  finally {
            System.out.println("finally");
            //    код всегда выполнится
        }
    }


    public static void p13() { // отлавливаем checked exception


        try (PrintWriter pw = new PrintWriter("p://2.txt")){
            pw.append('e');
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
