package ru.geekbrains.java2.dz.dz1.lobysheva;

/*
 * Created by Oxana Lobysheva on 19/11/2017.
 */

import ru.geekbrains.java2.lesson1.Human;

import java.util.Random;


public class Team extends Human{

    private String teamName;
    private Human[] players;

    public Team(String teamName, int countPlayers){
        this.teamName = teamName;
        if (countPlayers < 1) countPlayers = 0;
        players = new Human[countPlayers];
        for (int i = 0; i < countPlayers; i++){
            players[i] = new Human("Player_" + (i+1));
            players[i].setEndurance(new Random().nextInt(10000));
        }
    }

    public void printTeamInfo(){
        System.out.println("Team name = " + teamName);
        for (Human player : players){
            player.info();
            System.out.println("Endurance = " + player.getEndurance());
        }
    }

    public Human[] getPlayers(){
        return players;
    }

    public void printWinners(){
        System.out.println("------------ WINNERS ---------------");
        for (int i = 0; i < players.length; i++){
            if (players[i].getEndurance() >= 0){
                System.out.println(players[i].getName() + " is a winner");
            }
        }
        System.out.println("------------------------------------");
    }
}
