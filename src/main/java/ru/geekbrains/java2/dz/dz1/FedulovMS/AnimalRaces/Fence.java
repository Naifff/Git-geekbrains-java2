package ru.geekbrains.java2.dz.dz1.FedulovMS.AnimalRaces;

public class Fence extends Barrier {
    public Fence(double height) {
        this.size = height;
    }

    @Override
    public String toString() {
        return "Забор высотой " + size + " м.";
    }

    @Override
    public char howToDealWith() {
        return 'j';
    }
}
