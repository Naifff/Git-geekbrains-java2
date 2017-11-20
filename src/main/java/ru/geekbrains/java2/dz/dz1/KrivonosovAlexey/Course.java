package ru.geekbrains.java2.dz.dz1.KrivonosovAlexey;

import java.util.Random;

public class Course {
    private int jumpHeight, runDistance, swimDistance;
    Random rd = new Random();

    public Course(){
        this.jumpHeight = rd.nextInt(5)+10;
        this.runDistance = rd.nextInt(5)*100+1000;
        this.swimDistance = rd.nextInt(5)*10+50;
    }

    public void dolt(Team team){
        if(team.checkCourse == true){
            System.out.println("Команда " + team.getTeamName() + "Уже прошла полосу препятствий");
        } else{
            for (int i = 0; i < team.getNumberOfSportsmans() ; i++) {
               if(team.sportsmansBlank[i].getJumpHeight() >= this.jumpHeight && team.sportsmansBlank[i].getRunDistance() >= this.runDistance && team.sportsmansBlank[i].getSwimDistance() >= this.swimDistance){
                   team.results[i] = 1;
               }
            }
            team.checkCourse = true;
        }
    }

    public void getCourseInfo(){
        System.out.println("#####Информация о полосе препятствий#####");
        System.out.println("Дистанция бега: " + this.runDistance);
        System.out.println("Высота прыжка: " + this.jumpHeight);
        System.out.println("Дистанция плавания: " + this.swimDistance);
        System.out.println();
    }
}
