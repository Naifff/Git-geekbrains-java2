package ru.geekbrains.java2.dz.dz1.Korolev_Sergey;

public class Horse extends Animal implements Courses {

    double maxRunDistance; // Расстояние на которое может бегать
    double maxJump;        // Высота на которую может прыгать
    //double runDist;        // Заданная дистанция
    //double jumpDist;       // Заданная высота

    Horse(double runDist, double jumpDist){
        maxRunDistance = 1500;
        maxJump = 2.5;
        this.runDist = runDist;
        this.jumpDist = jumpDist;
    }

    public boolean isOnDistance() {
        return onDistance;
    }
    public void getOutFromDistance(String reason) {
        System.out.println("Horse " + reason + " fail");
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
        System.out.println("\nHorse \nRun: " + maxRunDistance + " Jump: " + maxJump
                + "\nDistance: " + "\nRun: "+ runDist + " Jump: " + jumpDist);
    }

}
