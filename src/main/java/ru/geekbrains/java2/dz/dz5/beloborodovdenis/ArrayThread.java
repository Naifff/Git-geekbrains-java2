package ru.geekbrains.java2.dz.dz5.beloborodovdenis;


public class ArrayThread {
    final int SIZE = 100000000; //10 000 000
    final int H = SIZE / 2;





    void fillArrayTwoThread() {

        float[] arr = new float[SIZE];
        float[] a1 = new float[H];
        float[] a2 = new float[H];
        for (int i = 0; i < SIZE; i++) {
            arr[i] = 1;
        }

        long a = System.currentTimeMillis();

        System.arraycopy(arr, 0, a1, 0, H);
        System.arraycopy(arr, H, a2, 0, H);

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < H; i++) {
                    a1[i] = (float) (a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }

                System.out.println("Первый поток End");
            }
        };
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < H; i++) {
                    a2[i] = (float) (a2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
                System.out.println("Второй поток End");
            }
        };

        thread1.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread2.start();
        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(a1, 0, arr, 0, H);
        System.arraycopy(a2, 0, arr, H, H);

        System.out.println("Главный поток end");
        System.out.println("Милисиконд в 2 потока "+(System.currentTimeMillis()-a));


    }


}
