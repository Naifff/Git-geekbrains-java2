package ru.geekbrains.java2.dz.dz5.AlinaZhirova;

public class MyRun implements Runnable {

    private float[] runArray;
    private int startIndex;


    public MyRun(float[] runArray, int startIndex) {
        super();
        this.runArray = runArray;
        this.startIndex = startIndex;
    }


    @Override
    public void run() {
        int i = 0;
        int curIndex = startIndex;

        while (i < runArray.length) {
            runArray[i] = (float)(runArray[i] * Math.sin(0.2f + curIndex / 5) * Math.cos(0.2f + curIndex / 5) * Math.cos(0.4f + curIndex / 2));
            i++;
            curIndex++;
        }
    }


}
