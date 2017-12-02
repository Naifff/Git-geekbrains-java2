package ru.geekbrains.java2.lesson5;

/**
 * Created by Home-pc on 01.09.2016.
 */
public class MainClass {


    public static void main(String[] args) {
        System.out.println("main start");


        Runnable runnable = new MyRun();
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new MyThread();

        thread1.start();
        thread2.start();
//        thread1.setPriority(7);







        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }

        System.out.println("main stop");
    }

}
