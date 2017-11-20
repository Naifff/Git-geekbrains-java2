package ru.geekbrains.java2.dz.dz1.Korolev_Sergey;

public class Cat extends Animal implements Courses {

    double maxRunDistance; // Расстояние на которое может бегать
    double maxJump;        // Высота на которую может прыгать
    boolean onDistance;    // true - удачная попытка;
    // double runDist;        // Заданная дистанция
    // double jumpDist;       // Заданная высота

    Cat(double runDist, double jumpDist){
        maxRunDistance = 100;
        maxJump = 2.0;
        this.runDist = runDist;
        this.jumpDist = jumpDist;
    }

    public boolean isOnDistance() {
        return onDistance;
    }
    public void getOutFromDistance(String reason) {
        System.out.println("Cat " + reason + " fail");
        onDistance = false;
    }

    // Реализация интерфейса

    public void run(){
        if(runDist < maxRunDistance){
            System.out.println("run ok");
        } else {
            getOutFromDistance("run");
        }
    }

    public void jump(){
        if(jumpDist < maxJump){
            System.out.println("jump ok");
        } else {
            getOutFromDistance("jump");
        }
    }

    void info(){
        System.out.println("\nCat \nRun: " + maxRunDistance + " Jump: " + maxJump
        + "\nDistance: " + "\nRun: "+ runDist + " Jump: " + jumpDist);
    }
}
