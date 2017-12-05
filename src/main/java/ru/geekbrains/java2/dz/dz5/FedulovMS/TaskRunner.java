package ru.geekbrains.java2.dz.dz5.FedulovMS;

public class TaskRunner extends Thread{
    private float[] arr;
    private int startPos;

    @Override
    public void run() {
        for (int i = 0; i < this.arr.length; i++) {
            this.arr[i] = (float)(this.arr[i] * Math.sin(0.2f + (this.startPos+i) / 5) * Math.cos(0.2f + (this.startPos+i) / 5) * Math.cos(0.4f + (this.startPos+i) / 2));
        }
    }

    public float[] getArr() {
        return arr;
    }

    public TaskRunner(float[] arr, int startPos) {
        this.arr = arr;
        this.startPos = startPos;
        this.start();
    }
}
