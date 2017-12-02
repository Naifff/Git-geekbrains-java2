package ru.geekbrains.java2.lesson5;

/**
 * Created by i on 30.11.2017.
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("Thread start");
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {

            }
            System.out.println("Thread: " + i);
        }
        System.out.println("Thread stop");
    }
}
