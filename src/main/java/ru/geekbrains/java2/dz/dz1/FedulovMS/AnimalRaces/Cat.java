package ru.geekbrains.java2.dz.dz1.FedulovMS.AnimalRaces;

public class Cat extends Animal implements Runable, Jumpable {
    protected final double MAX_RUN_LIMIT = 500;
    protected final double MIN_RUN_LIMIT = 250;
    protected final double MAX_JUMP_LIMIT = 3.0;
    protected final double MIN_JUMP_LIMIT = 1.5;

    public Cat(String name) {
        super(name);
        this.animType = "ru.geekbrains.java2.dz.dz1.FedulovMS.AnimalRaces.Cat";
        this.maxRunDistance = this.MIN_RUN_LIMIT + (this.MAX_RUN_LIMIT-this.MIN_RUN_LIMIT)*this.rnd.nextDouble();
        this.maxJumpHeight = this.MIN_JUMP_LIMIT + (this.MAX_JUMP_LIMIT-this.MIN_JUMP_LIMIT)*this.rnd.nextDouble();
    }

    @Override
    public String toString() {
        return "Кот " + name;
    }

    public boolean jump(double height) {
        return (height <= this.maxJumpHeight);
    }

    public boolean run(double dist) {
        return (dist <= this.maxRunDistance);
    }
}
