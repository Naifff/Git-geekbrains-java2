package ru.geekbrains.java2.lesson5;

/**
 * Created by i on 30.11.2017.
 */
public class MyRun implements Runnable {
    @Override
    public void run() {
        System.out.println("Run start");
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {

            }
            System.out.println("Run: " + i);
        }
        System.out.println("Run stop");
    }
}
