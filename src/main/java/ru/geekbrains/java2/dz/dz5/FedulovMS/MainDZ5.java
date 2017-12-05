package ru.geekbrains.java2.dz.dz5.FedulovMS;

public class MainDZ5 {
    private static final int size = 10000000;

    public static void main(String[] args) {
        method1();

        System.out.printf("%7s %10s %10s %10s %10s\n", "Потоков", "Разбивка", "Обработка", "Склейка", "Всего");
        for (int i = 1; i <= 10; i++) {
            method2(i);
        }
    }

    private static void method1(){
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }

        System.out.println("Запуск method1() (без потоков)");

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        System.out.printf("method1() отработал за %d мс\n\n", (System.currentTimeMillis() - startTime));
    }

    private static void method2(int nThreads){
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }

        int h = size / nThreads;
        int hrem = size % nThreads;

        TaskRunner[] taskRunners = new TaskRunner[nThreads];
        float[][] arrs = new float[nThreads][];

        System.out.printf("%7d ", nThreads);

        long stageStartTime;
        long startTime = System.currentTimeMillis();

        //Разбивка массива
        for (int i = 0; i < nThreads; i++) {
            arrs[i] = new float[h+(i==nThreads-1?hrem:0)];
            System.arraycopy(arr, i*h, arrs[i], 0, h+((i==nThreads-1)?hrem:0));
        }

        System.out.printf("%7d ms ", (System.currentTimeMillis() - startTime));
        stageStartTime = System.currentTimeMillis();

        //Запуск потоков
        for (int i = 0; i < nThreads; i++) {
            taskRunners[i] = new TaskRunner(arrs[i], i*h);
            //taskRunners[i].start();
        }

        //Ожидание завершения работы потоков
        for (int i = 0; i < nThreads; i++) {
            try {
                taskRunners[i].join();
                arrs[i] = taskRunners[i].getArr();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("%7d ms ", (System.currentTimeMillis() - stageStartTime));
        stageStartTime = System.currentTimeMillis();

        //Склейка массива
        for (int i = 0; i < nThreads; i++) {
            System.arraycopy(arrs[i], 0, arr, i*h, h+((i==nThreads-1)?hrem:0));
        }

        System.out.printf("%7d ms ", (System.currentTimeMillis() - stageStartTime));
        System.out.printf("%7d ms\n", (System.currentTimeMillis() - startTime));
    }


}
