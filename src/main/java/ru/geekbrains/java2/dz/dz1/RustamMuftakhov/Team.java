package ru.geekbrains.java2.dz.dz1.RustamMuftakhov;

public class Team {

    protected String teamName;
    Player[] team = new Player[4];

    public Team (String teamName, Player player1, Player player2, Player player3, Player player4){

        this.teamName = teamName;
        team[0] = player1;
        team[1] = player2;
        team[2] = player3;
        team[3] = player4;

    }

    public void whoPassedTheCourse(){

        for (int i = 0; i < 4; i++) {

            if (team[i].ready == true) System.out.println(team[i].name + " passed the course!");

        }

    }

    public void teamInfo(){

        for (int i = 0; i < 4; i++) {

            System.out.print("Name - " + team[i].name + "; ");
            System.out.print("Ability to run - " + team[i].enduranceRun + "; ");
            System.out.print("Ability to swim - " + team[i].enduranceSwim + "; ");
            System.out.print("Ability to jump - " + team[i].enduranceJump + "; ");

            if (team[i].ready == true) System.out.print("In good shape");
            else System.out.print("Tired");

            System.out.println();

        }

    }

}
