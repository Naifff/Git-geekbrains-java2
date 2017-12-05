package ru.geekbrains.java2.dz.dz5.beloborodovdenis;

public class Main {
    public static void main(String[] args) {
        long t= System.currentTimeMillis();
        ArrayNoThread arrayNoThread =new ArrayNoThread();
        arrayNoThread.fillArrayOneThread();

        ArrayThread arrayThread = new ArrayThread();
        arrayThread.fillArrayTwoThread();



    }
}
