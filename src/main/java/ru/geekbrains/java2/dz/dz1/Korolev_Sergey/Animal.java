package ru.geekbrains.java2.dz.dz1.Korolev_Sergey;

public abstract class Animal implements Courses {

    String animType;
    double maxRunDistance; // Расстояние на которое может бегать
    double maxJump;        // Высота на которую может прыгать
    boolean onDistance;

    double runDist;        // Заданная дистанция
    double jumpDist;       // Заданная высота

    public void getOutFromDistance(String reason) {}

    // Реализация интерфейса

    public boolean isOnDistance() {
        return onDistance;
    }
    public void run() {
    }

    public void jump() {
    }

    void info() {
    }
}
