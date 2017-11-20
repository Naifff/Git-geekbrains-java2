package ru.geekbrains.java2.dz.dz1.RonaldKirka;

import java.util.Random;

import static ru.geekbrains.java2.dz.dz1.RonaldKirka.Main.myTeam;
import static ru.geekbrains.java2.dz.dz1.RonaldKirka.Team.Contestants;


public class Course {

    static boolean[] finish = new boolean[4];


    String teamName = Main.myTeam.teamName;
    String name1 = Main.myTeam.name1;
    String name2 = Main.myTeam.name2;
    String name3 = Main.myTeam.name3;
    String name4 = Main.myTeam.name4;

    Team myTeam = new Team (teamName, name1, name2, name3, name4);

    String[] course = new String[5];

    void whoFinished(){
        for(int i = 0; i < finish.length; i++){
            double rand = (int)(Math.random() * 10 + 1);
            if(rand < 7){
                finish[i] = true;
            }
            else{
                finish[i] = false;
            }
        }
    }

    Course(){
        course[0] = "Бег";
        course[1] = "Лазание";
        course[2] = "Плавание";
        course[3] = "Стрельба";
        course[4] = "Скачки";

    }


    void Start(){


        myTeam.AllInfo();

    }


}
