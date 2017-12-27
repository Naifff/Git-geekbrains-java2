package ru.geekbrains.java2.dz.dz5.RustamMuftakhov;

import com.sun.org.apache.xpath.internal.SourceTree;

public class Main {

    static final int size = 1000000;
    static final int h = size/2;

    public static void main(String[] args) {
        method1();
        method2();
    }

    public static void method1(){
        float[] arr = new float[size];
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }

        long a = System.currentTimeMillis();

        for (int i = 0; i < size; i++) {
            arr[i] = (float)(arr[i]*Math.sin(0.2f+i/5)*Math.cos(0.2f+i/5)*Math.cos(0.4f+i/2));
        }

        System.out.println("Первый метод выполнялся " + (System.currentTimeMillis() - a) + " миллисекунд");
    }

    public static void method2(){
        float[] arr = new float[size];
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }

        float[] a1 = new float[h];
        float[] a2 = new float[h];

        long a = System.currentTimeMillis();

        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        Thread threadOne = new Thread(new Runnable() {

            @Override
            public synchronized void run() {
                System.out.println("Начало первого потока");

                    for (int i = 0; i < h; i++) {
                        a1[i] = (float)(a1[i]*Math.sin(0.2f+i/5)*Math.cos(0.2f+i/5)*Math.cos(0.4f+i/2));
                    }


                    System.out.println("Конец первого потока");
                    System.out.println("Первый поток выполнялся " + (System.currentTimeMillis() - a) + " миллисекунд");

            }

        });

        Thread threadTwo = new Thread(new Runnable() {

            @Override
            public synchronized void run() {
                System.out.println("Начало второго потока");
                for (int i = 0; i < h; i++) {
                    a2[i] = (float)(a2[i]*Math.sin(0.2f+i/5)*Math.cos(0.2f+i/5)*Math.cos(0.4f+i/2));
                }
                System.out.println("Конец второго потока");
                System.out.println("Второй поток выполнялся " + (System.currentTimeMillis() - a) + " миллисекунд");
            }


        });

        threadOne.start();
        threadTwo.start();

        try{
            threadOne.join();
            threadTwo.join();
        } catch (InterruptedException e){
            System.arraycopy(a1, 0, arr, 0, h);
            System.arraycopy(a2, 0, arr, h, h);
        }

        System.out.println("Второй метод выполнялся " + (System.currentTimeMillis() - a) + " миллисекунд");

    }
}
