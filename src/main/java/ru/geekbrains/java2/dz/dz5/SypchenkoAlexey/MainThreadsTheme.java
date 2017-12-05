/*
 * @author Sypchenko Aleksey
 * @version 1.0 01.12.2017
 * @task 5
*/
package ru.geekbrains.java2.dz.dz5.SypchenkoAlexey;

public class MainThreadsTheme implements Runnable {
    static final int size = 10_000_000;
    static final int h = size / 2;
    float[] arr = new float[size];
    static final int size2 = 10_000_000;
    static final int h2 = size / 2;
    float[] arr2 = new float[size];
    float[] a1 = new float[h];
    float[] a2 = new float[h];

    public static void main(String[] args) {
        MainThreadsTheme m = new MainThreadsTheme();
        m.method1();
        m.method2();
        System.out.println("Main закончил работу");
    }

    @Override
    public void run() {
        for (int i = 0; i < h; i++) {
            if (Thread.currentThread().getName() == "Thread1")
                a1[i] = (float) (a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            else
                a2[i] = (float) (a2[i] * Math.sin(0.2f + (i + h) / 5) * Math.cos(0.2f + (i + h) / 5) * Math.cos(0.4f + (i + h) / 2));
        }
    }

    public float method1() {
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Время работы метода #1 - " + (System.currentTimeMillis() - a));
        System.out.println("arr[size-1] = " + arr[size - 1]); //для проверки результата работы обоих методов
        return  arr[size-1];
    }

    // Второй разбивает массив на два массива, в двух потоках высчитывает новые значения и потом склеивает эти массивы обратно в один.
    public void method2() {
        for (int i = 0; i < size2; i++) {
            arr2[i] = 1;
        }
        // разбивка массива
        System.arraycopy(arr2, 0, a1, 0, h);
        System.arraycopy(arr2, h, a2, 0, h);
        long a = System.currentTimeMillis();
        Thread thread1 = new Thread(this, "Thread1");
        Thread thread2 = new Thread(this, "Thread2");
        thread1.start();
        thread2.start();
        try {
            thread1.join();
        } catch (InterruptedException ex) {
        }
        try {
            thread2.join();
        } catch (InterruptedException ex) {
        }
        // склейка массива
        System.arraycopy(a1, 0, arr2, 0, h);
        System.arraycopy(a2, 0, arr2, h, h);
        System.out.println("Время работы метода #2 (2 потока) - " + (System.currentTimeMillis() - a));
        System.out.println("arr2[size2-1] = " + arr2[size2 - 1]); //для проверки результата работы обоих методов
    }
}
/* ЗАДАНИЕ
 Необходимо написать два метода, которые делают следующее:

1) Создают одномерный длинный массив, например:

static final int size = 10000000;
static final int h = size / 2;
float[] arr = new float[size];

2) Заполняют этот массив единицами;
3) Засекают время выполнения: long a = System.currentTimeMillis();
4) Проходят по всему массиву и для каждой ячейки считают новое значение по формуле:
arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
5) Проверяется время окончания метода System.currentTimeMillis();
6) В консоль выводится время работы: System.out.println(System.currentTimeMillis() - a);
Отличие первого метода от второго:
Первый просто бежит по массиву и вычисляет значения.
Второй разбивает массив на два массива, в двух потоках высчитывает новые значения и потом склеивает эти массивы обратно в один.
Пример деления одного массива на два:

System.arraycopy(arr, 0, a1, 0, h);
System.arraycopy(arr, h, a2, 0, h);
Пример обратной склейки:

System.arraycopy(a1, 0, arr, 0, h);
System.arraycopy(a2, 0, arr, h, h);
Примечание:
System.arraycopy() – копирует данные из одного массива в другой:
System.arraycopy(массив-источник, откуда начинаем брать данные из массива-источника, массив-назначение, откуда начинаем записывать данные в массив-назначение, сколько ячеек копируем)
По замерам времени:
Для первого метода надо считать время только на цикл расчета:

for (int i = 0; i < size; i++) {
arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
}

Для второго метода замеряете время разбивки массива на 2, просчета каждого из двух массивов и склейки.

 */