package ru.geekbrains.java2.dz.dz5.AnatoliShchukin;

public class Main {

    static final int size = 10000000;
    static final int h = size / 2;

    static void method1 (float arr[]) {
        long a = System.currentTimeMillis();
        for (int i=0; i<arr.length; i++){
            arr[i]= (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));


        }
        System.out.println(System.currentTimeMillis()-a);

    }

    static void method2 (float arr[]){
        long a = System.currentTimeMillis();
        float a1[] = new float[h];
        float a2[] = new float[h];

        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);


       MyThread thread1 = new MyThread(a1,0);
       MyThread thread2 = new MyThread(a2,h-1);
       thread1.start();
       thread2.start();

        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);

        System.out.println(System.currentTimeMillis()-a);
    }

    public static void main(String[] args) {


        float[] arr = new float[size];
        for (int i=0; i<size; i++){
            arr[i]=1;

        }

        method1(arr);

        for (int i=0; i<size; i++){
            arr[i]=1;

        }

        method2(arr);

    }
}

// new Thread(() -> method2(a1)).start();
// new Thread(() -> method2(a2)).start();

       /* new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<a1.length; i++){
                    a1[i]= (float)(a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                    if (i<10) System.out.println(a1[i] + "thread1");
                }

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<a2.length; i++){
                    a2[i]= (float)(a2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                    if (i<10) System.out.println(a2[i] + "thread 2");
                }

            }
        }).start(); */