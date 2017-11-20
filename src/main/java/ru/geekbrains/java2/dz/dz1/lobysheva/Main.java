package ru.geekbrains.java2.dz.dz1.lobysheva;

/*
 * Created by Oxana Lobysheva on 19/11/2017.
 */

public class Main {

    public static void main(String[] arg) {

        int countPlayers = 4;

        Team team = new Team("Dream Team", countPlayers);
        team.printTeamInfo();

        System.out.println();

        Course course_1 = new Course(400,0.7f,100);
        course_1.printCourseInfo();

        course_1.dolt(team);
        team.printWinners();
        team.printTeamInfo();


    }

}

