package ru.geekbrains.java2.dz.dz5.beloborodovdenis;

public class ArrayNoThread {

    final int SIZE = 100000000; //10 000 000
    final int H = SIZE / 2;

    void fillArrayOneThread() {
        float[] arr = new float[SIZE];
        for (int i = 0; i < SIZE; i++) {
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println(" fillArrayOneThread");
        System.out.println("Милисикунд в один поток " + (System.currentTimeMillis() - a));
    }
}
