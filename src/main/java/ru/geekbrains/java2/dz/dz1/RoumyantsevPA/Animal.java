package ru.geekbrains.java2.dz.dz1.RoumyantsevPA;

public abstract class Animal implements TeamMember{
    protected String name;
    protected String animType;
    protected boolean onDistance;
    protected float maxRunDistance=0;
    protected float maxJumpHeight=0;
    protected float maxSwimDistance=0;

    public Animal(String name) {
        this.name = name;
    }



//    abstract void printInfo();

    public boolean isOnDistance() {
        return onDistance;
    }

    public void getOutFromDistance(String reason) {
        System.out.println(animType + " " + name + " " + reason + " fail");
        onDistance = false;
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

    public void cross(float dist) {
        if(dist < maxRunDistance) {
            System.out.println(animType + " cross ok");
        } else {
            getOutFromDistance("cross");
        }
    }

    public void run(float distance) {
        if (distance<= this.maxRunDistance){
            System.out.println("Бег - PASS");
        }else {this.onDistance=false;
            System.out.println("Бег - FAILED");
        }

    }

    public void jump(float height) {
        if (height<= this.maxJumpHeight){
            System.out.println("Прыжок - PASS");
        }else {this.onDistance=false;
            System.out.println("Прыжок - FAILED");
        }

    }

    public void swim(float distance) {
        if (distance<= this.maxSwimDistance){
            System.out.println("Плыть - PASS");
        }else {this.onDistance=false;
            System.out.println("Плыть - FAILED");
        }

    }
}

