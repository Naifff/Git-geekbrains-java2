package ru.geekbrains.java2.lesson5;

public class Example_SB_2 {
    private Object lock1 = new Object();
    private Object lock2 = new Object();

    public static void main(String[] args) {
        Example_SB_2 e2 = new Example_SB_2();
        System.out.println("Start");
        new Thread(() -> e2.method1()).start();
        new Thread(() -> e2.method1()).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                e2.method2();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                e2.method2();
            }
        }).start();
    }

    public void method1() {
        System.out.println("Normal part");
        for (int i = 0; i < 3; i++) {
            System.out.println(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        synchronized (lock1) { // можно еще synchronize(this)
            System.out.println("Synch block");
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("M2");

    }


    public void method2() {
        System.out.println("Normal part2");
        for (int i = 0; i < 3; i++) {
            System.out.println(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        synchronized (lock2) { // можно еще synchronize(this)
            System.out.println("Synch block2");
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("M2");

    }
}
