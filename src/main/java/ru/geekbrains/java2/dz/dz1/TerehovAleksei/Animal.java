package ru.geekbrains.java2.dz.dz1.TerehovAleksei;

public class Animal implements Jumpable, Runnable, Swimable {

    protected String name;
    protected boolean onDistance;
    protected int maxRunDistance;
    protected int maxSwimDistance;
    protected int maxJumpHeight;

    public Animal(String name) {
        this.name = name;
        onDistance = true;
    }

    public void getName() {
        System.out.println(name);
    }

    public boolean isOnDistance() {
        return onDistance;
    }

    public void getOutFromDistance(String reason) {
        System.out.println(name + " " + reason + " fail");
        onDistance = false;
    }

    @Override
    public void Jump(int height) {
        if (height <= maxJumpHeight) {
            System.out.println(name + " jump ok!");
        } else {
            getOutFromDistance("jump");
        }
    }

    @Override
    public void Run(int distance) {
        if (distance <= maxRunDistance) {
            System.out.println(name + " run ok!");
        } else {
            getOutFromDistance("run");
        }
    }

    @Override
    public void Swim(int distance) {
        if (distance <= maxSwimDistance) {
            System.out.println(name + " swim ok!");
        } else {
            getOutFromDistance("swim");
        }
    }
}
