package ru.geekbrains.java2.dz.dz1.FedulovMS.AnimalRaces;

public class Horse extends Animal implements Runable, Jumpable, Swimable {
    protected final double MAX_RUN_LIMIT = 10000;
    protected final double MIN_RUN_LIMIT = 5000;
    protected final double MAX_JUMP_LIMIT = 1.5;
    protected final double MIN_JUMP_LIMIT = 0.75;
    protected final double MAX_SWIM_LIMIT = 500;
    protected final double MIN_SWIM_LIMIT = 250;

    public Horse(String name) {
        super(name);
        animType = "ru.geekbrains.java2.dz.dz1.FedulovMS.AnimalRaces.Horse";
        this.maxRunDistance = this.MIN_RUN_LIMIT + (this.MAX_RUN_LIMIT-this.MIN_RUN_LIMIT)*this.rnd.nextDouble();
        this.maxJumpHeight = this.MIN_JUMP_LIMIT + (this.MAX_JUMP_LIMIT-this.MIN_JUMP_LIMIT)*this.rnd.nextDouble();
        this.maxSwimDistance = this.MIN_SWIM_LIMIT + (this.MAX_SWIM_LIMIT-this.MIN_SWIM_LIMIT)*this.rnd.nextDouble();
    }

    @Override
    public String toString() {
        return "Конь " + name;
    }

    public boolean jump(double height) {
        return (height <= this.maxJumpHeight);
    }

    public boolean run(double dist) {
        return (dist <= this.maxRunDistance);
    }

    public boolean swim(double dist) {
        return (dist <= this.maxSwimDistance);
    }
}
