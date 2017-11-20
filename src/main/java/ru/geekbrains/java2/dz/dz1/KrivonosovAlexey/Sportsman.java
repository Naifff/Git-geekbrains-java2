package ru.geekbrains.java2.dz.dz1.KrivonosovAlexey;

import java.util.Random;

public class Sportsman {
    private String name;
    private int jumpHeight, runDistance, swimDistance;
    Random rd = new Random();

    public Sportsman(String name){
        this.jumpHeight = rd.nextInt(10)+12;
        this.runDistance = rd.nextInt(10)*100+1200;
        this.swimDistance = rd.nextInt(10)*10+50;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getJumpHeight() {
        return jumpHeight;
    }

    public int getRunDistance() {
        return runDistance;
    }

    public int getSwimDistance() {
        return swimDistance;
    }

    public void getInfo(){
        System.out.println("Имя спортсмена: " + name);
        System.out.println("Дистанция бега: " + this.runDistance);
        System.out.println("Высота прыжка: " + this.jumpHeight);
        System.out.println("Дистанция плавания: " + this.swimDistance);
        System.out.println();
    }

    public String getName() {
        return name;
    }




}
