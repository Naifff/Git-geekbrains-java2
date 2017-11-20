package ru.geekbrains.java2.dz.dz1.FedulovMS.AnimalRaces;

import java.util.Random;

public abstract class Animal {
    protected String name;
    protected String animType;
    protected double maxRunDistance = 0;
    protected double maxJumpHeight = 0;
    protected double maxSwimDistance = 0;
    protected double maxFlyDistance = 0;
    protected double maxFlyHeight = 0;

    protected Random rnd;

    public Animal(String name) {
        this.name = name;
        this.rnd = new Random();
    }

    public Animal() {
        this.name = "Unknown";
        this.rnd = new Random();
    }

    public void printInfo(){
        System.out.println(this);

        if (this instanceof Runable) {
            System.out.printf("    Может пробежать до %.2f м.\n", this.maxRunDistance);
        }

        if (this instanceof Jumpable) {
            System.out.printf("    Может перепрыгнуть препятствие до %.2f м.\n", this.maxJumpHeight);
        }

        if (this instanceof Swimable) {
            System.out.printf("    Может проплыть до %.2f м.\n", this.maxSwimDistance);
        }

        if (this instanceof Flyable) {
            System.out.printf("    Может пролететь до %.2f м. и перелететь препятствие до %.2f м.\n",
                    this.maxFlyDistance,
                    this.maxFlyHeight);
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void info() {
        System.out.println(animType + " " + name);
    }

    public boolean cross(Barrier b){
        boolean success;
        switch(b.howToDealWith()) {
            case 'r':
                if (this instanceof Runable) {
                    success = ((Runable) this).run(b.getSize());
                    System.out.print((success?"успешно пробегает ":"не может пробежать ") + b.getSize() + " м.");
                } else if (this instanceof Flyable) {
                    success = ((Flyable) this).fly_f(b.getSize());
                    System.out.print((success?"успешно пролетает ":"не может пролететь ") + b.getSize() + " м.");
                } else {
                    success = false;
                    System.out.print("не умеет бегать");
                }
                break;
            case 'j':
                if (this instanceof Jumpable) {
                    success = ((Jumpable) this).jump(b.getSize());
                    System.out.print((success?"успешно перепрыгивает ":"не может перепрыгнуть ") + b.getSize() + " м.");
                } else if (this instanceof Flyable) {
                    success = ((Flyable) this).fly_h(b.getSize());
                    System.out.print((success?"успешно перелетает ":"не может перелететь ") + b.getSize() + " м.");
                } else {
                    success = false;
                    System.out.print("не умеет прыгать");
                }
                break;
            case 's':
                if (this instanceof Swimable) {
                    success = ((Swimable) this).swim(b.getSize());
                    System.out.print((success?"успешно проплывает ":"не может проплыть ") + b.getSize() + " м.");
                } else if (this instanceof Flyable) {
                    success = ((Flyable) this).fly_f(b.getSize());
                    System.out.print((success?"успешно пролетает ":"не может пролететь ") + b.getSize() + " м.");
                } else {
                    success = false;
                    System.out.print("не умеет плавать");
                }
                break;
            default:
                success = false;
        }
        return success;
    }
}

