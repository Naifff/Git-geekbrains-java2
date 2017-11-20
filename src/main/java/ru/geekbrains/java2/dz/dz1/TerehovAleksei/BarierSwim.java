package ru.geekbrains.java2.dz.dz1.TerehovAleksei;

import java.util.Random;

public class BarierSwim implements Barier {
    private int distance;

    public BarierSwim() {
        Random rnd = new Random();
        distance = rnd.nextInt(500);
    }

    @Override
    public void canBarier(Animal animal) {
        animal.Swim(distance);
    }

    @Override
    public void getInfo() {
        System.out.println("Проплыть " + distance);
    }
}
