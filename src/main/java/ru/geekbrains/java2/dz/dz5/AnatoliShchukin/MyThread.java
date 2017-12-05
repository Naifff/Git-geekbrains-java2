package ru.geekbrains.java2.dz.dz5.AnatoliShchukin;

public class MyThread extends Thread {

    private float arr[];
    private int i1;

    MyThread(float arr[], int i){
        this.arr = arr;
        this.i1 = i;
    }

    @Override
    public void run() {
        System.out.println("*****");
        for (int i = 0 ; i<arr.length; i++){

            arr[i]= (float)(arr[i] * Math.sin(0.2f + i1 / 5) * Math.cos(0.2f + i1 / 5) * Math.cos(0.4f + i1 / 2));
            i1++;
                    }
    }
}
