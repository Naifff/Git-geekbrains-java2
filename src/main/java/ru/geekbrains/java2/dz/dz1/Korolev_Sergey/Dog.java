package ru.geekbrains.java2.dz.dz1.Korolev_Sergey;

public class Dog extends Animal implements Courses {

    double maxRunDistance; // Расстояние на которое может бегать
    double maxJump;        // Высота на которую может прыгать
    //double runDist;        // Заданная дистанция
    //double jumpDist;       // Заданная высота

    Dog(double runDist, double jumpDist) {
        maxRunDistance = 200;
        maxJump = 1.5;
        this.runDist = runDist;
        this.jumpDist = jumpDist;
    }

    public boolean isOnDistance() {
        return onDistance;
    }
    public void getOutFromDistance(String reason) {
        System.out.println("Dog " + reason + " fail");
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
            System.out.println("\nDog \nRun: " + maxRunDistance + " Jump: " + maxJump
                    + "\nDistance: " + "\nRun: "+ runDist + " Jump: " + jumpDist);
        }
    }

