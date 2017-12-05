package ru.geekbrains.java2.dz.dz5.RoumyantsevPA;
/*
1. Необходимо написать два метода, которые делают следующее:

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

import java.util.Arrays;

public class Main {
    static final int size =10000000;
    static final int h = size / 2;
    public int runner=0;

    public static void main(String[] args) {


//        metod1();
//        metod2();

//        int cores = Runtime.getRuntime().availableProcessors();
//        System.out.println("Processors available: " + cores);
long min=Long.MAX_VALUE;
int value=0;
long current=0;
        for (int i = 1; i < 17; i++) {
            current=metod(i);
                   if( min> current){
                       min=current;
                       value=i;
                   }
        }
        metod(16000);
        System.out.println("Самый бюыстрый: "+min+" Количество потоков: "+value);

    }

    static private void metod1() {
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }

        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Метод 1: " + (System.currentTimeMillis() - a));
       // System.out.println(arr[h - 2] + " " + arr[h - 1] + " " + arr[h] + " " + arr[h + 1] + " " + arr[h + 2] + " " + arr[size - 6] + " " + arr[size - 5] + " " + arr[size - 4] + " " + arr[size - 3] + " " + arr[size - 2] + " " + arr[size - 1]);
    }

    static private void metod2() {
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }

        long a = System.currentTimeMillis();
        float[] a1 = new float[h];
        float[] a2 = new float[h];

        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < a1.length; i++) {
                a1[i] = (float) (a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < h; i++) {
                a2[i] = (float) (a2[i] * Math.sin(0.2f + (i + h) / 5) * Math.cos(0.2f + (i + h) / 5) * Math.cos(0.4f + (i + h) / 2));
            }
        });

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
        System.out.println("Метод 2: " + (System.currentTimeMillis() - a));
       // System.out.println(arr[h - 2] + " " + arr[h - 1] + " " + arr[h] + " " + arr[h + 1] + " " + arr[h + 2] + " " + arr[size - 6] + " " + arr[size - 5] + " " + arr[size - 4] + " " + arr[size - 3] + " " + arr[size - 2] + " " + arr[size - 1]);
    }

    static private long metod(int w) {
        Thread[] threads = new Thread[w];
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }
        float[][] arrays = new float[w][size / w];
        long a = System.currentTimeMillis();
        int start = 0;
        int end = size / w;
               for (int i = 0; i < w; i++) {
            System.arraycopy(arr, start, arrays[i], 0, size / w);
            start += size / w;
            end += size / w;
        }

        for (int i = 0; i < w; i++) {

            int finalRunner = i;
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < arrays[finalRunner].length; j++) {
                        int counter =j + finalRunner * (size / w);
                        arrays[finalRunner][j] = (float) ((arrays[finalRunner][j]) * Math.sin(0.2f + counter / 5) * Math.cos(0.2f + counter / 5) * Math.cos(0.4f + counter / 2));
                    }
                }
            });
        }

        for (Thread thread:threads
             ) {thread.start();

        }
        float[] ostatok=new float[size-start];
        if (size%w!=0){


            System.arraycopy(arr, start, ostatok, 0, size -start);
               for(int i=0;i<ostatok.length;i++){
                   ostatok[i]=(float) ((ostatok[i]) * Math.sin(0.2f + (size-size%w+i) / 5) * Math.cos(0.2f + (size-size%w+i) / 5) * Math.cos(0.4f + (size-size%w+i) / 2));
               }
               }
        try {
            for (Thread thread:threads
                    ) {thread.join();
            }
        } catch (Exception e) {
        }

        start = 0;
        for (int i = 0; i < w; i++) {
            System.arraycopy(arrays[i], 0, arr, start, size / w);
            start += size / w;
        }if (size%w!=0){
            System.arraycopy(ostatok , 0, arr, start, size -start);}
long time=System.currentTimeMillis() - a;
        System.out.println("Потоков " + w + ": " + time+"мс");
        return time;
       // System.out.println(arr[h - 2] + " " + arr[h - 1] + " " + arr[h] + " " + arr[h + 1] + " " + arr[h + 2] + " " + arr[size - 6] + " " + arr[size - 5] + " " + arr[size - 4] + " " + arr[size - 3] + " " + arr[size - 2] + " " + arr[size - 1]);

    }


}
