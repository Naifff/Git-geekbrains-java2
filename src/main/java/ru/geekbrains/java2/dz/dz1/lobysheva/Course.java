package ru.geekbrains.java2.dz.dz1.lobysheva;

/*
 * Created by Oxana Lobysheva on 19/11/2017.
 */

import ru.geekbrains.java2.lesson1.Human;

public class Course {

    private float distanceSwim;
    private float distanceJump;
    private float distanceCross;

    public Course(float distanceSwim, float distanceJump, float distanceCross){
        setDistanceSwim(distanceSwim);
        setDistanceJump(distanceJump);
        setDistanceCross(distanceCross);
    }

    public void printCourseInfo(){
        System.out.println("------------- COURSE  --------------");
        System.out.println("Distance for SWIM = " + distanceSwim);
        System.out.println("Distance for JUMP = " + distanceJump);
        System.out.println("Distance for CROSS = " + distanceCross);
        System.out.println("------------------------------------");
    }

    public void setDistanceSwim(float distanceSwim){
        if (distanceSwim > 0){
            this.distanceSwim = distanceSwim;
        } else {
            this.distanceSwim = 0;
        }
    }

    public void setDistanceJump(float distanceJump){
        if (distanceJump > 0){
            this.distanceJump = distanceJump;
        } else {
            this.distanceJump = 0;
        }
    }

    public void setDistanceCross(float distanceCross){
        if (distanceCross > 0){
            this.distanceCross = distanceCross;
        } else {
            this.distanceCross = 0;
        }
    }


    public void dolt(Team team){
        Human[] players = team.getPlayers();
        for (int i = 0; i < players.length; i++){
            players[i].swim(distanceSwim);
            players[i].jump(distanceJump);
            players[i].cross(distanceCross);
        }
    }

}
