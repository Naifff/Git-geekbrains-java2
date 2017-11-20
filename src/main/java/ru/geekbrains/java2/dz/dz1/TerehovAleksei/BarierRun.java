package ru.geekbrains.java2.dz.dz1.TerehovAleksei;

import java.util.Random;

public class BarierRun implements Barier {

    private int distance;

    public BarierRun() {
        Random rnd = new Random();
        distance = rnd.nextInt(1000);
    }

    @Override
    public void canBarier(Animal animal) {
        animal.Run(distance);
    }

    @Override
    public void getInfo() {
        System.out.println("Пробежать " + distance);
    }
}
