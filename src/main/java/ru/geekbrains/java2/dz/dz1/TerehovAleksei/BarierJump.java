package ru.geekbrains.java2.dz.dz1.TerehovAleksei;

import java.util.Random;

public class BarierJump implements Barier {

    private int height;

    public BarierJump() {
        Random rnd = new Random();
        height = rnd.nextInt(5);
    }

    @Override
    public void canBarier(Animal animal) {
        animal.Jump(height);
    }

    @Override
    public void getInfo() {
        System.out.println("Прыгнуть " + height);
    }
}
