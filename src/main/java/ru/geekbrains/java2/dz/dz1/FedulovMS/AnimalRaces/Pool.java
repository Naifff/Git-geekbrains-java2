package ru.geekbrains.java2.dz.dz1.FedulovMS.AnimalRaces;

public class Pool extends Barrier {
    public Pool(double length) {
        this.size = length;
    }

    @Override
    public String toString() {
        return "Бассейн длиной " + size + " м.";
    }

    @Override
    public char howToDealWith() {
        return 's';
    }
}
