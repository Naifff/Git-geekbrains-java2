package ru.geekbrains.java2.dz.dz1.Korolev_Sergey;

public class Human extends Animal implements Courses {

    double maxRunDistance; // Расстояние на которое может бегать
    double maxJump;        // Высота на которую может прыгать
    //double runDist;        // Заданная дистанция
    //double jumpDist;       // Заданная высота

    Human(double runDist, double jumpDist) {
        maxRunDistance = 2000;
        maxJump = 2.5;
        this.runDist = runDist;
        this.jumpDist = jumpDist;
    }

    public boolean isOnDistance() {
        return onDistance;
    }
    public void getOutFromDistance(String reason) {
        System.out.println("Human " + reason + " fail");
        onDistance = false;
    }

    // Реализация интерфейса

    public void run() {
        if (runDist < maxRunDistance) {
            System.out.println("run ok");
        } else {
            getOutFromDistance("run");
        }
    }

    public void jump() {
        if (jumpDist < maxJump) {
            System.out.println("jump ok");
        } else {
            getOutFromDistance("jump");
        }
    }

    void info(){
        System.out.println("\nHuman \nRun: " + maxRunDistance + " Jump: " + maxJump
                + "\nDistance: " + "\nRun: "+ runDist + " Jump: " + jumpDist);
    }
}


