package ru.geekbrains.java2.dz.dz5.lobysheva;

/*
 * Created by Oxana Lobysheva on 02/12/2017.
 */

public class Main {

    private static long startTime;
    private static long endTime;

    private static float[] array1, array2;
    private static final int SIZE = 10000000;

    public static void main(String[] arg){

        array1 = new float[SIZE];
        array1 = fillArray(array1);

        startTime = System.currentTimeMillis();
        updateArray(array1, 0);
        endTime = System.currentTimeMillis();

        long time1 = endTime - startTime;
        System.out.println("Total operation time (updateSequentially) = " + time1);

        array2 = new float[SIZE];
        array2 = fillArray(array2);

        startTime = System.currentTimeMillis();
        updateArrayConcurrently(array2);
        endTime = System.currentTimeMillis();

        long time2 = endTime - startTime;
        System.out.println("Total operation time (updateConcurrently) = " + time2);

        long performance = (time2*100)/time1 - 100;
        System.out.println("Performance changed on " + performance + " %");

    }


    private static void updateArrayConcurrently(float[] array){

        final int h = SIZE / 2;
        float[] array_part1 = new float[h];
        float[] array_part2 = new float[h];
        System.arraycopy(array, 0, array_part1, 0, h);
        System.arraycopy(array, h, array_part2, 0, h);

        Thread thread1 = new Thread(() -> updateArray(array_part1,0));
        thread1.start();
        Thread thread2 = new Thread(() -> updateArray(array_part2, h));
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(array_part1, 0, array, 0, h);
        System.arraycopy(array_part2, 0, array, h, h);

    }


    private static void updateArray (float[] array, int shift){
        int k;
        for (int i = 0; i < array.length; i++){
            k = i + shift;
            array[i] = (float)(array[i] * Math.sin(0.2f + k / 5) * Math.cos(0.2f + k / 5) * Math.cos(0.4f + k / 2));
        }
    }

    private static float[] fillArray(float[] array){
        for (int i = 0; i < array.length; i++){
            array[i] = 1;
        }
        return array;
    }

}
