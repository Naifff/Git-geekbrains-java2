package ru.geekbrains.java2.dz.dz5.AlinaZhirova;

import java.lang.reflect.Array;

public class Main {

    public static final int SIZE = 10000000;
    public static final int MIDDLE_SIZE = SIZE / 2;


    public static void standardMethod() {
        float[] curArray = new float[SIZE];
        for (int i = 0; i < curArray.length; i++) {
            curArray[i] = 1f;
        }

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < curArray.length; i++) {
            curArray[i] = (float)(curArray[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long endTime = System.currentTimeMillis() - startTime;
        System.out.println("standardMethod, the end time = " + endTime);
    }


    public static void parallelizationMethod() throws InterruptedException {
        float[] initArray = new float[SIZE];
        for (int i = 0; i < initArray.length; i++) {
            initArray[i] = 1f;
        }

        long timeBeforeDivision = System.currentTimeMillis();
        float[] subArray1 = new float[MIDDLE_SIZE];
        float[] subArray2 = new float[MIDDLE_SIZE];
        System.arraycopy(initArray, 0, subArray1, 0, MIDDLE_SIZE);
        System.arraycopy(initArray, MIDDLE_SIZE, subArray2, 0, MIDDLE_SIZE);
        long arrayDivisionTime = System.currentTimeMillis() - timeBeforeDivision;
        System.out.println("parallelizationMethod, the division of the array time = " + arrayDivisionTime);

        Runnable runnable1 = new MyRun(subArray1, 0);
        Thread thread1 = new Thread(runnable1);
        long timeBeforeThreadStarting1 = System.currentTimeMillis();
        thread1.start();

        Runnable runnable2 = new MyRun(subArray2, MIDDLE_SIZE);
        Thread thread2 = new Thread(runnable2);
        long timeBeforeThreadStarting2 = System.currentTimeMillis();
        thread2.start();

        thread1.join();
        long threadCalculationTime1 = System.currentTimeMillis() - timeBeforeThreadStarting1;
        System.out.println("parallelizationMethod, the calculation of the first thread time = " + threadCalculationTime1);

        thread2.join();
        long threadCalculationTime2 = System.currentTimeMillis() - timeBeforeThreadStarting2;
        System.out.println("parallelizationMethod, the calculation of the second thread time = " + threadCalculationTime2);

        long timeBeforeBonding = System.currentTimeMillis();
        System.arraycopy(subArray1, 0, initArray, 0, MIDDLE_SIZE);
        System.arraycopy(subArray2, 0, initArray, MIDDLE_SIZE, MIDDLE_SIZE);

        long arrayBondingTime = System.currentTimeMillis() - timeBeforeBonding;
        System.out.println("parallelizationMethod, the bonding of arrays time = " + arrayBondingTime);
    }


    public static void main(String[] args) {
        standardMethod();

        try {
            parallelizationMethod();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
