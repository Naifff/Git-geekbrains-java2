package ru.geekbrains.java2.dz.dz1.FedulovMS.AnimalRaces;

public class Duck extends Animal implements Swimable, Flyable{
    protected final double MAX_FLY_H_LIMIT = 5000;
    protected final double MIN_FLY_H_LIMIT= 2500;
    protected final double MAX_FLY_V_LIMIT = 100;
    protected final double MIN_FLY_V_LIMIT = 50;
    protected final double MAX_SWIM_LIMIT = 1500;
    protected final double MIN_SWIM_LIMIT = 750;

    public Duck(String name) {
        this.name = name;
        animType = "ru.geekbrains.java2.dz.dz1.FedulovMS.AnimalRaces.Duck";
        this.maxFlyDistance = this.MIN_FLY_H_LIMIT + (this.MAX_FLY_H_LIMIT-this.MIN_FLY_H_LIMIT)*this.rnd.nextDouble();
        this.maxFlyHeight = this.MIN_FLY_V_LIMIT + (this.MAX_FLY_V_LIMIT-this.MIN_FLY_V_LIMIT)*this.rnd.nextDouble();
        this.maxSwimDistance = this.MIN_SWIM_LIMIT + (this.MAX_SWIM_LIMIT-this.MIN_SWIM_LIMIT)*this.rnd.nextDouble();
    }

    @Override
    public String toString() {
        return "Утка " + name;
    }

    public boolean fly_f(double dist) {
        return (dist <= this.maxFlyDistance);
    }

    public boolean fly_h(double height) {
        return (height <= this.maxFlyHeight);
    }

    public boolean swim(double dist) {
        return (dist <= this.maxSwimDistance);
    }
}
