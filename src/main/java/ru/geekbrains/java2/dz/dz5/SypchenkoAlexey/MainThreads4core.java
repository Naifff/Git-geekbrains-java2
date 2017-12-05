package ru.geekbrains.java2.dz.dz5.SypchenkoAlexey;


/*
 * @author Sypchenko Aleksey
 * @version 1.0 01.12.2017
 * @task 5
*/

public class MainThreads4core implements Runnable {
    static final int size = 10_000_000;
    static final int fourth = size / 4;
    float[] arr = new float[size];
    static final int size2 = 10_000_000;
    static final int h2 = size / 2;
    float[] arr2 = new float[size];
    float[] a1 = new float[fourth];
    float[] a2 = new float[fourth];
    float[] a3 = new float[fourth];
    float[] a4 = new float[fourth];

    public static void main(String[] args) {
        MainThreadsTheme m = new MainThreadsTheme();
        m.method1();
        m.method2();
        System.out.println("Main закончил работу");
    }

    @Override
    public void run() {
        for (int i = 0; i < fourth; i++) {
            switch (Thread.currentThread().getName()) {
                case "Thread1":
                    a1[i] = (float) (a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                    break;
                case "Thread2":
                    a2[i] = (float) (a2[i] * Math.sin(0.2f + (i + fourth) / 5) * Math.cos(0.2f
                            + (i + fourth) / 5) * Math.cos(0.4f + (i + fourth) / 2));
                    break;
                case "Thread3":
                    a3[i] = (float) (a3[i] * Math.sin(0.2f + (i + fourth * 2) / 5) * Math.cos(0.2f
                            + (i + fourth * 2) / 5) * Math.cos(0.4f + (i + fourth * 2) / 2));
                    break;
                case "Thread4":
                    a4[i] = (float) (a2[i] * Math.sin(0.2f + (i + fourth*3) / 5) * Math.cos(0.2f
                            + (i + fourth*3) / 5) * Math.cos(0.4f + (i + fourth*3) / 2));
                    break;
                default:
                    System.out.println("Кто здесь?");
            }
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
        return arr[size - 1];
    }

    // Второй разбивает массив на 4 массива, в 4-х потоках высчитывает новые значения и потом склеивает эти массивы обратно в один.
    public void method2() {
        for (int i = 0; i < size2; i++) {
            arr2[i] = 1;
        }
        // разбивка массива
        System.arraycopy(arr2, 0, a1, 0, fourth);
        System.arraycopy(arr2, fourth, a2, 0, fourth);
        System.arraycopy(arr2, fourth*2, a3, 0, fourth);
        System.arraycopy(arr2, fourth*3, a4, 0, fourth);
        long a = System.currentTimeMillis();
        Thread thread1 = new Thread(this, "Thread1");
        Thread thread2 = new Thread(this, "Thread2");
        Thread thread3 = new Thread(this, "Thread3");
        Thread thread4 = new Thread(this, "Thread4");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        try {
            thread1.join();
        } catch (InterruptedException ex) {
        }
        try {
            thread2.join();
        } catch (InterruptedException ex) {
        }
        try {
            thread3.join();
        } catch (InterruptedException ex) {
        }
        try {
            thread4.join();
        } catch (InterruptedException ex) {
        }
        // склейка массива
        System.arraycopy(a1, 0, arr2, 0, fourth);
        System.arraycopy(a2, 0, arr2, fourth, fourth);
        System.arraycopy(a3, 0, arr2, fourth*2, fourth);
        System.arraycopy(a4, 0, arr2, fourth*3, fourth);
        System.out.println("Время работы метода #2 (4 потока) - " + (System.currentTimeMillis() - a));
        System.out.println("arr2[size2-1] = " + arr2[size2 - 1]); //для проверки результата работы обоих методов
    }
}
