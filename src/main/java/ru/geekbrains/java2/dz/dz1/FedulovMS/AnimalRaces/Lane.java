package ru.geekbrains.java2.dz.dz1.FedulovMS.AnimalRaces;

public class Lane extends Barrier{
    public Lane(double length) {
        this.size = length;
    }

    @Override
    public String toString() {
        return "Дорожка длиной " + size + " м.";
    }

    @Override
    public char howToDealWith() {
        return 'r';
    }
}
