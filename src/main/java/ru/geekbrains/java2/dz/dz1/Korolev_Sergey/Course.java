package ru.geekbrains.java2.dz.dz1.Korolev_Sergey;

public class Course implements Courses {

    double runDist;
    double jumpDist;

    Course(){
        this.runDist = runDist;
        this.jumpDist = jumpDist;
    }

    // Реализация интерфейса

    public void run(){
        if(runDist < 15){
            System.out.println("run ok");
        } else {
            System.out.println("run is not ok");
        }
    }

    public void jump(){
        if(jumpDist < 2){
            System.out.println("jump ok");
        } else {
            System.out.println("jump is not ok");
        }
    }


}
