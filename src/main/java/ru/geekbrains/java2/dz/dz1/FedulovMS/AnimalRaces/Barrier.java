package ru.geekbrains.java2.dz.dz1.FedulovMS.AnimalRaces;

public abstract class Barrier {
    protected double size;

    public double getSize() {
        return size;
    }

    public abstract char howToDealWith();

    public void printInfo(){
        System.out.println(this);
    }
}
